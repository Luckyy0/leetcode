package leetcode.P720_LongestWordInDictionary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words); // Sort lexicographically
        Set<String> validWords = new HashSet<>();
        String result = "";

        for (String w : words) {
            // A word is valid if its length is 1 or its prefix (dropping last char) is
            // already valid
            // Một từ là hợp lệ nếu nó có độ dài bằng 1 hoặc tiền tố của nó (bỏ ký tự cuối)
            // đã hợp lệ
            if (w.length() == 1 || validWords.contains(w.substring(0, w.length() - 1))) {
                validWords.add(w);

                if (w.length() > result.length()) {
                    result = w;
                }
                // Because we sorted the overall list, we don't need a tie-breaker check here
                // for lexicographical order (the first word of a specific length encountered is
                // the one).
                // Wait, result update happens ONLY if longer. Lexicographical tie is handled by
                // sort.
            }
        }

        return result;
    }
}
