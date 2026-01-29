package leetcode.P1180_CountSubstringsWithOnlyOneDistinctLetter;

class Solution {
    public int countLetters(String s) {
        int res = 0;
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c) {
                j++;
            }
            int len = j - i;
            res += (len * (len + 1)) / 2;
            i = j;
        }
        return res;
    }
}
