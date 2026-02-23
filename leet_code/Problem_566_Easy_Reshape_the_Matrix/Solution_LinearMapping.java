package leet_code.Problem_566_Easy_Reshape_the_Matrix;

public class Solution_LinearMapping {

    /**
     * Reshapes a matrix to new dimensions (r, c).
     * Strategy: Use linear indexing to map original cell to new cell.
     * Time: O(M*N), Space: O(M*N).
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        // Check feasibility
        if (m * n != r * c) {
            return mat;
        }

        int[][] res = new int[r][c];

        // Map elements using a single linear counter
        for (int k = 0; k < m * n; k++) {
            // Original: k / n (row), k % n (col)
            // New: k / c (row), k % c (col)
            res[k / c][k % c] = mat[k / n][k % n];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_LinearMapping solution = new Solution_LinearMapping();
        int[][] mat = { { 1, 2 }, { 3, 4 } };
        int[][] res = solution.matrixReshape(mat, 1, 4);

        System.out.println("Result:");
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
