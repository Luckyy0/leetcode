package leetcode.P1881_MaximumValueAfterInsertion;

public class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder();
        if (n.charAt(0) == '-') {
            // Negative - minimize magnitude
            int i = 1;
            while (i < n.length() && (n.charAt(i) - '0') <= x) {
                i++;
            }
            sb.append(n.substring(0, i)).append(x).append(n.substring(i));
        } else {
            // Positive - maximize value
            int i = 0;
            while (i < n.length() && (n.charAt(i) - '0') >= x) {
                i++;
            }
            sb.append(n.substring(0, i)).append(x).append(n.substring(i));
        }
        return sb.toString();
    }
}
