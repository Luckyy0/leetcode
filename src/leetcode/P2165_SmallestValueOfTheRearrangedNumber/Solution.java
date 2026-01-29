package leetcode.P2165_SmallestValueOfTheRearrangedNumber;

import java.util.Arrays;

public class Solution {
    public long smallestNumber(long num) {
        if (num == 0)
            return 0;
        boolean negative = num < 0;
        String s = String.valueOf(Math.abs(num));
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        if (negative) {
            // Maximize absolute value -> Descending
            // chars is Ascending. Reverse it.
            StringBuilder sb = new StringBuilder();
            sb.append(new String(chars));
            sb.reverse();
            return -Long.parseLong(sb.toString());
        } else {
            // Minimize value. No leading zero.
            // chars is Ascending 0,0,..,3,5,..
            // Find first non-zero
            int i = 0;
            while (i < chars.length && chars[i] == '0') {
                i++;
            }
            if (i < chars.length) {
                // Swap chars[0] and chars[i]
                char temp = chars[0];
                chars[0] = chars[i];
                chars[i] = temp;
            }
            return Long.parseLong(new String(chars));
        }
    }
}
