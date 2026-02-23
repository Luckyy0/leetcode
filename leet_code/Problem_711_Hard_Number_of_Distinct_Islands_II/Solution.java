package leet_code.Problem_711_Hard_Number_of_Distinct_Islands_II;

import java.util.*;

public class Solution {

    /**
     * Finds the number of distinct islands allowing translation, rotation, and
     * reflection.
     * Strategy: Canonical normalization using all 8 symmetries.
     * Time: O(M * N * log(M * N)), Space: O(M * N).
     */
    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<String> distinctIslands = new HashSet<>();
        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    List<int[]> island = new ArrayList<>();
                    dfs(grid, r, c, visited, island);
                    distinctIslands.add(getCanonicalRepresentation(island));
                }
            }
        }
        return distinctIslands.size();
    }

    private void dfs(int[][] grid, int r, int c, boolean[][] visited, List<int[]> island) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        island.add(new int[] { r, c });
        dfs(grid, r + 1, c, visited, island);
        dfs(grid, r - 1, c, visited, island);
        dfs(grid, r, c + 1, visited, island);
        dfs(grid, r, c - 1, visited, island);
    }

    private String getCanonicalRepresentation(List<int[]> island) {
        List<String> symmetries = new ArrayList<>();
        int[][] directions = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        // Generate 8 symmetries (4 rotations x 2 reflections indirectly via x/y swap)
        for (int[] d : directions) {
            symmetries.add(normalize(island, d[0], d[1], false)); // (dx*x, dy*y)
            symmetries.add(normalize(island, d[0], d[1], true)); // (dx*y, dy*x)
        }

        Collections.sort(symmetries);
        return symmetries.get(0); // Return the lexicographically smallest
    }

    private String normalize(List<int[]> island, int dx, int dy, boolean swap) {
        List<int[]> points = new ArrayList<>();
        for (int[] p : island) {
            int x = swap ? p[1] * dx : p[0] * dx;
            int y = swap ? p[0] * dy : p[1] * dy;
            points.add(new int[] { x, y });
        }

        // Sort points to make normalization consistent
        points.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // Shift to (0, 0)
        int minX = points.get(0)[0];
        int minY = points.get(0)[1];
        for (int[] p : points) {
            if (p[1] < minY)
                minY = p[1];
        }

        StringBuilder sb = new StringBuilder();
        for (int[] p : points) {
            sb.append(p[0] - minX).append(",").append(p[1] - minY).append(":");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] grid1 = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println("Result 1: " + sol.numDistinctIslands2(grid1)); // 1

        int[][] grid2 = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 }
        };
        System.out.println("Result 2: " + sol.numDistinctIslands2(grid2)); // 2
    }
}
