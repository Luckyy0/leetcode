package leetcode.P467_UniqueSubstringsInWraparoundString;

public class Solution {

    /**
     * Problem 467: Unique Substrings in Wraparound String
     * Approach: Dynamic Programming / Character max length tracking
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.isEmpty())
            return 0;

        int[] maxLen = new int[26];
        int currentMaxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25)) {
                currentMaxLen++;
            } else {
                currentMaxLen = 1;
            }

            int charIdx = s.charAt(i) - 'a';
            maxLen[charIdx] = Math.max(maxLen[charIdx], currentMaxLen);
        }

        int total = 0;
        for (int len : maxLen) {
            total += len;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "a" -> 1
        runTest(sol, "a", 1);

        // "cac" -> 2
        runTest(sol, "cac", 2);

        // "zab" -> 6
        runTest(sol, "zab", 6);
    }

    private static void runTest(Solution sol, String s, int expected) {
        int result = sol.findSubstringInWraproundString(s);
        System.out.println("String: " + s + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
