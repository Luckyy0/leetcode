package leetcode.P037_SudokuSolver;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 37: Sudoku Solver
     * Approach: Backtracking
     */
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {

                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // Backtrack
                            }
                        }
                    }

                    return false; // No number fits in this cell
                }
            }
        }
        return true; // All cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // Check Row
            if (board[row][i] == c)
                return false;
            // Check Col
            if (board[i][col] == c)
                return false;
            // Check 3x3 Box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        // Expected solution for verification
        char[][] expected = {
                { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
                { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
                { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
                { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
                { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
                { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
                { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
                { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
                { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
        };

        System.out.println("Solving Sudoku...");
        solution.solveSudoku(board);

        boolean passed = true;
        for (int i = 0; i < 9; i++) {
            if (!Arrays.equals(board[i], expected[i])) {
                passed = false;
                break;
            }
        }

        if (passed) {
            System.out.println("PASS: Board solved correctly.");
            printBoard(board);
        } else {
            System.out.println("FAIL: Board solution incorrect.");
            printBoard(board);
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0)
                System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
