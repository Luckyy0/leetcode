package leetcode.P999_AvailableCapturesForRook;

class Solution {
    public int numRookCaptures(char[][] board) {
        int rx = 0, ry = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    break;
                }
            }
        }

        int res = 0;
        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int[] d : dirs) {
            int x = rx + d[0], y = ry + d[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (board[x][y] == 'p') {
                    res++;
                    break;
                }
                if (board[x][y] == 'B')
                    break;
                x += d[0];
                y += d[1];
            }
        }
        return res;
    }
}
