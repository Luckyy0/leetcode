package leetcode.P469_ConvexPolygon;

import java.util.List;
import java.util.ArrayList;

public class Solution {

    /**
     * Problem 469: Convex Polygon
     * Approach: Cross Product of consecutive segments
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public boolean isConvex(List<List<Integer>> points) {
        int n = points.size();
        long prevSign = 0;

        for (int i = 0; i < n; i++) {
            List<Integer> p1 = points.get(i);
            List<Integer> p2 = points.get((i + 1) % n);
            List<Integer> p3 = points.get((i + 2) % n);

            long cp = crossProduct(p1, p2, p3);

            if (cp != 0) {
                if (prevSign == 0) {
                    prevSign = cp;
                } else if (prevSign * cp < 0) {
                    // Sign flipped! Not convex
                    return false;
                }
            }
        }

        return true;
    }

    private long crossProduct(List<Integer> a, List<Integer> b, List<Integer> c) {
        long x1 = b.get(0) - a.get(0);
        long y1 = b.get(1) - a.get(1);
        long x2 = c.get(0) - b.get(0);
        long y2 = c.get(1) - b.get(1);
        return x1 * y2 - x2 * y1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[0,0],[1,0],[1,1],[0,1]] -> true
        List<List<Integer>> p1 = new ArrayList<>();
        p1.add(java.util.Arrays.asList(0, 0));
        p1.add(java.util.Arrays.asList(1, 0));
        p1.add(java.util.Arrays.asList(1, 1));
        p1.add(java.util.Arrays.asList(0, 1));
        System.out.println("Result: " + sol.isConvex(p1) + " (Expected: true)");

        // [[0,0],[0,10],[10,10],[10,0],[5,5]] -> false
        List<List<Integer>> p2 = new ArrayList<>();
        p2.add(java.util.Arrays.asList(0, 0));
        p2.add(java.util.Arrays.asList(0, 10));
        p2.add(java.util.Arrays.asList(10, 10));
        p2.add(java.util.Arrays.asList(10, 0));
        p2.add(java.util.Arrays.asList(5, 5));
        System.out.println("Result: " + sol.isConvex(p2) + " (Expected: false)");
    }
}
