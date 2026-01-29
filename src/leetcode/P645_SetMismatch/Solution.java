package leetcode.P645_SetMismatch;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        // Find duplicate using index marking
        // Tìm bản sao bằng cách đánh dấu chỉ mục
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]);
            } else {
                nums[index] = -nums[index];
            }
        }

        // Find missing (index with positive value)
        // Tìm số còn thiếu (chỉ mục có giá trị dương)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            } else {
                // Restore logic? Not strictly needed for return but good practice? No.
            }
        }

        return new int[] { duplicate, missing };
    }
}
