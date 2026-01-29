package leetcode.P1763_LongestNiceSubstring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2)
            return "";

        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray())
            chars.add(c);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.contains(Character.toUpperCase(c)) && chars.contains(Character.toLowerCase(c))) {
                continue;
            }

            // Split
            String s1 = longestNiceSubstring(s.substring(0, i));
            String s2 = longestNiceSubstring(s.substring(i + 1));

            return s1.length() >= s2.length() ? s1 : s2;
        }

        return s;
    }
}
