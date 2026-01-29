package leetcode.P522_LongestUncommonSubsequenceII;

import java.util.*;

public class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            if (isUncommon)
                return strs[i].length();
        }
        return -1;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && s.charAt(i) == c)
                i++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findLUSlength(new String[] { "aba", "cdc", "eae" })); // 3
    }
}
