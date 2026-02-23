package leet_code.Problem_311_Medium_Sparse_Matrix_Multiplication;

public class Solution_Optimized {

    /**
     * Multiplies two sparse matrices.
     * Uses optimized iteration skipping zero elements.
     * Time: O(M * K * N), but efficient on sparse inputs. Space: O(1) extra.
     * 
     * Nhân hai ma trận thưa.
     * Sử dụng tối ưu hóa lặp bỏ qua các phần tử không.
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int p = 0; p < k; p++) {
                // Optimization: If the element in mat1 is 0, skip the inner loop row
                // multiplication
                // Tối ưu hóa: Nếu phần tử trong mat1 là 0, bỏ qua phép nhân hàng vòng lặp bên
                // trong
                if (mat1[i][p] != 0) {
                    for (int j = 0; j < n; j++) {
                        // Check mat2 element for further sparsity?
                        // Usually just iterating is fast enough for dense vector ops (CPU
                        // cache/pipelining)
                        // But if mat2 is extremely sparse, CSR representation helps.
                        // Here we rely on standard "if mat1 non-zero" optimization.
                        if (mat2[p][j] != 0) {
                            res[i][j] += mat1[i][p] * mat2[p][j];
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Optimized solution = new Solution_Optimized();

        // Test Case 1
        int[][] mat1 = { { 1, 0, 0 }, { -1, 0, 3 } };
        int[][] mat2 = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };

        int[][] res = solution.multiply(mat1, mat2);
        System.out.println("Result:");
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        // Expected: [[7,0,0], [-7,0,3]]
    }
}
