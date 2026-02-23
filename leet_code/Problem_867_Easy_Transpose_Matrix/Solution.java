package leet_code.Problem_867_Easy_Transpose_Matrix;

/**
 * Problem 867: Transpose Matrix
 * https://leetcode.com/problems/transpose-matrix/
 */
public class Solution {

    /**
     * Transposes a given matrix by swapping rows and columns.
     * 
     * @param matrix A 2D integer array.
     * @return The transposed matrix.
     * 
     *         Tóm tắt chiến lược:
     *         Tạo một ma trận mới có số hàng bằng số cột của ma trận cũ, và số cột
     *         bằng số hàng của ma trận cũ. Duyệt qua từng phần tử và gán
     *         kết quả[cột][hàng] = gốc[hàng][cột].
     */
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // The result matrix has n rows and m columns
        int[][] result = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Swap indices: result[j][i] corresponds to matrix[i][j]
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] m1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int[][] res1 = sol.transpose(m1);
        // Expect: {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}

        int[][] m2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int[][] res2 = sol.transpose(m2);
        // Expect: {{1, 4}, {2, 5}, {3, 6}}
    }
}
