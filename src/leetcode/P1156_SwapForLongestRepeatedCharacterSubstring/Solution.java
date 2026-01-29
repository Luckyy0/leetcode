package leetcode.P1156_SwapForLongestRepeatedCharacterSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Group {
        char c;
        int len;

        Group(char c, int l) {
            this.c = c;
            this.len = l;
        }
    }

    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray())
            freq[c - 'a']++;

        List<Group> groups = new ArrayList<>();
        int i = 0;
        int n = text.length();
        while (i < n) {
            char c = text.charAt(i);
            int j = i;
            while (j < n && text.charAt(j) == c) {
                j++;
            }
            groups.add(new Group(c, j - i));
            i = j;
        }

        int maxLen = 0;
        for (Group g : groups) {
            int current = g.len;
            if (freq[g.c - 'a'] > g.len) {
                current++;
            }
            maxLen = Math.max(maxLen, current);
        }

        for (int k = 0; k < groups.size() - 2; k++) {
            Group g1 = groups.get(k);
            Group mid = groups.get(k + 1);
            Group g2 = groups.get(k + 2);

            if (mid.len == 1 && g1.c == g2.c) {
                int combined = g1.len + g2.len;
                if (freq[g1.c - 'a'] > combined) {
                    combined++;
                }
                maxLen = Math.max(maxLen, combined);
            }
        }

        return maxLen;
    }
}
