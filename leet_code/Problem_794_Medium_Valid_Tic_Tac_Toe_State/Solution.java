package leet_code.Problem_794_Medium_Valid_Tic_Tac_Toe_State;

public class Solution {

    /**
     * Checks if board state is valid.
     * Strategy: Count X and O. Verify count relationship. Check winning conditions.
     * Time: O(1) (Fixed board size), Space: O(1).
     */
    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X')
                    xCount++;
                else if (c == 'O')
                    oCount++;
            }
        }

        // Rule 1: X moves first, so X == O or X == O + 1
        if (oCount != xCount && oCount != xCount - 1) {
            return false;
        }

        boolean xWins = win(board, 'X');
        boolean oWins = win(board, 'O');

        // Rule 2: Cannot both win
        if (xWins && oWins) {
            return false;
        }

        // Rule 3: If X wins, X must have made last move -> X == O + 1
        if (xWins && xCount != oCount + 1) {
            return false;
        }

        // Rule 4: If O wins, O must have made last move -> X == O
        if (oWins && xCount != oCount) {
            return false;
        }

        return true;
    }

    // Helper to check if player P wins
    private boolean win(String[] board, char p) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p) {
                return true;
            }
        }

        // Check cols
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == p && board[1].charAt(j) == p && board[2].charAt(j) == p) {
                return true;
            }
        }

        // Check diagonals
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p) {
            return true;
        }
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] b1 = { "O  ", "   ", "   " };
        System.out.println("Result 1: " + sol.validTicTacToe(b1)); // false

        String[] b2 = { "XOX", " X ", "   " };
        System.out.println("Result 2: " + sol.validTicTacToe(b2)); // false

        String[] b3 = { "XOX", "O O", "XOX" };
        System.out.println("Result 3: " + sol.validTicTacToe(b3)); // true
    }
}
