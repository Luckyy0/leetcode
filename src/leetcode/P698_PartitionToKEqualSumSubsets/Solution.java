package leetcode.P698_PartitionToKEqualSumSubsets;

import java.util.Arrays;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % k != 0)
            return false;

        int target = sum / k;
        Arrays.sort(nums);
        int n = nums.length;

        // Fill from largest to smallest
        // Điền từ lớn nhất đến nhỏ nhất
        return backtrack(nums, n - 1, new int[k], target);
    }

    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index < 0)
            return true;

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[index] <= target) {
                buckets[i] += nums[index];
                if (backtrack(nums, index - 1, buckets, target))
                    return true;
                buckets[i] -= nums[index];
            }

            // Optimization: If the bucket is empty and we fail to put the number,
            // no need to try other empty buckets.
            // Tối ưu hóa: Nếu thùng chứa trống và chúng ta không đặt được số vào,
            // không cần phải thử các thùng chứa trống khác.
            if (buckets[i] == 0)
                break;
        }

        return false;
    }
}
