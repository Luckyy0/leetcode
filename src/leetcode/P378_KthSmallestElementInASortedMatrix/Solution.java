package leetcode.P378_KthSmallestElementInASortedMatrix;

public class Solution {

    /**
     * Problem 378: Kth Smallest Element in a Sorted Matrix
     * Approach: Binary Search on Result
     * 
     * Time Complexity: O(N * log(Range))
     * Space Complexity: O(1)
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count number of elements <= target in the matrix
    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // All elements in this column from 0 to row are <= target
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[1,5,9],[10,11,13],[12,13,15]], k=8 -> 13
        int[][] m1 = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        runTest(solution, m1, 8, 13);

        // [[-5]], k=1 -> -5
        int[][] m2 = { { -5 } };
        runTest(solution, m2, 1, -5);
    }

    private static void runTest(Solution s, int[][] m, int k, int expected) {
        int result = s.kthSmallest(m, k);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
