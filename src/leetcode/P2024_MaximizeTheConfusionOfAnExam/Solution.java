package leetcode.P2024_MaximizeTheConfusionOfAnExam;

public class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(solve(answerKey, k, 'T'), solve(answerKey, k, 'F'));
    }

    private int solve(String s, int k, char target) {
        int l = 0, r = 0;
        int n = s.length();
        int otherCount = 0;
        int maxLen = 0;

        while (r < n) {
            if (s.charAt(r) != target) {
                otherCount++;
            }

            while (otherCount > k) {
                if (s.charAt(l) != target) {
                    otherCount--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}
