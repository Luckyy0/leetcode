package leetcode.P1859_SortingTheSentence;

public class Solution {
    public String sortSentence(String s) {
        String[] parts = s.split(" ");
        String[] result = new String[parts.length];

        for (String p : parts) {
            int len = p.length();
            int idx = p.charAt(len - 1) - '1';
            result[idx] = p.substring(0, len - 1);
        }

        return String.join(" ", result);
    }
}
