package leetcode.P151_ReverseWordsInAString;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * Problem 151: Reverse Words in a String
     * Approach: Built-in split and reverse
     * 
     * Theoretical Basis:
     * - Trim the string to remove leading/trailing spaces.
     * - Split using "\\s+" to handle multiple spaces between words.
     * - Reverse the resulting array of words.
     * - Join using a single space.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public String reverseWords(String s) {
        // Step 1: Trim and split by one or more spaces
        String[] words = s.trim().split("\\s+");

        // Step 2: Swap the order of words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        // Step 3: Join them back with single space
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Cases
        runTest(solution, "the sky is blue", "blue is sky the");
        runTest(solution, "  hello world  ", "world hello");
        runTest(solution, "a good   example", "example good a");
    }

    private static void runTest(Solution s, String input, String expected) {
        String result = s.reverseWords(input);
        System.out.println("Input: \"" + input + "\"");
        System.out.println("Output: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
