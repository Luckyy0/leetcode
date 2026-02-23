package leet_code.Problem_53_Medium_Maximum_Subarray;

public class Solution_Kadane {

    /**
     * Finds the contiguous subarray with the largest sum.
     * Uses Kadane's Algorithm.
     * Tìm mảng con liên tiếp có tổng lớn nhất.
     * Sử dụng thuật toán Kadane.
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at nums[i], or continue the previous one
            // Hoặc bắt đầu một mảng con mới tại nums[i], hoặc tiếp tục mảng con trước đó
            currentMax = Math.max(nums[i], currentMax + nums[i]);

            // Keep track of the overall maximum
            // Theo dõi tổng lớn nhất tổng thể
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution_Kadane solution = new Solution_Kadane();

        // Test Case 1
        int[] n1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Test Case 1: " + solution.maxSubArray(n1));
        // Expected: 6

        // Test Case 2
        int[] n2 = { 5, 4, -1, 7, 8 };
        System.out.println("Test Case 2: " + solution.maxSubArray(n2));
        // Expected: 23
    }
}
