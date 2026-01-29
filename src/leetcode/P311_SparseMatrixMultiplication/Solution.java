package leetcode.P311_SparseMatrixMultiplication;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 311: Sparse Matrix Multiplication
     * Approach: Loop with Zero Check
     * 
     * Time Complexity: O(M * K * N) worst case, faster if sparse
     * Space Complexity: O(M * N)
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length;
        int k = mat1[0].length;
        int n = mat2[0].length;

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int p = 0; p < k; p++) {
                if (mat1[i][p] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (mat2[p][j] != 0) {
                            result[i][j] += mat1[i][p] * mat2[p][j];
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
        // Output: [[7,0,0],[-7,0,3]]
        int[][] mat1 = { { 1, 0, 0 }, { -1, 0, 3 } };
        int[][] mat2 = { { 7, 0, 0 }, { 0, 0, 0 }, { 0, 0, 1 } };
        int[][] expected = { { 7, 0, 0 }, { -7, 0, 3 } };

        runTest(solution, mat1, mat2, expected);

        // [[0]] x [[0]]
        runTest(solution, new int[][] { { 0 } }, new int[][] { { 0 } }, new int[][] { { 0 } });
    }

    private static void runTest(Solution s, int[][] m1, int[][] m2, int[][] expected) {
        int[][] result = s.multiply(m1, m2);
        System.out.println("Result: " + Arrays.deepToString(result));

        if (Arrays.deepEquals(result, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
