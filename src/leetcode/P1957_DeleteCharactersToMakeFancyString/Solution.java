package leetcode.P1957_DeleteCharactersToMakeFancyString;

public class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 1) == c && sb.charAt(len - 2) == c) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
