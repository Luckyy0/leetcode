package leetcode.P240_SearchA2DMatrixII;

public class Solution {

    /**
     * Problem 240: Search a 2D Matrix II
     * Approach: Search from Top-Right corner.
     * 
     * Theoretical Basis:
     * - If current > target, target must be to the left.
     * - If current < target, target must be down.
     * 
     * Time Complexity: O(M + N)
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Start from Top-Right corner
        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            int val = matrix[r][c];

            if (val == target) {
                return true;
            } else if (val > target) {
                // val is too big. Since column is sorted increasing downwards,
                // everything below val is also too big.
                // So discard THIS column.
                c--;
            } else {
                // val is too small. Since row is sorted increasing rightwards,
                // everything left of val is also too small.
                // So discard THIS row.
                r++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };

        // Target 5 -> true
        runTest(solution, matrix, 5, true);

        // Target 20 -> false
        runTest(solution, matrix, 20, false);

        // Target 1 -> true
        runTest(solution, matrix, 1, true);

        // Target 30 -> true
        runTest(solution, matrix, 30, true);
    }

    private static void runTest(Solution s, int[][] matrix, int target, boolean expected) {
        boolean result = s.searchMatrix(matrix, target);
        System.out.println("Target: " + target + " -> Found: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
