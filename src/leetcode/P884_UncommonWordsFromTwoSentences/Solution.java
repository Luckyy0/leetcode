package leetcode.P884_UncommonWordsFromTwoSentences;

import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : s1.split(" "))
            map.put(w, map.getOrDefault(w, 0) + 1);
        for (String w : s2.split(" "))
            map.put(w, map.getOrDefault(w, 0) + 1);

        List<String> res = new ArrayList<>();
        for (String w : map.keySet()) {
            if (map.get(w) == 1)
                res.add(w);
        }
        return res.toArray(new String[0]);
    }
}
