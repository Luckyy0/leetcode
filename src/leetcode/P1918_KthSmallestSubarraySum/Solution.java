package leetcode.P1918_KthSmallestSubarraySum;

public class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int n : nums)
            high += n;

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (countSubarrays(nums, mid) >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private int countSubarrays(int[] nums, int target) {
        int count = 0;
        int currentSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > target) {
                currentSum -= nums[left];
                left++;
            }
            // All subarrays ending at right and starting from left..right are valid
            count += (right - left + 1);
        }

        return count;
    }
}
