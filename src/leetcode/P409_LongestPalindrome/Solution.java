package leetcode.P409_LongestPalindrome;

public class Solution {

    /**
     * Problem 409: Longest Palindrome
     * Approach: Frequency Counting (Greedy)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int longestPalindrome(String s) {
        int[] counts = new int[128]; // ASCII
        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : counts) {
            length += (count / 2) * 2;
            if (count % 2 != 0) {
                hasOdd = true;
            }
        }

        return hasOdd ? length + 1 : length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "abccccdd" -> 7
        runTest(solution, "abccccdd", 7);

        // "a" -> 1
        runTest(solution, "a", 1);

        // "AAAAAA" -> 6
        runTest(solution, "AAAAAA", 6);
    }

    private static void runTest(Solution sol, String s, int expected) {
        int result = sol.longestPalindrome(s);
        System.out.println("String: " + s + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
