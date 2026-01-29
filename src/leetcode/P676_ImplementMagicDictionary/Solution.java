package leetcode.P676_ImplementMagicDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MagicDictionary {
    private Map<Integer, List<String>> dict;

    public MagicDictionary() {
        dict = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (String s : dictionary) {
            int len = s.length();
            dict.putIfAbsent(len, new ArrayList<>());
            dict.get(len).add(s);
        }
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        if (!dict.containsKey(len))
            return false;

        for (String candidate : dict.get(len)) {
            int diff = 0;
            for (int i = 0; i < len; i++) {
                if (searchWord.charAt(i) != candidate.charAt(i)) {
                    diff++;
                    if (diff > 1)
                        break;
                }
            }
            if (diff == 1)
                return true;
        }

        return false;
    }
}
