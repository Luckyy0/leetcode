package leetcode.P1914_CyclicallyRotatingAGrid;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layerCount = Math.min(m, n) / 2;

        for (int layer = 0; layer < layerCount; layer++) {
            List<Integer> elements = new ArrayList<>();
            // Top row: left to right
            for (int j = layer; j < n - layer - 1; j++)
                elements.add(grid[layer][j]);
            // Right col: top to bottom
            for (int i = layer; i < m - layer - 1; i++)
                elements.add(grid[i][n - layer - 1]);
            // Bottom row: right to left
            for (int j = n - layer - 1; j > layer; j--)
                elements.add(grid[m - layer - 1][j]);
            // Left col: bottom to top
            for (int i = m - layer - 1; i > layer; i--)
                elements.add(grid[i][layer]);

            int total = elements.size();
            int shift = k % total;

            // Put Back
            int idx = shift; // Start putting back from shifted index

            // Re-traverse same path
            for (int j = layer; j < n - layer - 1; j++) {
                grid[layer][j] = elements.get(idx);
                idx = (idx + 1) % total;
            }
            for (int i = layer; i < m - layer - 1; i++) {
                grid[i][n - layer - 1] = elements.get(idx);
                idx = (idx + 1) % total;
            }
            for (int j = n - layer - 1; j > layer; j--) {
                grid[m - layer - 1][j] = elements.get(idx);
                idx = (idx + 1) % total;
            }
            for (int i = m - layer - 1; i > layer; i--) {
                grid[i][layer] = elements.get(idx);
                idx = (idx + 1) % total;
            }
        }

        return grid;
    }
}
