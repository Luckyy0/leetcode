package leet_code.Problem_294_Medium_Flip_Game_II;

import java.util.HashMap;
import java.util.Map;

public class Solution_Backtracking {

    private Map<String, Boolean> memo = new HashMap<>();

    /**
     * Determines if the starting player guarantees a win.
     * Uses Recursion with Memoization.
     * Time: Exponential without memo, heavily pruned. Space: Exponential states.
     * 
     * Xác định xem người chơi bắt đầu có đảm bảo thắng không.
     * Sử dụng Đệ quy với Ghi nhớ.
     */
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() < 2) {
            return false;
        }

        if (memo.containsKey(currentState)) {
            return memo.get(currentState);
        }

        for (int i = 0; i < currentState.length() - 1; i++) {
            // Find "++"
            // Tìm "++"
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                // Generate next state
                // Tạo trạng thái tiếp theo
                String nextState = currentState.substring(0, i) + "--" + currentState.substring(i + 2);

                // If the opponent CANNOT win from this new state, then I CAN win.
                // Nếu đối thủ KHÔNG THỂ thắng từ trạng thái mới này, thì tôi CÓ THỂ thắng.
                if (!canWin(nextState)) {
                    memo.put(currentState, true);
                    return true;
                }
            }
        }

        // If no move leads to opponent losing, I lose.
        // Nếu không nước đi nào khiến đối thủ thua, tôi thua.
        memo.put(currentState, false);
        return false;
    }

    public static void main(String[] args) {
        Solution_Backtracking solution = new Solution_Backtracking();

        // Test Case 1: "++++" -> true
        System.out.println("Can Win 1: " + solution.canWin("++++"));

        // Test Case 2: "+" -> false
        System.out.println("Can Win 2: " + solution.canWin("+"));
    }
}
