package leetcode.P2116_CheckIfAParenthesesStringCanBeValid;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 != 0)
            return false;

        // Left to Right: Check if we have enough potential Opens to matching Closed
        int bal = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
            }
            if (bal < 0)
                return false;
        }

        // Right to Left: Check if we have enough potential Closed to match Opens
        bal = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                bal++;
            } else {
                bal--;
            }
            if (bal < 0)
                return false;
        }

        return true;
    }
}
