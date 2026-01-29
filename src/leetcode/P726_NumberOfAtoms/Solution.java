package leetcode.P726_NumberOfAtoms;

import java.util.*;

class Solution {
    int i;

    public String countOfAtoms(String formula) {
        i = 0;
        Map<String, Integer> counts = parse(formula);
        TreeMap<String, Integer> sorted = new TreeMap<>(counts);
        StringBuilder sb = new StringBuilder();
        for (String name : sorted.keySet()) {
            sb.append(name);
            int count = sorted.get(name);
            if (count > 1)
                sb.append(count);
        }
        return sb.toString();
    }

    private Map<String, Integer> parse(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        while (i < n && s.charAt(i) != ')') {
            if (s.charAt(i) == '(') {
                i++;
                Map<String, Integer> nested = parse(s);
                i++; // Skip ')'
                int count = getCount(s);
                for (String name : nested.keySet()) {
                    map.put(name, map.getOrDefault(name, 0) + nested.get(name) * count);
                }
            } else {
                String name = getName(s);
                int count = getCount(s);
                map.put(name, map.getOrDefault(name, 0) + count);
            }
        }
        return map;
    }

    private String getName(String s) {
        int start = i++;
        while (i < s.length() && Character.isLowerCase(s.charAt(i)))
            i++;
        return s.substring(start, i);
    }

    private int getCount(String s) {
        int start = i;
        while (i < s.length() && Character.isDigit(s.charAt(i)))
            i++;
        if (start == i)
            return 1;
        return Integer.parseInt(s.substring(start, i));
    }
}
