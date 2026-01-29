package leetcode.P1461_CheckIfAStringContainsAllBinaryCodesOfSizeK;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;

        Set<String> codes = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            codes.add(s.substring(i, i + k));
        }

        return codes.size() == (1 << k);
    }
}
