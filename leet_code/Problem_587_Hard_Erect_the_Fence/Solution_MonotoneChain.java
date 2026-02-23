package leet_code.Problem_587_Hard_Erect_the_Fence;

import java.util.*;

public class Solution_MonotoneChain {

    /**
     * Finds the trees on the convex hull boundary.
     * Strategy: Monotone Chain (Andrew's Algorithm).
     * Time: O(N log N), Space: O(N).
     */
    public int[][] outerTrees(int[][] trees) {
        int n = trees.length;
        if (n <= 3)
            return trees;

        // Sort by x, then y
        Arrays.sort(trees, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        List<int[]> hull = new ArrayList<>();

        // Build lower hull
        for (int i = 0; i < n; i++) {
            while (hull.size() >= 2
                    && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) < 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(trees[i]);
        }

        // Build upper hull
        for (int i = n - 2; i >= 0; i--) {
            while (hull.size() >= 2
                    && crossProduct(hull.get(hull.size() - 2), hull.get(hull.size() - 1), trees[i]) < 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(trees[i]);
        }

        // Remove duplicates (endpoints are added twice)
        Set<List<Integer>> uniquePoints = new HashSet<>();
        List<int[]> result = new ArrayList<>();
        for (int[] p : hull) {
            List<Integer> point = Arrays.asList(p[0], p[1]);
            if (uniquePoints.add(point)) {
                result.add(p);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    /**
     * Cross product of (b-a) and (c-b).
     * > 0: counter-clockwise (left turn)
     * < 0: clockwise (right turn)
     * = 0: collinear
     */
    private int crossProduct(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0]);
    }

    public static void main(String[] args) {
        Solution_MonotoneChain solution = new Solution_MonotoneChain();
        int[][] points = { { 1, 1 }, { 2, 2 }, { 2, 0 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
        int[][] res = solution.outerTrees(points);
        for (int[] p : res) {
            System.out.println(Arrays.toString(p));
        }
    }
}
