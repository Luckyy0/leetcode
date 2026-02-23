package leet_code.Problem_419_Medium_Battleships_in_a_Board;

public class Solution_HeadCounting {

    /**
     * Counts the number of battleships on board.
     * Strategy: Count only the top-leftmost cell of each ship.
     * Time: O(MN), Space: O(1).
     * 
     * Đếm số lượng tàu chiến trên bàn cờ.
     * Chiến lược: Chỉ đếm ô trên cùng bên trái của mỗi con tàu.
     */
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    // If there's an 'X' above or to the left, it's part of an existing ship
                    // Nếu có 'X' ở trên hoặc bên trái, nó là phần của một con tàu đã biết
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
        Solution_HeadCounting solution = new Solution_HeadCounting();

        // Test Case 1: 2
        char[][] b1 = {
                { 'X', '.', '.', 'X' },
                { '.', '.', '.', 'X' },
                { '.', '.', '.', 'X' }
        };
        System.out.println("Result 1: " + solution.countBattleships(b1));

        // Test Case 2: 0
        char[][] b2 = { { '.' } };
        System.out.println("Result 2: " + solution.countBattleships(b2));
    }
}
