package leetcode.P013_RomanToInteger;

import java.util.Map;
import java.util.HashMap;

public class Solution {

    /**
     * Problem 13: Roman to Integer
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int romanToInt(String s) {
        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int val = values.get(s.charAt(i));

            // Look ahead to check subtraction
            // Nhìn về phía trước để kiểm tra phép trừ
            if (i < n - 1 && val < values.get(s.charAt(i + 1))) {
                result -= val;
            } else {
                result += val;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        runTest(solution, "III", 3);
        runTest(solution, "IV", 4);
        runTest(solution, "IX", 9);
        runTest(solution, "LVIII", 58);
        runTest(solution, "MCMXCIV", 1994);
    }

    private static void runTest(Solution s, String input, int expected) {
        System.out.println("Input: " + input);
        int result = s.romanToInt(input);
        System.out.println("Output: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
