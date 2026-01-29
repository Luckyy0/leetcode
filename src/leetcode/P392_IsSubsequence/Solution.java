package leetcode.P392_IsSubsequence;

public class Solution {

    /**
     * Problem 392: Is Subsequence
     * Approach: Two Pointers
     * 
     * Time Complexity: O(T) where T is the length of string t.
     * Space Complexity: O(1)
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int i = 0; // pointer for s
        int j = 0; // pointer for t

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "abc", "ahbgdc" -> true
        runTest(solution, "abc", "ahbgdc", true);

        // "axc", "ahbgdc" -> false
        runTest(solution, "axc", "ahbgdc", false);

        // "", "ahbgdc" -> true
        runTest(solution, "", "ahbgdc", true);

        // "abc", "" -> false
        runTest(solution, "abc", "", false);
    }

    private static void runTest(Solution sol, String s, String t, boolean expected) {
        boolean result = sol.isSubsequence(s, t);
        System.out.println("s: \"" + s + "\", t: \"" + t + "\" -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
