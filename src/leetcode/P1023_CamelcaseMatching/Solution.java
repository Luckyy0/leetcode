package leetcode.P1023_CamelcaseMatching;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            res.add(isMatch(q, pattern));
        }
        return res;
    }

    private boolean isMatch(String query, String pattern) {
        int i = 0;
        for (char c : query.toCharArray()) {
            if (i < pattern.length() && c == pattern.charAt(i)) {
                i++;
            } else if (Character.isUpperCase(c)) {
                return false;
            }
        }
        return i == pattern.length();
    }
}
