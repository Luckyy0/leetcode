package leetcode.P2033_MinimumOperationsToMakeAUniValueGrid;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] arr = new int[m * n];
        int idx = 0;
        int mod = grid[0][0] % x;

        for (int[] row : grid) {
            for (int val : row) {
                if (val % x != mod)
                    return -1;
                arr[idx++] = val;
            }
        }

        Arrays.sort(arr);
        int median = arr[(m * n) / 2];
        int ops = 0;

        for (int val : arr) {
            ops += Math.abs(val - median) / x;
        }

        return ops;
    }
}
