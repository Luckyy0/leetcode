package leetcode.P782_TransformToChessboard;

class Solution {
    public int movesToChessboard(int[][] board) {
        int n = board.length;

        // Check rows
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if ((board[0][0] ^ board[r][0] ^ board[0][c] ^ board[r][c]) == 1)
                    return -1;
            }
        }

        int rowSum = 0, colSum = 0, rowSwap = 0, colSwap = 0;
        for (int i = 0; i < n; i++) {
            rowSum += board[i][0];
            colSum += board[0][i];
            rowSwap += board[i][0] == (i % 2); // Count missmatches with 0101 pattern
            colSwap += board[0][i] == (i % 2);
        }

        if (rowSum < n / 2 || rowSum > (n + 1) / 2)
            return -1;
        if (colSum < n / 2 || colSum > (n + 1) / 2)
            return -1;

        if (n % 2 == 1) {
            if (rowSwap % 2 == 1)
                rowSwap = n - rowSwap;
            if (colSwap % 2 == 1)
                colSwap = n - colSwap;
        } else {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        }

        return (rowSwap + colSwap) / 2;
    }
}
