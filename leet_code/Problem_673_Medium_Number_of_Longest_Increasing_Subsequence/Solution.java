package leet_code.Problem_673_Medium_Number_of_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {

    /**
     * Calculates the number of longest increasing subsequences.
     * Strategy: DP with two arrays - one for LIS length and one for count.
     * Time: O(N^2), Space: O(N).
     */
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        int[] lengths = new int[n]; // length of LIS ending at i
        int[] counts = new int[n]; // number of LIS of length lengths[i] ending at i

        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        // Found a strictly longer subsequence
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        // Found another way to reach the same max length at i
                        counts[i] += counts[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, lengths[i]);
        }

        int result = 0;
        // Sum up counts of all subsequences reaching the global max length
        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLen) {
                result += counts[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result [1,3,5,4,7]: " + sol.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 })); // 2
        System.out.println("Result [2,2,2,2,2]: " + sol.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 })); // 5
    }
}
