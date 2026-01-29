package leetcode.P1366_RankTeamsByVotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 0)
            return "";
        int len = votes[0].length();
        Map<Character, int[]> counts = new HashMap<>();

        for (String v : votes) {
            for (int i = 0; i < len; i++) {
                char c = v.charAt(i);
                counts.putIfAbsent(c, new int[len]);
                counts.get(c)[i]++;
            }
        }

        List<Character> teams = new ArrayList<>(counts.keySet());
        Collections.sort(teams, (a, b) -> {
            int[] c1 = counts.get(a);
            int[] c2 = counts.get(b);
            for (int i = 0; i < len; i++) {
                if (c1[i] != c2[i]) {
                    return c2[i] - c1[i]; // Descending
                }
            }
            return a - b; // Ascending char
        });

        StringBuilder sb = new StringBuilder();
        for (char c : teams)
            sb.append(c);
        return sb.toString();
    }
}
