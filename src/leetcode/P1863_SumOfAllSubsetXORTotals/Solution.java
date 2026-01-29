package leetcode.P1863_SumOfAllSubsetXORTotals;

public class Solution {
    public int subsetXORSum(int[] nums) {
        int orSum = 0;
        for (int num : nums) {
            orSum |= num;
        }
        return orSum << (nums.length - 1);
    }
}
