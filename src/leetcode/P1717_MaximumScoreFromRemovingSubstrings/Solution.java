package leetcode.P1717_MaximumScoreFromRemovingSubstrings;

public class Solution {
    public int maximumGain(String s, int x, int y) {
        // x for "ab", y for "ba"
        String s1;
        int score = 0;

        if (x > y) {
            // Priority "ab"
            Result res1 = remove(s, 'a', 'b', x);
            score += res1.score;
            Result res2 = remove(res1.s, 'b', 'a', y);
            score += res2.score;
        } else {
            // Priority "ba"
            Result res1 = remove(s, 'b', 'a', y);
            score += res1.score;
            Result res2 = remove(res1.s, 'a', 'b', x);
            score += res2.score;
        }

        return score;
    }

    class Result {
        String s;
        int score;

        Result(String s, int score) {
            this.s = s;
            this.score = score;
        }
    }

    private Result remove(String s, char first, char second, int points) {
        StringBuilder sb = new StringBuilder();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (c == second && sb.length() > 0 && sb.charAt(sb.length() - 1) == first) {
                sb.deleteCharAt(sb.length() - 1);
                score += points;
            } else {
                sb.append(c);
            }
        }
        return new Result(sb.toString(), score);
    }
}
