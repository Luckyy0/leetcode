package leetcode.P296_BestMeetingPoint;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Problem 296: Best Meeting Point
     * Approach: Median of Indepedent Coordinates
     * 
     * Theoretical Basis:
     * - Minimize sum(|x - p|) -> p is median.
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(M + N) - Actually O(Number of friends), worst case MN
     */
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        int m = grid.length;
        int n = grid[0].length;

        // Collect Row coordinates (already sorted if we iterate row by row)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                }
            }
        }

        // Collect Col coordinates (iterate col by col to get sorted)
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    cols.add(j);
                }
            }
        }

        return minDistance1D(rows) + minDistance1D(cols);
    }

    private int minDistance1D(List<Integer> points) {
        int distance = 0;
        int i = 0;
        int j = points.size() - 1;

        while (i < j) {
            distance += points.get(j) - points.get(i);
            i++;
            j--;
        }

        return distance;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]] -> 6
        int[][] grid1 = {
                { 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0 }
        };
        runTest(solution, grid1, 6);

        // [[1,1]] -> 1
        int[][] grid2 = { { 1, 1 } };
        runTest(solution, grid2, 1);
    }

    private static void runTest(Solution s, int[][] grid, int expected) {
        int result = s.minTotalDistance(grid);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
