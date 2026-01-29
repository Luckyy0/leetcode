package leetcode.P880_DecodedStringAtIndex;

class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();

        // 1. Calculate total size
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
        }

        // 2. Work backwards
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;

            if (k == 0 && Character.isLetter(c)) {
                return Character.toString(c);
            }

            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size--;
            }
        }

        return "";
    }
}
