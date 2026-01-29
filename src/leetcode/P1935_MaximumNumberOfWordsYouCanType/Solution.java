package leetcode.P1935_MaximumNumberOfWordsYouCanType;

public class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for (char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String w : words) {
            boolean ok = true;
            for (char c : w.toCharArray()) {
                if (broken[c - 'a']) {
                    ok = false;
                    break;
                }
            }
            if (ok)
                count++;
        }

        return count;
    }
}
