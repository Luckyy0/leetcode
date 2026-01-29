package leetcode.P1759_CountNumberOfHomogenousSubstrings;

public class Solution {
    public int countHomogenous(String s) {
        int MOD = 1_000_000_007;
        long total = 0;
        int currentLen = 0;
        char prev = 0;

        for (char c : s.toCharArray()) {
            if (c == prev) {
                currentLen++;
            } else {
                currentLen = 1;
                prev = c;
            }
            total = (total + currentLen) % MOD;
        }

        return (int) total;
    }
}
