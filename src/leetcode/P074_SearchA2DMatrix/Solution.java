package leetcode.P074_SearchA2DMatrix;

public class Solution {

    /**
     * Problem 74: Search a 2D Matrix
     * Approach: Binary Search (Treat as 1D array)
     * Time Complexity: O(log(m * n))
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] m1 = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        runTest(solution, m1, 3, true);
        runTest(solution, m1, 13, false);

        int[][] m2 = { { 1 } };
        runTest(solution, m2, 1, true);
        runTest(solution, m2, 0, false);
    }

    private static void runTest(Solution s, int[][] matrix, int target, boolean expected) {
        System.out.println("Input size: " + matrix.length + "x" + matrix[0].length + ", Target: " + target);
        boolean result = s.searchMatrix(matrix, target);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
