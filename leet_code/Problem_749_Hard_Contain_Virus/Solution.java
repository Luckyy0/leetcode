package leet_code.Problem_749_Hard_Contain_Virus;

import java.util.*;

public class Solution {

    private int m, n;
    private int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    /**
     * Calculates walls needed to contain the virus.
     * Strategy: Simulation. Identify regions, evaluate threats, contain worst,
     * spread rest.
     * Time: O((M*N)^2), Space: O(M*N).
     */
    public int containVirus(int[][] isInfected) {
        m = isInfected.length;
        n = isInfected[0].length;
        int totalWalls = 0;

        while (true) {
            // Identify all virus regions
            List<Set<Integer>> regions = new ArrayList<>();
            // For each region, track the set of threatened (neighboring 0s) indices
            List<Set<Integer>> threats = new ArrayList<>();
            // For each region, count walls (total edges touching 0s)
            List<Integer> walls = new ArrayList<>();

            boolean[][] visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Set<Integer> region = new HashSet<>();
                        Set<Integer> threat = new HashSet<>();
                        int[] wallCount = { 0 }; // Use array to pass by reference to DFS

                        dfs(isInfected, i, j, visited, region, threat, wallCount);

                        regions.add(region);
                        threats.add(threat);
                        walls.add(wallCount[0]);
                    }
                }
            }

            // If no regions found, we are done
            if (regions.isEmpty())
                break;

            // Find the index of the region that threatens the most uninfected cells
            int maxThreatIdx = -1;
            int maxThreatCount = -1;

            for (int i = 0; i < threats.size(); i++) {
                if (threats.get(i).size() > maxThreatCount) {
                    maxThreatCount = threats.get(i).size();
                    maxThreatIdx = i;
                }
            }

            // If no threats at all (world full or no neighbors), done
            if (maxThreatIdx == -1 || threats.get(maxThreatIdx).isEmpty())
                break;

            // Contain the selected region
            totalWalls += walls.get(maxThreatIdx);

            // Mark contained virus as -1 (or 2) so we don't process it again
            for (int encoded : regions.get(maxThreatIdx)) {
                int r = encoded / n;
                int c = encoded % n;
                isInfected[r][c] = 2; // 2 represents contained
            }

            // Spread the other regions
            for (int i = 0; i < regions.size(); i++) {
                if (i == maxThreatIdx)
                    continue;
                for (int encoded : threats.get(i)) {
                    int r = encoded / n;
                    int c = encoded % n;
                    isInfected[r][c] = 1; // Uninfected becomes infected
                }
            }
        }

        return totalWalls;
    }

    // DFS to explore a single connected component of virus
    private void dfs(int[][] grid, int r, int c, boolean[][] visited,
            Set<Integer> region, Set<Integer> threat, int[] wallCount) {

        visited[r][c] = true;
        region.add(r * n + c);

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(grid, nr, nc, visited, region, threat, wallCount);
                } else if (grid[nr][nc] == 0) {
                    threat.add(nr * n + nc);
                    wallCount[0]++; // Each edge to a 0 counts as a necessary wall
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] result1 = {
                { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
        System.out.println("Result 1: " + sol.containVirus(result1)); // 10

        int[][] result2 = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        System.out.println("Result 2: " + sol.containVirus(result2)); // 4 (Center is threatened by all sides? No,
                                                                      // neighbors logic handles it)
        // Wait, Example 2 logic: center 0 threatens nothing. Only one region. Threatens
        // center 0. Walls = 4.
    }
}
