package leetcode.P824_GoatLatin;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray())
            vowels.add(c);

        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            char first = w.charAt(0);

            if (vowels.contains(first)) {
                res.append(w).append("ma");
            } else {
                res.append(w.substring(1)).append(first).append("ma");
            }

            for (int k = 0; k <= i; k++) {
                res.append('a');
            }

            if (i < words.length - 1)
                res.append(" ");
        }

        return res.toString();
    }
}
