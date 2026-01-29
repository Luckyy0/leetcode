package leetcode.P784_LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s.toCharArray(), 0, res);
        return res;
    }

    private void backtrack(char[] chars, int i, List<String> res) {
        if (i == chars.length) {
            res.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[i])) {
            backtrack(chars, i + 1, res);
        } else {
            // Choice 1: lowercase
            chars[i] = Character.toLowerCase(chars[i]);
            backtrack(chars, i + 1, res);

            // Choice 2: uppercase
            chars[i] = Character.toUpperCase(chars[i]);
            backtrack(chars, i + 1, res);
        }
    }
}
