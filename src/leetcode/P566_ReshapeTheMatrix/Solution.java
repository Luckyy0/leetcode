package leetcode.P566_ReshapeTheMatrix;

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        // Check if reshaping is possible
        // Kiểm tra xem việc định hình lại có khả thi không
        if (m * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        int row = 0;
        int col = 0;

        // Traverse original matrix and fill new one
        // Duyệt ma trận gốc và điền vào ma trận mới
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }
}
