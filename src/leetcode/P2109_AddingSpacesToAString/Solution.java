package leetcode.P2109_AddingSpacesToAString;

public class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int spaceIdx = 0;
        int n = s.length();
        int m = spaces.length;

        for (int i = 0; i < n; i++) {
            if (spaceIdx < m && spaces[spaceIdx] == i) {
                sb.append(' ');
                spaceIdx++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
