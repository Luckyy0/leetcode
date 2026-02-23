package leet_code.Problem_198_Medium_House_Robber;

public class Solution_DP {

    /**
     * Calculates the maximum amount of money you can rob.
     * Uses optimized Dynamic Programming with O(N) time and O(1) space.
     * 
     * Tính số tiền tối đa có thể trộm.
     * Sử dụng Quy hoạch động tối ưu hóa với thời gian O(N) và không gian O(1).
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int num : nums) {
            // Recurrence: max(skip current, rob current + prev2)
            // Truy hồi: max(bỏ qua hiện tại, trộm hiện tại + prev2)
            int current = Math.max(prev1, prev2 + num);

            // Shift states forward
            // Dịch chuyển trạng thái
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [1,2,3,1] -> 4
        int[] n1 = { 1, 2, 3, 1 };
        System.out.println("Max profit 1: " + solution.rob(n1));

        // Test Case 2: [2,7,9,3,1] -> 12
        int[] n2 = { 2, 7, 9, 3, 1 };
        System.out.println("Max profit 2: " + solution.rob(n2));
    }
}
