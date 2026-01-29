package leetcode.P500_KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static final int[] ROW_MAP = new int[26];
    static {
        String[] rows = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                ROW_MAP[c - 'a'] = i;
            }
        }
    }

    /**
     * Problem 500: Keyboard Row
     * Approach: Pre-mapped characters
     * 
     * Time Complexity: O(N * L)
     * Space Complexity: O(1)
     */
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isValid(word.toLowerCase())) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }

    private boolean isValid(String word) {
        if (word.isEmpty())
            return true;
        int targetRow = ROW_MAP[word.charAt(0) - 'a'];
        for (int i = 1; i < word.length(); i++) {
            if (ROW_MAP[word.charAt(i) - 'a'] != targetRow) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // ["Hello","Alaska","Dad","Peace"] -> ["Alaska","Dad"]
        String[] w1 = { "Hello", "Alaska", "Dad", "Peace" };
        System.out.println("Result: " + java.util.Arrays.toString(sol.findWords(w1)));
    }
}
