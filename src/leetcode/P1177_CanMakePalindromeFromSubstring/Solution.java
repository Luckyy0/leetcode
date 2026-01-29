package leetcode.P1177_CanMakePalindromeFromSubstring;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];

        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask ^= (1 << (s.charAt(i) - 'a'));
            prefix[i + 1] = mask;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];

            int subMask = prefix[r + 1] ^ prefix[l];
            int oddCounts = Integer.bitCount(subMask);

            // We can have at most 1 odd char (center).
            // Each k change can eliminate 2 odd counts (making them match each other or
            // match center)
            // Wait, change X to Y.
            // X count was odd -> even. Y count was odd -> even. (Reduces 2 odds)
            // Or X odd -> even. Y even -> odd. (No change in total odds count) -
            // counterproductive.
            // We always choose optimal: pair two loose odds.

            int needed = oddCounts / 2;
            res.add(needed <= k);
        }

        return res;
    }
}
