package leetcode.P890_FindAndReplacePattern;

import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (isMatch(w, pattern))
                res.add(w);
        }
        return res;
    }

    private boolean isMatch(String s, String p) {
        if (s.length() != p.length())
            return false;

        int[] sToP = new int[256];
        int[] pToS = new int[256];
        Arrays.fill(sToP, -1);
        Arrays.fill(pToS, -1);

        for (int i = 0; i < s.length(); i++) {
            int c1 = s.charAt(i), c2 = p.charAt(i);
            if (sToP[c1] == -1 && pToS[c2] == -1) {
                sToP[c1] = c2;
                pToS[c2] = c1;
            } else if (sToP[c1] != c2 || pToS[c2] != c1) {
                return false;
            }
        }

        return true;
    }
}
