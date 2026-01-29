package leetcode.P873_LengthOfLongestFibonacciSubsequence;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++)
            indexMap.put(arr[i], i);

        // dp[i][j] is the length of Fibonacci-like sequence ending at indices i and j
        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int target = arr[k] - arr[j];
                if (target < arr[j] && indexMap.containsKey(target)) {
                    int i = indexMap.get(target);
                    dp[j][k] = (dp[i][j] == 0 ? 2 : dp[i][j]) + 1;
                    maxLen = Math.max(maxLen, dp[j][k]);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
