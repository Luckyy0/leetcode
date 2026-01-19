package leetcode.P273_IntegerToEnglishWords;

public class Solution {

    /**
     * Problem 273: Integer to English Words
     * Approach: Chunking by thousands
     * 
     * Theoretical Basis:
     * - Recursively handle groups of 3 digits.
     * 
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     */

    private final String[] LESS_THAN_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
            "Nineteen" };
    private final String[] TENS = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    private final String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 123
        runTest(solution, 123, "One Hundred Twenty Three");

        // 12345
        runTest(solution, 12345, "Twelve Thousand Three Hundred Forty Five");

        // 1234567
        runTest(solution, 1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");

        // 0
        runTest(solution, 0, "Zero");
    }

    private static void runTest(Solution s, int num, String expected) {
        String result = s.numberToWords(num);
        System.out.println("Result: \"" + result + "\" (Expected: \"" + expected + "\")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
