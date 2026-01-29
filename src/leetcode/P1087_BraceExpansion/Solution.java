package leetcode.P1087_BraceExpansion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] expand(String s) {
        List<List<Character>> groups = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            List<Character> group = new ArrayList<>();
            if (s.charAt(i) == '{') {
                i++;
                while (s.charAt(i) != '}') {
                    if (s.charAt(i) != ',') {
                        group.add(s.charAt(i));
                    }
                    i++;
                }
                i++; // skip '}'
            } else {
                group.add(s.charAt(i));
                i++;
            }
            Collections.sort(group); // Sort options for lexical order in generation
            groups.add(group);
        }

        List<String> res = new ArrayList<>();
        backtrack(groups, 0, new StringBuilder(), res);
        String[] ans = new String[res.size()];
        return res.toArray(ans);
    }

    private void backtrack(List<List<Character>> groups, int idx, StringBuilder sb, List<String> res) {
        if (idx == groups.size()) {
            res.add(sb.toString());
            return;
        }

        for (char c : groups.get(idx)) {
            sb.append(c);
            backtrack(groups, idx + 1, sb, res);
            sb.setLength(sb.length() - 1);
        }
    }
}
