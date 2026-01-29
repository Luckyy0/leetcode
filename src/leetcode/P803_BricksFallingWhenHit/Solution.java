package leetcode.P803_BricksFallingWhenHit;

class Solution {
    int[][] grid;
    int m, n;
    int[] parent;
    int[] size;

    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        // 1. Initial State Modification: Mark hits
        for (int[] h : hits) {
            if (grid[h[0]][h[1]] == 1)
                grid[h[0]][h[1]] = 2; // Brick to be hit
        }

        // 2. Build DSU for the final state
        int totalCells = m * n;
        parent = new int[totalCells + 1]; // +1 for the ceiling (top source)
        size = new int[totalCells + 1];
        for (int i = 0; i <= totalCells; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    unionNeighbors(r, c);
                }
            }
        }

        // 3. Process hits in reverse
        int[] res = new int[hits.length];
        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0], c = hits[i][1];
            if (grid[r][c] == 2) {
                int preSize = size[find(0)];
                grid[r][c] = 1;
                unionNeighbors(r, c);
                int postSize = size[find(0)];
                res[i] = Math.max(0, postSize - preSize - 1);
            }
        }

        return res;
    }

    private void unionNeighbors(int r, int c) {
        int u = r * n + c + 1;
        if (r == 0)
            union(0, u); // Connect to ceiling

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                union(u, nr * n + nc + 1);
            }
        }
    }

    private int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            size[rootJ] += size[rootI];
        }
    }
}
