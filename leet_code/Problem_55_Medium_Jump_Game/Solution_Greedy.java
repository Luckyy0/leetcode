package leet_code.Problem_55_Medium_Jump_Game;

public class Solution_Greedy {

    /**
     * Checks if the last index is reachable.
     * Uses Greedy approach.
     * Kiểm tra xem chỉ số cuối cùng có thể đạt tới được không.
     * Sử dụng phương pháp Tham lam.
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // If current index is not reachable, return false
            // Nếu chỉ số hiện tại không thể đạt tới, trả về false
            if (i > reachable) {
                return false;
            }

            // Update the farthest index we can reach
            // Cập nhật chỉ số xa nhất có thể đạt được
            int currentReach = i + nums[i];
            if (currentReach > reachable) {
                reachable = currentReach;
            }

            // If we can already reach the end
            // Nếu đã có thể đạt tới cuối
            if (reachable >= n - 1) {
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1
        int[] n1 = { 2, 3, 1, 1, 4 };
        System.out.println("Test Case 1: " + solution.canJump(n1));
        // Expected: true

        // Test Case 2
        int[] n2 = { 3, 2, 1, 0, 4 };
        System.out.println("Test Case 2: " + solution.canJump(n2));
        // Expected: false
    }
}
