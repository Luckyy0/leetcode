package leetcode.P052_NQueensII;

public class Solution {

    private int count = 0;

    /**
     * Problem 52: N-Queens II
     * Approach: Backtracking
     * Time Complexity: O(N!)
     * Space Complexity: O(N)
     */
    public int totalNQueens(int n) {
        count = 0;
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrack(0, n, cols, diag1, diag2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place Queen
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, cols, diag1, diag2);

            // Backtrack
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 4, 2);
        runTest(solution, 1, 1);
        runTest(solution, 8, 92); // Standard result for 8-queens
    }

    private static void runTest(Solution s, int n, int expected) {
        System.out.println("Input n: " + n);
        int result = s.totalNQueens(n);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
