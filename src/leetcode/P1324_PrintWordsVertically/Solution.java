package leetcode.P1324_PrintWordsVertically;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String w : words)
            maxLen = Math.max(maxLen, w.length());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String w : words) {
                if (i < w.length()) {
                    sb.append(w.charAt(i));
                } else {
                    sb.append(' ');
                }
            }

            // Remove trailing spaces
            int end = sb.length() - 1;
            while (end >= 0 && sb.charAt(end) == ' ') {
                end--;
            }
            result.add(sb.substring(0, end + 1));
        }

        return result;
    }
}
