package leet_code.Problem_784_Medium_Letter_Case_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<String> result;

    /**
     * Generates all letter case permutations.
     * Strategy: Backtracking (DFS). Try both lowercase and uppercase for letters.
     * Time: O(2^N * N), Space: O(N) stack.
     */
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<>();
        backtrack(s.toCharArray(), 0);
        return result;
    }

    private void backtrack(char[] chars, int index) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        char currentChar = chars[index];

        if (Character.isLetter(currentChar)) {
            // Option 1: Lowercase
            chars[index] = Character.toLowerCase(currentChar);
            backtrack(chars, index + 1);

            // Option 2: Uppercase
            chars[index] = Character.toUpperCase(currentChar);
            backtrack(chars, index + 1);

            // Backtrack NOT strictly necessary here since we overwrite chars[index] in the
            // next call
            // or restore it by the nature of recursion scope if we passed strings.
            // But since we modify the shared array 'chars', do we need to restore?
            // Actually, Option 2 overwrites Option 1's change.
            // When returning from Option 2, the array at 'index' is Uppercase.
            // It doesn't affect the parent because parent moves on to other branches?
            // Wait, parent called backtrack(i). Chid ren modify chars[i], chars[i+1]...
            // When child returns, chars[i] is uppercase.
            // But parent (at index-1) doesn't care about the content of index, it cares
            // about index-1.
            // The only issue is if we needed the original char for something else? No.
            // But for correctness/cleanliness, we reset? Not needed for this specific
            // logic.
        } else {
            // Digit: just skip
            backtrack(chars, index + 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.letterCasePermutation("a1b2"));
        // [a1b2, a1B2, A1b2, A1B2]

        System.out.println("Result 2: " + sol.letterCasePermutation("3z4"));
        // [3z4, 3Z4]
    }
}
