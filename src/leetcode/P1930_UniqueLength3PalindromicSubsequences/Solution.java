package leetcode.P1930_UniqueLength3PalindromicSubsequences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1)
                first[c] = i;
            last[c] = i;
        }

        int ans = 0;
        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && last[c] > first[c] + 1) {
                Set<Character> uniqueMiddle = new HashSet<>();
                for (int i = first[c] + 1; i < last[c]; i++) {
                    uniqueMiddle.add(s.charAt(i));
                }
                ans += uniqueMiddle.size();
            }
        }

        return ans;
    }
}
