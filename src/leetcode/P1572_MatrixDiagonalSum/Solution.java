package leetcode.P1572_MatrixDiagonalSum;

public class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i]; // Primary diagonal

            // Secondary diagonal
            // Avoid adding the center element twice if n is odd
            if (i != n - 1 - i) {
                sum += mat[i][n - 1 - i];
            }
        }

        return sum;
    }
}
