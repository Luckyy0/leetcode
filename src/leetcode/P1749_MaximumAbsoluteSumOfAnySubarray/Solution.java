package leetcode.P1749_MaximumAbsoluteSumOfAnySubarray;

public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxPref = 0;
        int minPref = 0;
        int currPref = 0;

        for (int num : nums) {
            currPref += num;
            maxPref = Math.max(maxPref, currPref);
            minPref = Math.min(minPref, currPref);
        }

        return maxPref - minPref;
    }
}
