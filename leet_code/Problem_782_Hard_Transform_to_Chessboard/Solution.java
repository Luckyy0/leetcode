package leet_code.Problem_782_Hard_Transform_to_Chessboard;

public class Solution {

    /**
     * Calculates minimum moves to transform into a chessboard.
     * Strategy: Validate board properties and calculate misplaced elements.
     * Time: O(N^2), Space: O(1).
     */
    public int movesToChessboard(int[][] board) {
        int n = board.length;

        // 1. Check if the board is valid (Rectangle Property)
        // Any rectangle formed by 4 points (0,0), (i,0), (0,j), (i,j) must satisfy
        // logic.
        // Specifically, for a valid chessboard, any 4 corners of a rectangle must have
        // XOR sum 0.
        // board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j] == 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }

        // 2. Count row/col sums and calculate misplacements
        int rowSum = 0, colSum = 0;
        int rowMisplace = 0, colMisplace = 0;

        for (int i = 0; i < n; i++) {
            rowSum += board[0][i]; // Sum of first row
            colSum += board[i][0]; // Sum of first column

            // Count misplacements relative to pattern "0, 1, 0, 1..."
            // If board[i][0] matches (i % 2), then it's misplaced for "1, 0, 1, 0..."
            // pattern?
            // Wait, let's define misplace as: matching the pattern "1, 0, 1, 0..."?
            // Let's standardise: pattern A is "0, 1, 0, 1...".
            // If board[i][0] == i % 2, it matches Pattern A.
            // If we count 'matches Pattern A', we can deduce swaps for Pattern A or B.
            // Let's count elements that differ from "0, 1, 0, 1..." (where val at i is
            // i%2).

            // Checking First Column against "0, 1, 0, 1..."
            if (board[i][0] != i % 2) {
                colMisplace++;
            }

            // Checking First Row against "0, 1, 0, 1..."
            if (board[0][i] != i % 2) {
                rowMisplace++;
            }
        }

        // 3. Validate Sums
        // In a valid chessboard of size N, number of ones must be N/2 or (N+1)/2.
        if (rowSum != n / 2 && rowSum != (n + 1) / 2)
            return -1;
        if (colSum != n / 2 && colSum != (n + 1) / 2)
            return -1;

        // 4. Calculate minimal swaps
        // Every swap fixes 2 misplaced elements. So we need misplace/2 swaps.

        int rowSwaps, colSwaps;

        if (n % 2 == 1) {
            // N is Odd. Only one pattern is possible based on majority bit.
            // If misplace is even, we can fix it. If odd, we must convert to the OTHER
            // pattern.
            // Wait, if N is odd, the pattern is fixed by the count of ones.
            // If ones > zeros, pattern must be 1,0,1,0,1.
            // If zeros > ones, pattern must be 0,1,0,1,0.

            // Check Col Swaps
            if (colMisplace % 2 == 1) {
                // Not possible to reach "0,1,0...", must be "1,0,1..."
                // Cost is N - colMisplace
                colSwaps = n - colMisplace;
            } else {
                colSwaps = colMisplace;
            }

            // Check Row Swaps
            if (rowMisplace % 2 == 1) {
                rowSwaps = n - rowMisplace;
            } else {
                rowSwaps = rowMisplace;
            }

        } else {
            // N is Even. Both "0,1,0,1" and "1,0,1,0" are possible targets.
            // Costs are 'misplace' and 'n - misplace'. Both are even.
            // We take minimum.
            colSwaps = Math.min(colMisplace, n - colMisplace);
            rowSwaps = Math.min(rowMisplace, n - rowMisplace);
        }

        return (rowSwaps + colSwaps) / 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] b1 = { { 0, 1, 1, 0 }, { 0, 1, 1, 0 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 } };
        System.out.println("Result 1: " + sol.movesToChessboard(b1)); // 2

        int[][] b2 = { { 0, 1 }, { 1, 0 } };
        System.out.println("Result 2: " + sol.movesToChessboard(b2)); // 0

        int[][] b3 = { { 1, 0 }, { 1, 0 } };
        System.out.println("Result 3: " + sol.movesToChessboard(b3)); // -1
    }
}
