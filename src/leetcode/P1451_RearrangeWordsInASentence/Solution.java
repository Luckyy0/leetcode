package leetcode.P1451_RearrangeWordsInASentence;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, Comparator.comparingInt(String::length));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                char[] chars = words[i].toCharArray();
                if (chars.length > 0)
                    chars[0] = Character.toUpperCase(chars[0]);
                sb.append(new String(chars));
            } else {
                sb.append(words[i]);
            }
            if (i < words.length - 1)
                sb.append(" ");
        }

        return sb.toString();
    }
}
