package leetcode.P459_RepeatedSubstringPattern;

public class Solution {

    /**
     * Problem 459: Repeated Substring Pattern
     * Approach: String Concatenation Trick
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String middle = doubled.substring(1, doubled.length() - 1);
        return middle.contains(s);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // "abab" -> true
        runTest(sol, "abab", true);

        // "aba" -> false
        runTest(sol, "aba", false);

        // "abcabcabcabc" -> true
        runTest(sol, "abcabcabcabc", true);
    }

    private static void runTest(Solution sol, String s, boolean expected) {
        boolean result = sol.repeatedSubstringPattern(s);
        System.out.println("String: " + s + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
