package leetcode.P017_LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Solution {

    private static final String[] MAPPING = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    /**
     * Problem 17: Letter Combinations of a Phone Number
     * Approach: Backtracking
     * Time Complexity: O(4^n)
     * Space Complexity: O(n)
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String letters = MAPPING[digit];

        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        runTest(solution, "", Collections.emptyList());
        runTest(solution, "2", List.of("a", "b", "c"));
    }

    private static void runTest(Solution s, String input, List<String> expected) {
        System.out.println("Input: \"" + input + "\"");
        List<String> result = s.letterCombinations(input);
        System.out.println("Output: " + result);
        System.out.println("Expected: " + expected);

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            // Check if contents are same regardless of order (though this solution produces
            // ordered output)
            if (result.size() == expected.size() && result.containsAll(expected)) {
                System.out.println("PASS (Order might vary)");
            } else {
                System.out.println("FAIL");
            }
        }
        System.out.println("-----------------");
    }
}
