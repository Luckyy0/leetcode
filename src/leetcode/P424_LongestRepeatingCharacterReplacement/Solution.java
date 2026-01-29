package leetcode.P424_LongestRepeatingCharacterReplacement;

public class Solution {

    /**
     * Problem 424: Longest Repeating Character Replacement
     * Approach: Sliding Window
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] counts = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxLen = 0;

        for (int right = 0; right < n; right++) {
            counts[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(right) - 'A']);

            // If the number of characters to replace > k, shrink window
            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "ABAB", k = 2 -> 4
        runTest(solution, "ABAB", 2, 4);

        // "AABABBA", k = 1 -> 4
        runTest(solution, "AABABBA", 1, 4);
    }

    private static void runTest(Solution sol, String s, int k, int expected) {
        int result = sol.characterReplacement(s, k);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
