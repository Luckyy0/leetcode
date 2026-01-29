package leetcode.P452_MinimumNumberOfArrowsToBurstBalloons;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 452: Minimum Number of Arrows to Burst Balloons
     * Approach: Greedy (Sort by End coordinate)
     * 
     * Time Complexity: O(N log N)
     * Space Complexity: O(1) or O(log N)
     */
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;

        // Sort by end coordinate. Use Integer.compare to handle negative
        // values/overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastArrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the last arrow position, we need a new
            // arrow
            if (points[i][0] > lastArrowPos) {
                arrows++;
                lastArrowPos = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [[10,16],[2,8],[1,6],[7,12]] -> 2
        int[][] p1 = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        runTest(sol, p1, 2);

        // [[1,2],[3,4],[5,6],[7,8]] -> 4
        int[][] p2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
        runTest(sol, p2, 4);

        // [[1,2],[2,3],[3,4],[4,5]] -> 2
        int[][] p3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        runTest(sol, p3, 2);
    }

    private static void runTest(Solution sol, int[][] points, int expected) {
        int result = sol.findMinArrowShots(points);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
