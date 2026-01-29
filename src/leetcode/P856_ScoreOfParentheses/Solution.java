package leetcode.P856_ScoreOfParentheses;

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0, depth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // Check if it's a complete innermost '()'
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth;
                }
            }
        }
        return score;
    }
}
