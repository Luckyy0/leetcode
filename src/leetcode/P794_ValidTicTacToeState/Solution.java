package leetcode.P794_ValidTicTacToeState;

class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X')
                    xCount++;
                if (c == 'O')
                    oCount++;
            }
        }

        if (xCount != oCount && xCount != oCount + 1)
            return false;

        boolean xWin = isWin(board, 'X');
        boolean oWin = isWin(board, 'O');

        if (xWin && oWin)
            return false;
        if (xWin && xCount != oCount + 1)
            return false;
        if (oWin && xCount != oCount)
            return false;

        return true;
    }

    private boolean isWin(String[] board, char p) {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (board[i].charAt(0) == p && board[i].charAt(1) == p && board[i].charAt(2) == p)
                return true;
            if (board[0].charAt(i) == p && board[1].charAt(i) == p && board[2].charAt(i) == p)
                return true;
        }
        // Diagonals
        if (board[0].charAt(0) == p && board[1].charAt(1) == p && board[2].charAt(2) == p)
            return true;
        if (board[0].charAt(2) == p && board[1].charAt(1) == p && board[2].charAt(0) == p)
            return true;

        return false;
    }
}
