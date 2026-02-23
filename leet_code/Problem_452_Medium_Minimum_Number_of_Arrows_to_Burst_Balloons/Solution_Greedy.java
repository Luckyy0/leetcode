package leet_code.Problem_452_Medium_Minimum_Number_of_Arrows_to_Burst_Balloons;

import java.util.*;

public class Solution_Greedy {

    /**
     * Finds the minimum number of arrows to burst all balloons.
     * Strategy: Sort by end coordinates and place arrows at the end of balloons.
     * Time: O(N log N), Space: O(1).
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        // Sort by end coordinate. Use Integer.compare to avoid subtraction overflow
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int currentEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            // If the next balloon starts after the current arrow position
            if (points[i][0] > currentEnd) {
                arrows++;
                currentEnd = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();
        int[][] pts = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println("Result: " + solution.findMinArrowShots(pts)); // 2
    }
}
