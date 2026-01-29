package leetcode.P1605_FindValidMatrixGivenRowAndColumnSums;

public class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] mat = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = Math.min(rowSum[i], colSum[j]);
                mat[i][j] = val;

                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }

        return mat;
    }
}
