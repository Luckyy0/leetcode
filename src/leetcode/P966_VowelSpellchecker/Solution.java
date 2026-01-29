package leetcode.P966_VowelSpellchecker;

import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();

        for (int i = wordlist.length - 1; i >= 0; i--) {
            String w = wordlist[i];
            String lw = w.toLowerCase();
            lowerMap.put(lw, w);
            vowelMap.put(mask(lw), w);
        }

        String[] res = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactSet.contains(q)) {
                res[i] = q;
                continue;
            }
            String lq = q.toLowerCase();
            if (lowerMap.containsKey(lq)) {
                res[i] = lowerMap.get(lq);
                continue;
            }
            String mq = mask(lq);
            if (vowelMap.containsKey(mq)) {
                res[i] = vowelMap.get(mq);
                continue;
            }
            res[i] = "";
        }
        return res;
    }

    private String mask(String w) {
        return w.replaceAll("[aeiou]", "*");
    }
}
