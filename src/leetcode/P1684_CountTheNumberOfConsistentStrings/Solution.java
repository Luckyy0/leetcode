package leetcode.P1684_CountTheNumberOfConsistentStrings;

public class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allow[c - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (!allow[c - 'a']) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                count++;
        }

        return count;
    }
}
