package leetcode.P819_MostCommonWord;

import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();

        // Replace all non-letter characters with spaces and split
        // Thay the tat ca cac ky tu khong phai chu cai bang khoang trang va chia nho
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").split("\\s+");

        String res = "";
        int max = 0;

        for (String w : words) {
            if (!w.isEmpty() && !bannedSet.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
                if (counts.get(w) > max) {
                    max = counts.get(w);
                    res = w;
                }
            }
        }

        return res;
    }
}
