package leetcode.P711_NumberOfDistinctIslandsII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<String> distinct = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> island = new ArrayList<>();
                    dfs(grid, i, j, island);
                    distinct.add(getCanonical(island));
                }
            }
        }
        return distinct.size();
    }

    private void dfs(int[][] grid, int r, int c, List<int[]> island) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return;
        grid[r][c] = 0;
        island.add(new int[] { r, c });
        dfs(grid, r + 1, c, island);
        dfs(grid, r - 1, c, island);
        dfs(grid, r, c + 1, island);
        dfs(grid, r, c - 1, island);
    }

    private String getCanonical(List<int[]> island) {
        List<String> shapes = new ArrayList<>();
        int[][] trans = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

        for (int i = 0; i < 8; i++) {
            List<int[]> transformed = new ArrayList<>();
            for (int[] p : island) {
                int x = p[0], y = p[1];
                transformed.add(i < 4 ? new int[] { x * trans[i][0], y * trans[i][1] }
                        : new int[] { y * trans[i - 4][0], x * trans[i - 4][1] });
            }
            shapes.add(normalize(transformed));
        }
        Collections.sort(shapes);
        return shapes.get(0);
    }

    private String normalize(List<int[]> shape) {
        Collections.sort(shape, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int r0 = shape.get(0)[0], c0 = shape.get(0)[1];
        StringBuilder sb = new StringBuilder();
        for (int[] p : shape) {
            sb.append((p[0] - r0) + ":" + (p[1] - c0) + ",");
        }
        return sb.toString();
    }
}
