package leetcode.P1003_CheckIfWordIsValidAfterSubstitutions;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            int n = sb.length();
            if (n >= 3 && sb.charAt(n - 1) == 'c' && sb.charAt(n - 2) == 'b' && sb.charAt(n - 3) == 'a') {
                sb.delete(n - 3, n);
            }
        }
        return sb.length() == 0;
    }
}
