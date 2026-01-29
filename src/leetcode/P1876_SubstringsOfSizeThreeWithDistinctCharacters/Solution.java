package leetcode.P1876_SubstringsOfSizeThreeWithDistinctCharacters;

public class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            char a = chars[i];
            char b = chars[i + 1];
            char c = chars[i + 2];
            if (a != b && a != c && b != c) {
                count++;
            }
        }
        return count;
    }
}
