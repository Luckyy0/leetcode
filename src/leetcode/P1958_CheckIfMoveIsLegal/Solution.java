package leetcode.P1958_CheckIfMoveIsLegal;

public class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] dirs = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
                { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
        };

        char opposite = (color == 'W') ? 'B' : 'W';

        for (int[] d : dirs) {
            int r = rMove + d[0];
            int c = cMove + d[1];
            int count = 1; // Start cell

            // First step must be opposite
            if (r < 0 || r >= 8 || c < 0 || c >= 8 || board[r][c] != opposite) {
                continue;
            }

            // Continue scan
            while (true) {
                r += d[0];
                c += d[1];
                count++;

                if (r < 0 || r >= 8 || c < 0 || c >= 8 || board[r][c] == '.') {
                    break;
                }

                if (board[r][c] == color) {
                    if (count >= 3)
                        return true; // Found end
                    break;
                }
            }
        }

        return false;
    }
}
