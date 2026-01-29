package leetcode.P1702_MaximumBinaryStringAfterChange;

import java.util.Arrays;

public class Solution {
    public String maximumBinaryString(String binary) {
        int n = binary.length();
        int firstZero = binary.indexOf('0');

        if (firstZero == -1) {
            return binary;
        }

        int zeros = 0;
        for (int i = firstZero; i < n; i++) {
            if (binary.charAt(i) == '0') {
                zeros++;
            }
        }

        char[] result = new char[n];
        Arrays.fill(result, '1');

        // The single zero ends up at firstZero + (zeros - 1)
        if (zeros > 0) {
            result[firstZero + zeros - 1] = '0';
        }

        return new String(result);
    }
}
