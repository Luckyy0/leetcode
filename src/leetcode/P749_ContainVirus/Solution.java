package leetcode.P749_ContainVirus;

import java.util.*;

class Solution {
    int m, n;
    int[][] grid;
    boolean[][] visited;

    public int containVirus(int[][] isInfected) {
        grid = isInfected;
        m = grid.length;
        n = grid[0].length;
        int totalWalls = 0;

        while (true) {
            visited = new boolean[m][n];
            List<Set<Integer>> regions = new ArrayList<>();
            List<Set<Integer>> neighbors = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> neighborSet = new HashSet<>();
                        int[] wallCount = { 0 };
                        dfs(r, c, region, neighborSet, wallCount);
                        regions.add(region);
                        neighbors.add(neighborSet);
                        walls.add(wallCount[0]);
                    }
                }
            }

            if (regions.isEmpty())
                break;

            // Pick region with most neighbors
            // Chọn vùng có nhiều hàng xóm nhất
            int bestIdx = 0;
            for (int i = 1; i < neighbors.size(); i++) {
                if (neighbors.get(i).size() > neighbors.get(bestIdx).size()) {
                    bestIdx = i;
                }
            }

            if (neighbors.get(bestIdx).isEmpty())
                break;

            totalWalls += walls.get(bestIdx);

            // Contain the best region
            // Ngăn chặn vùng tốt nhất
            for (int pos : regions.get(bestIdx)) {
                grid[pos / n][pos % n] = -1; // -1 means contained
            }

            // Spread other regions
            // Lây lan các vùng khác
            for (int i = 0; i < regions.size(); i++) {
                if (i == bestIdx)
                    continue;
                for (int pos : neighbors.get(i)) {
                    grid[pos / n][pos % n] = 1;
                }
            }
        }

        return totalWalls;
    }

    private void dfs(int r, int c, Set<Integer> region, Set<Integer> neighbors, int[] walls) {
        visited[r][c] = true;
        region.add(r * n + c);
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc, region, neighbors, walls);
                } else if (grid[nr][nc] == 0) {
                    neighbors.add(nr * n + nc);
                    walls[0]++;
                }
            }
        }
    }
}
