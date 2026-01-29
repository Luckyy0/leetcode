package leetcode.P1275_FindWinnerOnATicTacToeGame;

class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int antiDiag = 0;

        int n = 3;

        for (int i = 0; i < moves.length; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            int val = (i % 2 == 0) ? 1 : -1;

            rows[r] += val;
            cols[c] += val;
            if (r == c)
                diag += val;
            if (r + c == n - 1)
                antiDiag += val;

            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n ||
                    Math.abs(diag) == n || Math.abs(antiDiag) == n) {
                return (val == 1) ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}
