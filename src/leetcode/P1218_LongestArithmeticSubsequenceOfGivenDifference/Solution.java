package leetcode.P1218_LongestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        for (int x : arr) {
            int prev = dp.getOrDefault(x - difference, 0);
            dp.put(x, prev + 1);
            maxLen = Math.max(maxLen, prev + 1);
        }
        return maxLen;
    }
}
