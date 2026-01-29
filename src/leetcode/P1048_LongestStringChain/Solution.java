package leetcode.P1048_LongestStringChain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Map<String, Integer> dp = new HashMap<>();
        int maxChain = 1;

        for (String word : words) {
            int currentMax = 1;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                if (dp.containsKey(prev)) {
                    currentMax = Math.max(currentMax, dp.get(prev) + 1);
                }
            }
            dp.put(word, currentMax);
            maxChain = Math.max(maxChain, currentMax);
        }

        return maxChain;
    }
}
