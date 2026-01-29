package leetcode.P1864_MinimumNumberOfSwapsToMakeTheBinaryStringAlternating;

public class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int ones = 0, zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones++;
            else
                zeros++;
        }

        if (Math.abs(ones - zeros) > 1)
            return -1;

        int ans = Integer.MAX_VALUE;

        // If counts allow, check target starting with '0'
        if (zeros == ones || zeros == ones + 1) {
            ans = Math.min(ans, countSwaps(s, '0'));
        }

        // If counts allow, check target starting with '1'
        if (ones == zeros || ones == zeros + 1) {
            ans = Math.min(ans, countSwaps(s, '1'));
        }

        return ans;
    }

    private int countSwaps(String s, char start) {
        int mismatches = 0;
        for (int i = 0; i < s.length(); i++) {
            char target = (i % 2 == 0) ? start : (start == '0' ? '1' : '0');
            if (s.charAt(i) != target) {
                mismatches++;
            }
        }
        return mismatches / 2;
    }
}
