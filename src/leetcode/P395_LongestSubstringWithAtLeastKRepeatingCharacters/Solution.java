package leetcode.P395_LongestSubstringWithAtLeastKRepeatingCharacters;

public class Solution {

    /**
     * Problem 395: Longest Substring with At Least K Repeating Characters
     * Approach: Divide and Conquer
     * 
     * Time Complexity: O(N * 26)
     * Space Complexity: O(26) recursion depth
     */
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;

        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                // Split point found
                int left = helper(s, start, i, k);

                // Skip other split points for efficiency
                int nextStart = i + 1;
                while (nextStart < end && counts[s.charAt(nextStart) - 'a'] < k) {
                    nextStart++;
                }
                int right = helper(s, nextStart, end, k);

                return Math.max(left, right);
            }
        }

        return end - start;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "aaabb", 3 -> 3
        runTest(solution, "aaabb", 3, 3);

        // "ababbc", 2 -> 5
        runTest(solution, "ababbc", 2, 5);

        // "ababacb", 3 -> 0
        runTest(solution, "ababacb", 3, 0);
    }

    private static void runTest(Solution sol, String s, int k, int expected) {
        int result = sol.longestSubstring(s, k);
        System.out.println("s: \"" + s + "\", k: " + k + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
