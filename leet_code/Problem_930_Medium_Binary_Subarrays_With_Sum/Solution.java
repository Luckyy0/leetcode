package leet_code.Problem_930_Medium_Binary_Subarrays_With_Sum;

/**
 * Problem 930: Binary Subarrays With Sum
 * https://leetcode.com/problems/binary-subarrays-with-sum/
 */
public class Solution {

    /**
     * Finds the number of subarrays with a sum equal to goal.
     * Strategy: Sliding Window (Two Pointers) using "atMost" trick.
     * 
     * @param nums Binary array.
     * @param goal Target sum.
     * @return Count of subarrays.
     * 
     *         Tóm tắt chiến lược:
     *         1. Số lượng mảng con có tổng BẰNG `goal` chính là:
     *         (Số lượng mảng con có tổng <= `goal`) - (Số lượng mảng con có tổng <=
     *         `goal - 1`).
     *         2. Ta xây dựng hàm trợ giúp `atMost(nums, S)` để đếm số mảng con có
     *         tổng <= S.
     *         3. Trong `atMost`, sử dụng kỹ thuật cửa sổ trượt:
     *         - Mở rộng cửa sổ sang phải (`right`).
     *         - Nếu tổng cửa sổ > S, thu hẹp cửa sổ từ bên trái (`left`) cho đến
     *         khi tổng <= S.
     *         - Tại mỗi bước `right`, số lượng mảng con hợp lệ kết thúc tại `right`
     *         là `right - left + 1`.
     *         4. Trừ kết quả của hai lần gọi hàm `atMost` để có đáp án.
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    /**
     * Helper function to count subarrays with sum at most S.
     */
    private int atMost(int[] nums, int S) {
        if (S < 0)
            return 0;

        int left = 0;
        int res = 0;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > S) {
                sum -= nums[left];
                left++;
            }

            // All subarrays ending at right and starting from left to right are valid
            // Example: [1, 0, 1], S=2. If window is [1, 0, 1],
            // valid subarrays ending at last 1 are [1], [0, 1], [1, 0, 1] -> length 3.
            res += right - left + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Result: " + sol.numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2)); // 4
        System.out.println("Result: " + sol.numSubarraysWithSum(new int[] { 0, 0, 0, 0, 0 }, 0)); // 15
    }
}
