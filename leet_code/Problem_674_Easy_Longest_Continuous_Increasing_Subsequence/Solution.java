package leet_code.Problem_674_Easy_Longest_Continuous_Increasing_Subsequence;

public class Solution {

    /**
     * Finds the length of the longest continuous strictly increasing subsequence.
     * Strategy: Single pass greedy scan tracking current increasing length.
     * Time: O(N), Space: O(1).
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int maxLen = 0;
        int currentLen = 0;

        for (int i = 0; i < nums.length; i++) {
            // If it's the start of the array or current element is greater than the
            // previous one
            if (i == 0 || nums[i] > nums[i - 1]) {
                currentLen++;
            } else {
                // Strictly increasing property is broken, reset counter
                currentLen = 1;
            }

            // Update global maximum length
            maxLen = Math.max(maxLen, currentLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result [1,3,5,4,7]: " + sol.findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 })); // 3
        System.out.println("Result [2,2,2,2,2]: " + sol.findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 })); // 1
    }
}
