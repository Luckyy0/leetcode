package leetcode.P149_MaxPointsOnALine;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 149: Max Points on a Line
     * Approach: Fix one point and use a HashMap to store slopes of other points.
     * 
     * Theoretical Basis:
     * - A line is defined by a point and a slope.
     * - For each point i, calculate slopes with all points j > i.
     * - Use GCD to store slope as a pair/string to avoid precision issues.
     * 
     * Time Complexity: O(N^2 * log(maxVal))
     * Space Complexity: O(N)
     */
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2)
            return n;

        int maxPoints = 0;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Simplify slope using GCD
                int common = gcd(dx, dy);
                String slope = (dx / common) + "_" + (dy / common);

                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }

            // Add 1 to include the current point (anchor)
            maxPoints = Math.max(maxPoints, localMax + 1);
        }

        return maxPoints;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,1],[2,2],[3,3]] -> 3
        int[][] p1 = { { 1, 1 }, { 2, 2 }, { 3, 3 } };
        System.out.println("Test 1: " + solution.maxPoints(p1));

        // [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]] -> 4
        int[][] p2 = { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        System.out.println("Test 2: " + solution.maxPoints(p2));
    }
}
