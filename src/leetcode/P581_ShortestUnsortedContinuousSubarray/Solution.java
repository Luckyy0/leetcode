package leetcode.P581_ShortestUnsortedContinuousSubarray;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int end = -2;
        int start = -1;

        // Find right boundary (end)
        // Tìm biên phải (end)
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                end = i;
            }
        }

        // Find left boundary (start)
        // Tìm biên trái (start)
        for (int i = n - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                start = i;
            }
        }

        // If sorting is needed, length is end - start + 1. Else 0.
        // Nếu cần sắp xếp, độ dài là end - start + 1. Nếu không thì là 0.
        if (end == -2)
            return 0;
        return end - start + 1;
    }
}
