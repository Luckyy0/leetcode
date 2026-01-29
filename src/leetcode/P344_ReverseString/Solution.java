package leetcode.P344_ReverseString;

import java.util.Arrays;

public class Solution {

    /**
     * Problem 344: Reverse String
     * Approach: Two Pointers (Swap)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["h","e","l","l","o"] -> ["o","l","l","e","h"]
        char[] s1 = { 'h', 'e', 'l', 'l', 'o' };
        runTest(solution, s1, "olleh");

        // ["H","a","n","n","a","h"] -> ["h","a","n","n","a","H"]
        char[] s2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        runTest(solution, s2, "hannaH");
    }

    private static void runTest(Solution s, char[] input, String expected) {
        char[] copy = Arrays.copyOf(input, input.length);
        s.reverseString(input);
        String result = new String(input);
        System.out.println("Input: " + new String(copy) + " -> " + result + " (Expected: " + expected + ")");
        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
