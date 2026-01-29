package leetcode.P1260_Shift2DGrid;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;

        // We can just construct result directly
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            result.add(row);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int oldIdx = i * n + j;
                int newIdx = (oldIdx + k) % total;
                int r = newIdx / n;
                int c = newIdx % n;
                result.get(r).set(c, grid[i][j]);
            }
        }

        return result;
    }
}
