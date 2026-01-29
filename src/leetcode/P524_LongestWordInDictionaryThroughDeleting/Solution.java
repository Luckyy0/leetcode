package leetcode.P524_LongestWordInDictionaryThroughDeleting;

import java.util.*;

public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() ||
                        (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isSubsequence(String sub, String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (i < sub.length() && sub.charAt(i) == c)
                i++;
        }
        return i == sub.length();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"))); // "apple"
    }
}
