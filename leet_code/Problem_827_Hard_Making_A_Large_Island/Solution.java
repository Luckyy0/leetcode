package leet_code.Problem_827_Hard_Making_A_Large_Island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * Finds the size of the largest island after flipping at most one 0 to 1.
     * Strategy: Label all existing islands and store their areas.
     * Then, for each 0, check how many unique islands it can connect.
     * Time: O(N^2), Space: O(N^2).
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        // Map to store island ID -> Area
        Map<Integer, Integer> islandAreaMap = new HashMap<>();
        // Start island IDs from 2 to avoid confusion with 0 and 1
        int islandId = 2;
        int maxAreaFound = 0;

        // Step 1: Label all islands and pre-calculate their areas
        // Also tracks the current max area in case no 0 exists
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = calculateAreaAndLabel(grid, r, c, islandId);
                    islandAreaMap.put(islandId, area);
                    maxAreaFound = Math.max(maxAreaFound, area);
                    islandId++;
                }
            }
        }

        // Step 2: Iterate through each 0 and see the potential area if flipped
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    // Collect unique island IDs from 4 directions
                    Set<Integer> adjacentIslands = new HashSet<>();
                    for (int[] dir : DIRECTIONS) {
                        int nr = r + dir[0];
                        int nc = c + dir[1];
                        if (isValid(nr, nc, n) && grid[nr][nc] > 1) {
                            adjacentIslands.add(grid[nr][nc]);
                        }
                    }

                    // Combined area = the flipped 0 cell (1) + sum of distinct adjacent islands
                    int combinedArea = 1;
                    for (int id : adjacentIslands) {
                        combinedArea += islandAreaMap.get(id);
                    }
                    maxAreaFound = Math.max(maxAreaFound, combinedArea);
                }
            }
        }

        return maxAreaFound;
    }

    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private int calculateAreaAndLabel(int[][] grid, int r, int c, int id) {
        if (!isValid(r, c, grid.length) || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = id; // Label the cell with ID
        int area = 1;
        for (int[] d : DIRECTIONS) {
            area += calculateAreaAndLabel(grid, r + d[0], c + d[1], id);
        }
        return area;
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 1, 0 }, { 0, 1 } };
        System.out.println("Result 1: " + sol.largestIsland(g1)); // 3

        int[][] g2 = { { 1, 1 }, { 1, 0 } };
        System.out.println("Result 2: " + sol.largestIsland(g2)); // 4

        int[][] g3 = { { 1, 1 }, { 1, 1 } };
        System.out.println("Result 3: " + sol.largestIsland(g3)); // 4
    }
}
