package leetcode.P719_FindKthSmallestPairDistance;

import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Count pairs with distance <= maxDist using sliding window
    // Đếm các cặp có khoảng cách <= maxDist bằng cửa sổ trượt
    private int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }
            count += (right - left);
        }
        return count;
    }
}
