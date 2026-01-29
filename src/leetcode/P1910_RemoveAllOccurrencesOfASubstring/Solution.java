package leetcode.P1910_RemoveAllOccurrencesOfASubstring;

public class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int len = part.length();

        while (true) {
            int idx = sb.indexOf(part);
            if (idx == -1)
                break;
            sb.delete(idx, idx + len);
        }

        return sb.toString();
    }
}
