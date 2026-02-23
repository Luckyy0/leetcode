package leet_code.Problem_803_Hard_Bricks_Falling_When_Hit;

public class Solution {

    /**
     * Calculates bricks falling for each hit.
     * Strategy: Reverse the hits and use DSU.
     * Time: O((MN + H) * alpha(MN)), Space: O(MN).
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;

        // 1. Mark bricks that are hit.
        // Use 2 to represent a brick that will be removed, so we can restore it
        // accurately.
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }

        // 2. Build initial DSU for the state after all hits
        int top = m * n; // Special node representing the roof
        DSU dsu = new DSU(top + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionNeighbors(grid, i, j, dsu, m, n);
                    if (i == 0)
                        dsu.union(i * n + j, top);
                }
            }
        }

        // 3. Process hits in reverse
        int[] result = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 0)
                continue; // No brick existed here

            int oldCount = dsu.getSize(top);
            grid[r][c] = 1; // Restore brick

            // Connect to neighbors
            unionNeighbors(grid, r, c, dsu, m, n);
            if (r == 0)
                dsu.union(r * n + c, top);

            int newCount = dsu.getSize(top);
            result[i] = Math.max(0, newCount - oldCount - 1);
        }

        return result;
    }

    private void unionNeighbors(int[][] grid, int r, int c, DSU dsu, int m, int n) {
        int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i], nc = c + dc[i];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                dsu.union(r * n + c, nr * n + nc);
            }
        }
    }

    // Standard DSU with size tracking
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        void union(int i, int j) {
            int rootI = find(i), rootJ = find(j);
            if (rootI != rootJ) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }

        int getSize(int i) {
            return size[find(i)];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] g1 = { { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };
        int[][] h1 = { { 1, 0 } };
        int[] res1 = sol.hitBricks(g1, h1);
        System.out.println("Result 1: " + res1[0]); // 2
    }
}
