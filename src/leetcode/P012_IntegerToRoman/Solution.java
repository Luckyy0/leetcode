package leetcode.P012_IntegerToRoman;

public class Solution {

    /**
     * Problem 12: Integer to Roman
     * Approach: Greedy
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, 3, "III");
        runTest(solution, 4, "IV");
        runTest(solution, 9, "IX");
        runTest(solution, 58, "LVIII");
        runTest(solution, 1994, "MCMXCIV");
        runTest(solution, 3999, "MMMCMXCIX");
    }

    private static void runTest(Solution s, int input, String expected) {
        System.out.println("Input: " + input);
        String result = s.intToRoman(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
