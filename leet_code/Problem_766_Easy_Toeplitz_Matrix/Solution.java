package leet_code.Problem_766_Easy_Toeplitz_Matrix;

public class Solution {

    /**
     * Checks if matrix is Toeplitz.
     * Strategy: Compare each element with its bottom-right neighbor.
     * Time: O(M*N), Space: O(1).
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Iterate through all elements that have a bottom-right neighbor
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] m1 = {
                { 1, 2, 3, 4 },
                { 5, 1, 2, 3 },
                { 9, 5, 1, 2 }
        };
        System.out.println("Result 1: " + sol.isToeplitzMatrix(m1)); // true

        int[][] m2 = {
                { 1, 2 },
                { 2, 2 }
        };
        System.out.println("Result 2: " + sol.isToeplitzMatrix(m2)); // false
    }
}
