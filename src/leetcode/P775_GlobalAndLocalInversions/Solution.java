package leetcode.P775_GlobalAndLocalInversions;

class Solution {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // A number can only move 1 position at most from its sorted index i
            // Một số chỉ có thể di chuyển tối đa 1 vị trí từ chỉ số đã được sắp xếp i
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
