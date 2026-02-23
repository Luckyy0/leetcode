package leet_code.Problem_45_Medium_Jump_Game_II;

public class Solution_Greedy {

    /**
     * Finds the minimum number of jumps.
     * Uses the Greedy approach.
     * Tìm số lần nhảy tối thiểu.
     * Sử dụng phương pháp Tham lam.
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest index we can reach from the current jump
            // Cập nhật chỉ số xa nhất có thể đạt được từ lần nhảy hiện tại
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump's range
            // Nếu đã đạt đến giới hạn của phạm vi nhảy hiện tại
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // Optimization: if we can already reach the end
                if (currentEnd >= nums.length - 1)
                    break;
            }
        }

        return jumps;
    }

    /**
     * Main method for testing.
     * Hàm main để kiểm thử.
     */
    public static void main(String[] args) {
        Solution_Greedy solution = new Solution_Greedy();

        // Test Case 1
        int[] n1 = { 2, 3, 1, 1, 4 };
        System.out.println("Test Case 1: " + solution.jump(n1));
        // Expected: 2

        // Test Case 2
        int[] n2 = { 2, 3, 0, 1, 4 };
        System.out.println("Test Case 2: " + solution.jump(n2));
        // Expected: 2
    }
}
