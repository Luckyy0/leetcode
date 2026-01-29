package leetcode.P931_MinimumFallingPathSum;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j > 0 ? matrix[i - 1][j - 1] : Integer.MAX_VALUE;
                int mid = matrix[i - 1][j];
                int right = j < n - 1 ? matrix[i - 1][j + 1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(left, Math.min(mid, right));
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x : matrix[n - 1])
            min = Math.min(min, x);
        return min;
    }
}
