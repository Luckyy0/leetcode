package leetcode.P419_BattleshipsInABoard;

public class Solution {

    /**
     * Problem 419: Battleships in a Board
     * Approach: One-pass O(1) space counting top-left corners
     * 
     * Time Complexity: O(M * N)
     * Space Complexity: O(1)
     */
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // If there's an 'X' to the left or above, it's the same ship
                    if (i > 0 && board[i - 1][j] == 'X')
                        continue;
                    if (j > 0 && board[i][j - 1] == 'X')
                        continue;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]] -> 2
        char[][] b1 = {
                { 'X', '.', '.', 'X' },
                { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' }
        };
        runTest(solution, b1, 2);

        // [["."]] -> 0
        char[][] b2 = { { '.' } };
        runTest(solution, b2, 0);
    }

    private static void runTest(Solution sol, char[][] board, int expected) {
        int result = sol.countBattleships(board);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
