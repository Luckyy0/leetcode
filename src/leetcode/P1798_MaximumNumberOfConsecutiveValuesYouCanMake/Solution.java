package leetcode.P1798_MaximumNumberOfConsecutiveValuesYouCanMake;

import java.util.Arrays;

public class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int maxReach = 0;

        for (int c : coins) {
            if (c <= maxReach + 1) {
                maxReach += c;
            } else {
                break;
            }
        }

        return maxReach + 1;
    }
}
