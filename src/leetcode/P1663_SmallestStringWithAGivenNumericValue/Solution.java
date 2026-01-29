package leetcode.P1663_SmallestStringWithAGivenNumericValue;

import java.util.Arrays;

public class Solution {
    public String getSmallestString(int n, int k) {
        char[] chars = new char[n];
        Arrays.fill(chars, 'a');

        int diff = k - n;
        int idx = n - 1;

        while (diff > 0 && idx >= 0) {
            int add = Math.min(diff, 25);
            chars[idx] = (char) ('a' + add);
            diff -= add;
            idx--;
        }

        return new String(chars);
    }
}
