package leetcode.P1704_DetermineIfStringHalvesAreAlike;

import java.util.Set;

public class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int n = s.length();
        int mid = n / 2;
        int c1 = 0, c2 = 0;

        for (int i = 0; i < mid; i++) {
            if (vowels.contains(s.charAt(i)))
                c1++;
        }
        for (int i = mid; i < n; i++) {
            if (vowels.contains(s.charAt(i)))
                c2++;
        }

        return c1 == c2;
    }
}
