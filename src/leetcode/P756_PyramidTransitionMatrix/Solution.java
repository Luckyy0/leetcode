package leetcode.P756_PyramidTransitionMatrix;

import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();
    Set<String> memo = new HashSet<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return solve(bottom, "");
    }

    private boolean solve(String bottom, String next) {
        if (bottom.length() == 1)
            return true;
        if (next.length() == bottom.length() - 1) {
            if (memo.contains(next))
                return false;
            if (solve(next, ""))
                return true;
            memo.add(next);
            return false;
        }

        int i = next.length();
        String key = bottom.substring(i, i + 2);
        if (map.containsKey(key)) {
            for (char c : map.get(key)) {
                if (solve(bottom, next + c))
                    return true;
            }
        }
        return false;
    }
}
