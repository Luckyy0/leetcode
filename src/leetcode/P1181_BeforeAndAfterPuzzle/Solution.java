package leetcode.P1181_BeforeAndAfterPuzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        int n = phrases.length;
        Map<String, List<Integer>> startsWith = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String p = phrases[i];
            int space = p.indexOf(' ');
            String first = (space == -1) ? p : p.substring(0, space);
            startsWith.putIfAbsent(first, new ArrayList<>());
            startsWith.get(first).add(i);
        }

        Set<String> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String p = phrases[i];
            int space = p.lastIndexOf(' ');
            String last = (space == -1) ? p : p.substring(space + 1);

            if (startsWith.containsKey(last)) {
                for (int j : startsWith.get(last)) {
                    if (i == j)
                        continue;

                    String second = phrases[j];
                    // Skip first word of second phrase (length of 'last' + maybe space)
                    // If second consists only of one word, resulting suffix is empty?
                    // "a" + "a" -> "a". "a" + "a b" -> "a b".
                    // Concatenate: p + second.substring(last.length()).

                    res.add(p + second.substring(last.length()));
                }
            }
        }

        List<String> sortedRes = new ArrayList<>(res);
        Collections.sort(sortedRes);
        return sortedRes;
    }
}
