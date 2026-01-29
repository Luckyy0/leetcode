package leetcode.P1012_NumbersWithRepeatedDigits;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n - countUnique(n);
    }

    private int countUnique(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int uniqueCount = 0;

        // 1. Count numbers with fewer digits
        for (int i = 1; i < len; i++) {
            uniqueCount += 9 * perm(9, i - 1);
        }

        // 2. Count numbers with same length
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';
            for (int d = (i == 0 ? 1 : 0); d < digit; d++) {
                if (!seen.contains(d)) {
                    uniqueCount += perm(9 - i, len - 1 - i);
                }
            }
            if (seen.contains(digit))
                break;
            seen.add(digit);
            if (i == len - 1)
                uniqueCount++; // The number n itself is unique if we reach here
        }

        return uniqueCount;
    }

    private int perm(int m, int k) {
        if (k == 0)
            return 1;
        int res = 1;
        for (int i = 0; i < k; i++) {
            res *= (m - i);
        }
        return res;
    }
}
