package leetcode.P902_NumbersAtMostNGivenDigitSet;

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int L = s.length();
        int dLen = digits.length;
        int res = 0;

        // Numbers with length < L
        for (int i = 1; i < L; i++) {
            res += Math.pow(dLen, i);
        }

        // Numbers with length L
        for (int i = 0; i < L; i++) {
            boolean hasSameDigit = false;
            for (String d : digits) {
                if (d.charAt(0) < s.charAt(i)) {
                    res += Math.pow(dLen, L - 1 - i);
                } else if (d.charAt(0) == s.charAt(i)) {
                    hasSameDigit = true;
                }
            }
            if (!hasSameDigit)
                return res;
        }

        return res + 1;
    }
}
