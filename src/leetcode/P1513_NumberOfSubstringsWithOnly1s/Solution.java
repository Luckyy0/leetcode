package leetcode.P1513_NumberOfSubstringsWithOnly1s;

class Solution {
    public int numSub(String s) {
        int count = 0;
        int res = 0;
        int MOD = 1_000_000_007;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                res = (res + count) % MOD;
            } else {
                count = 0;
            }
        }

        return res;
    }
}
