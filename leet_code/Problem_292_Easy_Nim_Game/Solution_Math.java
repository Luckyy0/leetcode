package leet_code.Problem_292_Easy_Nim_Game;

public class Solution_Math {

    /**
     * Determines if you can win the Nim Game.
     * Uses Game Theory (modulo arithmetic).
     * Time: O(1), Space: O(1).
     * 
     * Xác định xem bạn có thể thắng trò chơi Nim không.
     * Sử dụng Lý thuyết trò chơi (số học modulo).
     */
    public boolean canWinNim(int n) {
        // You win if n is NOT a multiple of 4.
        // Bạn thắng nếu n KHÔNG phải là bội số của 4.
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();

        // Test Case 1: 4 -> false
        System.out.println("Can win 4: " + solution.canWinNim(4));

        // Test Case 2: 1 -> true
        System.out.println("Can win 1: " + solution.canWinNim(1));
    }
}
