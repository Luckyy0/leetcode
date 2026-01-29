package leetcode.P1222_QueensThatCanAttackTheKing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] board = new boolean[8][8];
        for (int[] q : queens) {
            board[q[0]][q[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();
        int[][] dirs = {
                { -1, -1 }, { -1, 0 }, { -1, 1 },
                { 0, -1 }, { 0, 1 },
                { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int[] d : dirs) {
            int r = king[0];
            int c = king[1];
            while (true) {
                r += d[0];
                c += d[1];

                if (r < 0 || r >= 8 || c < 0 || c >= 8)
                    break;

                if (board[r][c]) {
                    res.add(Arrays.asList(r, c));
                    break;
                }
            }
        }

        return res;
    }
}
