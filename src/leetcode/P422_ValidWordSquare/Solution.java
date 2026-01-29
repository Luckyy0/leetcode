package leetcode.P422_ValidWordSquare;

import java.util.List;
import java.util.Arrays;

public class Solution {

    /**
     * Problem 422: Valid Word Square
     * Approach: Symmetric Character Matching with Bounds Checking
     * 
     * Time Complexity: O(N^2) where N is the grid dimension
     * Space Complexity: O(1)
     */
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty())
            return true;

        int n = words.size();
        for (int i = 0; i < n; i++) {
            String rowWord = words.get(i);
            for (int j = 0; j < rowWord.length(); j++) {
                // If the corresponding vertical character should exist:
                // 1. Row j must exist (j < n)
                // 2. Row j must be long enough to have index i (i < words.get(j).length())
                if (j >= n || i >= words.get(j).length()) {
                    return false;
                }

                if (rowWord.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // ["abcd","bnrt","crmy","dtye"] -> true
        runTest(solution, Arrays.asList("abcd", "bnrt", "crmy", "dtye"), true);

        // ["abcd","bnrt","crm","dt"] -> true
        runTest(solution, Arrays.asList("abcd", "bnrt", "crm", "dt"), true);

        // ["ball","area","read","lady"] -> false
        runTest(solution, Arrays.asList("ball", "area", "read", "lady"), false);

        // ["abc", "b", "c"] -> true?
        // r0="abc", c0="abc". r1="b", c1="b", r2="c", c2="c". YES.
        runTest(solution, Arrays.asList("abc", "b", "c"), true);
    }

    private static void runTest(Solution sol, List<String> words, boolean expected) {
        boolean result = sol.validWordSquare(words);
        System.out.println("Words: " + words + " -> Result: " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
