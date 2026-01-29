package leetcode.P1991_FindTheMiddleIndexInArray;

public class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
