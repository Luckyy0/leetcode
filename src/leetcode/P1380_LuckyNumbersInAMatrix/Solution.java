package leetcode.P1380_LuckyNumbersInAMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minRow = new int[m];
        int[] maxCol = new int[n];

        Arrays.fill(minRow, Integer.MAX_VALUE);
        Arrays.fill(maxCol, Integer.MIN_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }

        return res;
    }
}
