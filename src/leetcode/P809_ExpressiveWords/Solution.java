package leetcode.P809_ExpressiveWords;

class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (check(s, word))
                count++;
        }
        return count;
    }

    private boolean check(String s, String w) {
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) != w.charAt(j))
                return false;

            char c = s.charAt(i);
            int countS = 0;
            while (i < s.length() && s.charAt(i) == c) {
                i++;
                countS++;
            }

            int countW = 0;
            while (j < w.length() && w.charAt(j) == c) {
                j++;
                countW++;
            }

            if (countS < countW)
                return false;
            if (countS > countW && countS < 3)
                return false;
        }
        return i == s.length() && j == w.length();
    }
}
