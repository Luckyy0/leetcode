package leet_code.Problem_51_Hard_N_Queens;

import java.util.*;

public class Solution_Backtracking {

    /**
     * Solves the N-Queens puzzle.
     * Uses Backtracking with efficient diagonal checking.
     * Giải bài toán N-Queens.
     * Sử dụng Quay lui với kiểm tra đường chéo hiệu quả.
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        // Track occupied columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // row - col + (n-1)
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
            int d1 = row - col + (n - 1);
            int d2 = row + col;

            if (!cols[col] && !diag1[d1] && !diag2[d2]) {
                // Place queen
                board[row][col] = 'Q';
                cols[col] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                // Recurse
                backtrack(row + 1, n, board, cols, diag1, diag2, result);

                // Backtrack
                board[row][col] = '.';
                cols[col] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        return list;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1
        System.out.println("Test Case 1 (n=4): " + solution.solveNQueens(4));

        // Test Case 2
        System.out.println("Test Case 2 (n=1): " + solution.solveNQueens(1));
    }
}
