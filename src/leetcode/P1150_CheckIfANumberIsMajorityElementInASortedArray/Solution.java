package leetcode.P1150_CheckIfANumberIsMajorityElementInASortedArray;

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int first = findFirst(nums, target);

        if (first == -1)
            return false;

        int idx = first + n / 2;
        if (idx < n && nums[idx] == target)
            return true;

        return false;
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                if (nums[mid] == target)
                    res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
