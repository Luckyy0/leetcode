package leetcode.P1016_BinaryStringWithSubstringsRepresenting1ToN;

class Solution {
    public boolean queryString(String s, int n) {
        // Optimization: If n is too large relative to S length, return false.
        // There are roughly s.length() substrings.
        // We need n substrings.
        if (n > s.length() * 2)
            return false;

        for (int i = n; i >= 1; i--) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }
}
