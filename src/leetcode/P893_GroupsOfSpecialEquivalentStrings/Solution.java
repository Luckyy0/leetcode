package leetcode.P893_GroupsOfSpecialEquivalentStrings;

import java.util.*;

class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) {
            int[] even = new int[26];
            int[] odd = new int[26];
            for (int i = 0; i < w.length(); i++) {
                if (i % 2 == 0)
                    even[w.charAt(i) - 'a']++;
                else
                    odd[w.charAt(i) - 'a']++;
            }
            set.add(Arrays.toString(even) + Arrays.toString(odd));
        }
        return set.size();
    }
}
