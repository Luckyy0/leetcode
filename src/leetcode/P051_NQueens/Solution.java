package leetcode.P051_NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 51: N-Queens
     * Approach: Backtracking
     * Time Complexity: O(N!)
     * Space Complexity: O(N)
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row - col + n
        boolean[] diag2 = new boolean[2 * n]; // row + col

        backtrack(0, n, board, cols, diag1, diag2, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2,
            List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }

            // Place Queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, board, cols, diag1, diag2, result);

            // Backtrack
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 4, 2);
        runTest(solution, 1, 1);
        runTest(solution, 3, 0); // No solution for n=3 (except maybe partial, but problem implies full n queens)
    }

    private static void runTest(Solution s, int n, int expectedCount) {
        System.out.println("Input n: " + n);
        List<List<String>> result = s.solveNQueens(n);
        System.out.println("Output count: " + result.size() + " (Expected: " + expectedCount + ")");
        if (result.size() > 0) {
            System.out.println("First solution: " + result.get(0));
        }

        if (result.size() == expectedCount) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
