package leetcode.P1422_MaximumScoreAfterSplittingAString;

class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                totalOnes++;
        }

        int maxScore = 0;
        int zerosLeft = 0;
        int onesRight = totalOnes;

        // Loop until n-1 (exclusive) so left and right are non-empty
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosLeft++;
            } else {
                onesRight--;
            }
            maxScore = Math.max(maxScore, zerosLeft + onesRight);
        }

        return maxScore;
    }
}
