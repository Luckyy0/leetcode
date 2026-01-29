package leetcode.P905_SortArrayByParity;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }

            if (nums[left] % 2 == 0)
                left++;
            if (nums[right] % 2 == 1)
                right--;
        }
        return nums;
    }
}
