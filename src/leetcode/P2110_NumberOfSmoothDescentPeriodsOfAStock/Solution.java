package leetcode.P2110_NumberOfSmoothDescentPeriodsOfAStock;

public class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 0;
        int currentLen = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] == prices[i - 1] - 1) {
                currentLen++;
            } else {
                currentLen = 1;
            }
            ans += currentLen;
        }

        return ans;
    }
}
