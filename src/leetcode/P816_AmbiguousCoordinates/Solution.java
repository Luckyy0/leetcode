package leetcode.P816_AmbiguousCoordinates;

import java.util.*;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1); // remove ()
        List<String> res = new ArrayList<>();

        for (int i = 1; i < s.length(); i++) {
            List<String> lefts = allowed(s.substring(0, i));
            List<String> rights = allowed(s.substring(i));
            for (String l : lefts) {
                for (String r : rights) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    private List<String> allowed(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();

        // As integer (no decimal)
        if (n == 1 || s.charAt(0) != '0')
            res.add(s);

        // Try decimals
        for (int i = 1; i < n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            // Decimal rules:
            // 1. Left part cannot have leading zeros unless it's "0"
            // 2. Right part cannot have trailing zeros
            if ((left.length() == 1 || left.charAt(0) != '0') && right.charAt(right.length() - 1) != '0') {
                res.add(left + "." + right);
            }
        }
        return res;
    }
}
