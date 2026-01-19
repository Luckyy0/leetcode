package leetcode.P065_ValidNumber;

public class Solution {

    /**
     * Problem 65: Valid Number
     * Approach: Scan with Flags
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign is valid only at start or after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // Dot valid only if no dot seen before AND no exponent seen before
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // Exponent valid only if digit seen before AND no exponent seen before
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset to ensure digits follow the exponent
            } else {
                // Invalid character
                return false;
            }
        }

        return seenDigit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "0", true);
        runTest(solution, "e", false);
        runTest(solution, ".", false);
        runTest(solution, "-123.456e789", true);
        runTest(solution, "1a", false);
        runTest(solution, "1e", false);
        runTest(solution, "e3", false);
        runTest(solution, "99e2.5", false);
    }

    private static void runTest(Solution s, String str, boolean expected) {
        System.out.println("Input: \"" + str + "\"");
        boolean result = s.isNumber(str);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
