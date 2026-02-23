package leet_code.Problem_213_Medium_House_Robber_II;

public class Solution_DP {

    /**
     * Calculates maximum money to rob from circular houses.
     * Breaks the circle into two linear problems.
     * Time: O(N), Space: O(1).
     * 
     * Tính số tiền tối đa trộm được từ các ngôi nhà vòng tròn.
     * Chia vòng tròn thành hai bài toán tuyến tính.
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        // Scenario 1: Rob houses 0 to n-2 (exclude last)
        // Kịch bản 1: Trộm nhà từ 0 đến n-2 (bỏ nhà cuối)
        int max1 = robLinear(nums, 0, nums.length - 2);

        // Scenario 2: Rob houses 1 to n-1 (exclude first)
        // Kịch bản 2: Trộm nhà từ 1 đến n-1 (bỏ nhà đầu)
        int max2 = robLinear(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    // Helper function for linear House Robber (Problem 198)
    // Hàm bổ trợ cho Kẻ trộm nhà tuyến tính
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Solution_DP solution = new Solution_DP();

        // Test Case 1: [2,3,2] -> 3
        int[] n1 = { 2, 3, 2 };
        System.out.println("Max profit 1: " + solution.rob(n1));

        // Test Case 2: [1,2,3,1] -> 4
        int[] n2 = { 1, 2, 3, 1 };
        System.out.println("Max profit 2: " + solution.rob(n2));

        // Test Case 3: [1,2,3] -> 3
        int[] n3 = { 1, 2, 3 };
        System.out.println("Max profit 3: " + solution.rob(n3));
    }
}
