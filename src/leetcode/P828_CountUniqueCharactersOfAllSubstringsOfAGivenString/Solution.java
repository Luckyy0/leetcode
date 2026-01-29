package leetcode.P828_CountUniqueCharactersOfAllSubstringsOfAGivenString;

import java.util.*;

class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++)
            pos[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - 'A'].add(i);
        }

        long res = 0;
        for (int i = 0; i < 26; i++) {
            List<Integer> list = pos[i];
            for (int j = 0; j < list.size(); j++) {
                int curr = list.get(j);
                int prev = (j == 0) ? -1 : list.get(j - 1);
                int next = (j == list.size() - 1) ? n : list.get(j + 1);

                res += (long) (curr - prev) * (next - curr);
            }
        }

        return (int) res;
    }
}
