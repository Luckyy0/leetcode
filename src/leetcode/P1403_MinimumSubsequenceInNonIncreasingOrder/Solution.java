package leetcode.P1403_MinimumSubsequenceInNonIncreasingOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int totalSum = 0;
        for (int x : nums)
            totalSum += x;

        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int currSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            res.add(nums[i]);
            if (currSum > totalSum - currSum) {
                break;
            }
        }

        return res;
    }
}
