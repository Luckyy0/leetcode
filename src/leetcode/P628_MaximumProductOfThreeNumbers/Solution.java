package leetcode.P628_MaximumProductOfThreeNumbers;

import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        // Can sort or scan. Scaling O(N) is better but Arrays.sort is O(N log N) is
        // fast enough for typical constraints.
        // Also problem asks "integers", implies could be negative.
        // Có thể sắp xếp hoặc quét. Mở rộng O(N) tốt hơn nhưng Arrays.sort là O(N log
        // N) đủ nhanh cho các ràng buộc điển hình.
        // Vấn đề cũng đặt ra "số nguyên", nghĩa là có thể là số âm.

        Arrays.sort(nums);
        int n = nums.length;

        // Option 1: 3 largest positive numbers
        int prod1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        // Option 2: 2 smallest negative numbers (making positive) * largest positive
        // number
        int prod2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(prod1, prod2);
    }
}
