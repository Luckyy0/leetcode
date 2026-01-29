package leetcode.P348_DesignTicTacToe;

public class Solution {

    /**
     * Problem 348: Design Tic-Tac-Toe
     * Approach: Row/Col Counters
     * 
     * Time Complexity: O(1)
     * Space Complexity: O(N)
     */
    public static class TicTacToe {
        private int[] rows;
        private int[] cols;
        private int diagonal;
        private int antiDiagonal;
        private int n;

        public TicTacToe(int n) {
            this.n = n;
            this.rows = new int[n];
            this.cols = new int[n];
            this.diagonal = 0;
            this.antiDiagonal = 0;
        }

        public int move(int row, int col, int player) {
            int toAdd = (player == 1) ? 1 : -1;

            rows[row] += toAdd;
            cols[col] += toAdd;

            if (row == col) {
                diagonal += toAdd;
            }

            if (row == (n - 1 - col)) {
                antiDiagonal += toAdd;
            }

            if (Math.abs(rows[row]) == n ||
                    Math.abs(cols[col]) == n ||
                    Math.abs(diagonal) == n ||
                    Math.abs(antiDiagonal) == n) {
                return player;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);

        // 0,0,1 -> 0
        System.out.println(ticTacToe.move(0, 0, 1));

        // 0,2,2 -> 0
        System.out.println(ticTacToe.move(0, 2, 2));

        // 2,2,1 -> 0
        System.out.println(ticTacToe.move(2, 2, 1));

        // 1,1,2 -> 0
        System.out.println(ticTacToe.move(1, 1, 2));

        // 2,0,1 -> 0
        System.out.println(ticTacToe.move(2, 0, 1));

        // 1,0,2 -> 0
        System.out.println(ticTacToe.move(1, 0, 2));

        // 2,1,1 -> 1 (Wins row 2: (2,0), (2,2), (2,1)) -> Wait sequence in example:
        // Ex: (0,0)X, (0,2)O, (2,2)X, (1,1)O, (2,0)X, (1,0)O, (2,1)X.
        // X has: (0,0), (2,2), (2,0), (2,1). Row 2 is full X. Win.
        System.out.println(ticTacToe.move(2, 1, 1));
    }
}
