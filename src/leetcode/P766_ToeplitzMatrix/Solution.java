package leetcode.P766_ToeplitzMatrix;

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[0].length - 1; c++) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
