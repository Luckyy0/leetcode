package leetcode.P1567_MaximumLengthOfSubarrayWithPositiveProduct;

public class Solution {
    public int getMaxLen(int[] nums) {
        int pos = 0;
        int neg = 0;
        int maxLen = 0;

        for (int num : nums) {
            if (num == 0) {
                pos = 0;
                neg = 0;
            } else if (num > 0) {
                pos++;
                neg = (neg > 0) ? neg + 1 : 0;
            } else { // num < 0
                int tempPos = pos;
                pos = (neg > 0) ? neg + 1 : 0;
                neg = tempPos + 1;
            }
            maxLen = Math.max(maxLen, pos);
        }

        return maxLen;
    }
}
