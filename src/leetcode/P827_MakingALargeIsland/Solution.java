package leetcode.P827_MakingALargeIsland;

import java.util.*;

class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandId = 2;
        int maxArea = 0;

        // 1. Label islands and find areas
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(grid, r, c, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }

        // 2. Try flipping each '0'
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    if (r > 0 && grid[r - 1][c] > 1)
                        neighbors.add(grid[r - 1][c]);
                    if (r < n - 1 && grid[r + 1][c] > 1)
                        neighbors.add(grid[r + 1][c]);
                    if (c > 0 && grid[r][c - 1] > 1)
                        neighbors.add(grid[r][c - 1]);
                    if (c < n - 1 && grid[r][c + 1] > 1)
                        neighbors.add(grid[r][c + 1]);

                    int currentArea = 1;
                    for (int id : neighbors) {
                        currentArea += areaMap.get(id);
                    }
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int id) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = id;
        return 1 + dfs(grid, r - 1, c, id) + dfs(grid, r + 1, c, id) +
                dfs(grid, r, c - 1, id) + dfs(grid, r, c + 1, id);
    }
}
