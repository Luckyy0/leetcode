package leetcode.P356_LineReflection;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Problem 356: Line Reflection
     * Approach: HashSet + Boundary Check
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<String> set = new HashSet<>();

        for (int[] p : points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            set.add(p[0] + "," + p[1]);
        }

        long sum = minX + maxX; // Use long to avoid overflow

        for (int[] p : points) {
            long targetX = sum - p[0];
            if (!set.contains(targetX + "," + p[1])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,1],[-1,1]] -> true (Line x=0)
        runTest(solution, new int[][] { { 1, 1 }, { -1, 1 } }, true);

        // [[1,1],[-1,-1]] -> false
        runTest(solution, new int[][] { { 1, 1 }, { -1, -1 } }, false);
    }

    private static void runTest(Solution s, int[][] points, boolean expected) {
        boolean result = s.isReflected(points);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
