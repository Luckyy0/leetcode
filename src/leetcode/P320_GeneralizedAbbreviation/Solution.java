package leetcode.P320_GeneralizedAbbreviation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * Problem 320: Generalized Abbreviation
     * Approach: Backtracking
     * 
     * Time Complexity: O(2^N * N)
     * Space Complexity: O(N)
     */
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), word, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, String word, int index, int count) {
        if (index == word.length()) {
            int len = sb.length();
            if (count > 0) {
                sb.append(count);
            }
            result.add(sb.toString());
            sb.setLength(len); // Backtrack
            return;
        }

        int len = sb.length();

        // Choice 1: Abbreviate current character
        backtrack(result, sb, word, index + 1, count + 1);

        // Choice 2: Keep current character
        // If there was an active count, append it first
        if (count > 0) {
            sb.append(count);
        }
        sb.append(word.charAt(index));
        backtrack(result, sb, word, index + 1, 0);

        // Reset StringBuilder state for backtracking
        sb.setLength(len);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "word"
        // Expected size: 16
        runTest(solution, "word", 16);

        // "a" -> ["1", "a"]
        runTest(solution, "a", 2);
    }

    private static void runTest(Solution s, String word, int expectedSize) {
        List<String> result = s.generateAbbreviations(word);
        System.out.println("Input: " + word + " -> Size: " + result.size() + " (Expected: " + expectedSize + ")");
        Collections.sort(result);
        System.out.println("First few: " + result.subList(0, Math.min(result.size(), 5)));

        if (result.size() == expectedSize) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
