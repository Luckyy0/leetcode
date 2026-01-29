package leetcode.P1060_MissingElementInSortedArray;

class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;

        int missingTotal = countMissing(nums, right);
        if (k > missingTotal) {
            return nums[right] + k - missingTotal;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int missing = countMissing(nums, mid);
            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // left is the first index where missing(left) >= k
        // So the number is between nums[left-1] and nums[left]
        // missing(left-1) < k.
        // res = nums[left-1] + (k - missing(left-1))

        return nums[left - 1] + k - countMissing(nums, left - 1);
    }

    private int countMissing(int[] nums, int idx) {
        return nums[idx] - nums[0] - idx;
    }
}
