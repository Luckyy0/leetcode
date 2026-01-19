package leetcode.P289_GameOfLife;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 289: Game of Life
     * Approach: Bit Manipulation for In-place Update
     * 
     * Theoretical Basis:
     * - Use 2nd bit to store new state.
     * - 00 (0): Dead -> Dead
     * - 01 (1): Live -> Dead (Initial state 1)
     * - 10 (2): Dead -> Live
     * - 11 (3): Live -> Live
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

        // Pass 1: Compute new states and encode
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;

                for (int[] d : dirs) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && r < m && c >= 0 && c < n) {
                        // Check old state (bit 0)
                        if ((board[r][c] & 1) == 1) {
                            liveNeighbors++;
                        }
                    }
                }

                // Rule 1, 3: Live -> Dies (Under/Over). New state 0.
                // Rule 2: Live -> Live (2 or 3).
                // Rule 4: Dead -> Live (3).

                if ((board[i][j] & 1) == 1) {
                    // Current Live
                    if (liveNeighbors == 2 || liveNeighbors == 3) {
                        // New state 1. Encode: 10 | 01 = 11 (3)
                        board[i][j] |= 2;
                    }
                    // Else New state 0. Encode: 00 | 01 = 01 (1). No change needed.
                } else {
                    // Current Dead
                    if (liveNeighbors == 3) {
                        // New state 1. Encode: 10 | 00 = 10 (2)
                        board[i][j] |= 2;
                    }
                }
            }
        }

        // Pass 2: Shift to new state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
        int[][] board = {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 }
        };

        solution.gameOfLife(board);

        // Expected: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
        int[][] expected = {
                { 0, 0, 0 },
                { 1, 0, 1 },
                { 0, 1, 1 },
                { 0, 1, 0 }
        };

        System.out.println("Result Board:");
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }

        if (Arrays.deepEquals(board, expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
