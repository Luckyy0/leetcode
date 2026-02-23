package leet_code.Problem_723_Medium_Candy_Crush;

public class Solution {

    /**
     * Stabilizes the Candy Crush board.
     * Strategy: Repeated Mark -> Clear -> Drop phases.
     * Time: O((R*C)^2), Space: O(1).
     */
    public int[][] candyCrush(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        boolean found = false;

        // Step 1: Horizontal marking
        for (int r = 0; r < R; r++) {
            for (int c = 0; c + 2 < C; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r][c + 1]) && v == Math.abs(board[r][c + 2])) {
                    board[r][c] = board[r][c + 1] = board[r][c + 2] = -v;
                    found = true;
                }
            }
        }

        // Step 2: Vertical marking
        for (int r = 0; r + 2 < R; r++) {
            for (int c = 0; c < C; c++) {
                int v = Math.abs(board[r][c]);
                if (v != 0 && v == Math.abs(board[r + 1][c]) && v == Math.abs(board[r + 2][c])) {
                    board[r][c] = board[r + 1][c] = board[r + 2][c] = -v;
                    found = true;
                }
            }
        }

        // Step 3: Clear and Drop (Gravity)
        if (found) {
            for (int c = 0; c < C; c++) {
                int writeIdx = R - 1;
                for (int r = R - 1; r >= 0; r--) {
                    if (board[r][c] > 0) {
                        board[writeIdx--][c] = board[r][c];
                    }
                }
                while (writeIdx >= 0) {
                    board[writeIdx--][c] = 0;
                }
            }
            // Repet until stable
            return candyCrush(board);
        }

        return board;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] board = {
                { 110, 5, 112, 113, 114 },
                { 210, 211, 5, 213, 214 },
                { 310, 311, 3, 313, 314 },
                { 410, 411, 412, 5, 414 },
                { 5, 1, 512, 3, 3 },
                { 610, 4, 1, 613, 614 },
                { 710, 1, 2, 713, 714 },
                { 810, 1, 2, 1, 1 },
                { 1, 1, 2, 2, 2 },
                { 4, 1, 4, 4, 1014 }
        };
        int[][] result = sol.candyCrush(board);
        for (int[] row : result) {
            for (int cell : row)
                System.out.print(cell + " ");
            System.out.println();
        }
    }
}
