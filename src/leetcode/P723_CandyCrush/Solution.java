package leetcode.P723_CandyCrush;

class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean found = false;

        // 1. Mark phase (Horizontal)
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n - 2; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    found = true;
                }
            }
        }

        // 1. Mark phase (Vertical)
        for (int r = 0; r < m - 2; r++) {
            for (int c = 0; c < n; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    found = true;
                }
            }
        }

        // 2. Crush & Gravity phase
        if (found) {
            for (int c = 0; c < n; c++) {
                int writeIdx = m - 1;
                for (int r = m - 1; r >= 0; r--) {
                    if (board[r][c] > 0) {
                        board[writeIdx--][c] = board[r][c];
                    }
                }
                while (writeIdx >= 0) {
                    board[writeIdx--][c] = 0;
                }
            }
            return candyCrush(board); // Repeat until stability
        }

        return board;
    }
}
