package leetcode.P306_AdditiveNumber;

import java.math.BigInteger;

public class Solution {

    /**
     * Problem 306: Additive Number
     * Approach: Brute Force first two numbers + Validation
     * 
     * Time Complexity: O(N^3)
     * Space Complexity: O(N)
     */
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3)
            return false;

        // Iterate length of first number
        for (int i = 1; i <= n / 2; i++) { // Optimization: first number can't exceed half if 3rd exists? Roughly.

            // Check leading zero for first number
            if (num.charAt(0) == '0' && i > 1)
                break;

            // Iterate length of second number
            for (int j = 1; n - i - j >= Math.max(i, j); j++) {

                // Check leading zero for second number
                if (num.charAt(i) == '0' && j > 1)
                    break; // continue loop, but actually for this 'i', larger 'j' starting with 0 is also
                           // invalid? No, j=1 is "0", j=2 is "0x". All invalid.

                String s1 = num.substring(0, i);
                String s2 = num.substring(i, i + j);

                if (isValid(s1, s2, num.substring(i + j))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(String s1, String s2, String remaining) {
        if (remaining.length() == 0)
            return true; // Reached end successfully

        // Use BigInteger for safety with 35 digit constraints
        BigInteger bi1 = new BigInteger(s1);
        BigInteger bi2 = new BigInteger(s2);
        BigInteger sum = bi1.add(bi2);
        String sumStr = sum.toString();

        if (!remaining.startsWith(sumStr)) {
            return false;
        }

        return isValid(s2, sumStr, remaining.substring(sumStr.length()));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // "112358" -> true
        runTest(solution, "112358", true);

        // "199100199" -> true
        runTest(solution, "199100199", true);

        // "1023" -> false (1,0,1, but 1023 -> 1+0=1!=2)
        runTest(solution, "1023", false);

        // "101" -> true (1, 0, 1)
        runTest(solution, "101", true);
    }

    private static void runTest(Solution s, String num, boolean expected) {
        boolean result = s.isAdditiveNumber(num);
        System.out.println("Input: " + num + " -> " + result + " (Expected: " + expected + ")");
        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
