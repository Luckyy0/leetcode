package leet_code.Problem_856_Medium_Score_of_Parentheses;

/**
 * Problem 856: Score of Parentheses
 * https://leetcode.com/problems/score-of-parentheses/
 */
public class Solution {

    /**
     * Calculates the score of balanced parentheses.
     * Strategy: Tracking depth. Only the inner-most "()" contribute points.
     * The points contributed by "()" at depth d is 2^d.
     * 
     * @param s A balanced parentheses string.
     * @return The score.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta sử dụng biến depth để theo dõi mức độ lồng nhau.
     *         Bất cứ khi nào gặp cặp "()" cơ bản, chúng ta cộng 2 mũ (depth) vào
     *         tổng điểm.
     */
    public int scoreOfParentheses(String s) {
        int totalScore = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                // Moving deeper into nested parentheses
                depth++;
            } else {
                // Moving out of a layer
                depth--;

                // If this ')' matches the immediate preceding '(',
                // it is an innermost "()", which provides score.
                if (s.charAt(i - 1) == '(') {
                    // Score = 2^depth
                    totalScore += 1 << depth;
                }
            }
        }

        return totalScore;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println("Score: " + sol.scoreOfParentheses("()")); // 1
        System.out.println("Score: " + sol.scoreOfParentheses("(())")); // 2
        System.out.println("Score: " + sol.scoreOfParentheses("()()")); // 2
        System.out.println("Score: " + sol.scoreOfParentheses("(()(()))")); // 6
    }
}
