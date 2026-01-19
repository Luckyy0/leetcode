package leetcode.P130_SurroundedRegions;

public class Solution {

    /**
     * Problem 130: Surrounded Regions
     * Approach: Boundary DFS
     * 
     * Theoretical Basis:
     * - Only 'O's connected to boundaries are "safe" from being captured.
     * - Approach:
     * 1. Mark all boundary 'O's and their connected 'O' cells as safe using a
     * marker '#'.
     * 2. Flip all remaining 'O' cells to 'X'.
     * 3. Flip all '#' markers back to 'O'.
     * 
     * Time Complexity: O(M * N) - visit each cell a few times.
     * Space Complexity: O(M * N) - recursion stack in the worst case.
     */
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // 1. Mark boundary connected 'O's as safe '#'
        // Check first and last rows
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                markSafe(board, 0, j);
            if (board[rows - 1][j] == 'O')
                markSafe(board, rows - 1, j);
        }
        // Check first and last columns
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O')
                markSafe(board, i, 0);
            if (board[i][cols - 1] == 'O')
                markSafe(board, i, cols - 1);
        }

        // 2. Process final flip
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; // Surrounded
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O'; // Safe
                }
            }
        }
    }

    private void markSafe(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = '#';
        markSafe(board, r + 1, c);
        markSafe(board, r - 1, c);
        markSafe(board, r, c + 1);
        markSafe(board, r, c - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        char[][] board1 = {
                { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' }
        };
        solution.solve(board1);
        printBoard(board1);

        // Test Case 2
        char[][] board2 = { { 'X' } };
        solution.solve(board2);
        printBoard(board2);
    }

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}
