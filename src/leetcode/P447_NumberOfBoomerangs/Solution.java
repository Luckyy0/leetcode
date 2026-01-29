package leetcode.P447_NumberOfBoomerangs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 447: Number of Boomerangs
     * Approach: Squared Distance Counting
     * 
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public int numberOfBoomerangs(int[][] points) {
        int total = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;

                int distSq = getDistSq(points[i], points[j]);
                map.put(distSq, map.getOrDefault(distSq, 0) + 1);
            }

            for (int count : map.values()) {
                // Number of pairs from count items where order matters
                total += count * (count - 1);
            }
        }

        return total;
    }

    private int getDistSq(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[0,0],[1,0],[2,0]] -> 2
        int[][] points1 = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        runTest(sol, points1, 2);

        // [[1,1],[2,2],[3,3]] -> 2
        int[][] points2 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        runTest(sol, points2, 2);
    }

    private static void runTest(Solution sol, int[][] points, int expected) {
        int result = sol.numberOfBoomerangs(points);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
