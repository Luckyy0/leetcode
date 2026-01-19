package leetcode.P166_FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Problem 166: Fraction to Recurring Decimal
     * Approach: Long Division with Hash Map for cycle detection
     * 
     * Theoretical Basis:
     * - Remainder repeating = Cycle detected.
     * - Use Map<Remainder, IndexInStringBuilder> to know where to insert
     * parentheses.
     * 
     * Time Complexity: O(Denominator)
     * Space Complexity: O(Denominator)
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        StringBuilder res = new StringBuilder();

        // 1. Sign
        if ((numerator > 0) ^ (denominator > 0)) {
            res.append("-");
        }

        // Use long to avoid overflow for abs(MIN_VALUE)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // 2. Integer part
        res.append(num / den);
        long remainder = num % den;
        if (remainder == 0)
            return res.toString();

        // 3. Fractional part
        res.append(".");
        Map<Long, Integer> map = new HashMap<>(); // Remainder -> Index in StringBuilder

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                // Cycle detected!
                int index = map.get(remainder);
                res.insert(index, "(");
                res.append(")");
                break;
            }

            map.put(remainder, res.length());
            remainder *= 10;
            res.append(remainder / den);
            remainder %= den;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1/2 -> 0.5
        runTest(solution, 1, 2, "0.5");

        // 2/1 -> 2
        runTest(solution, 2, 1, "2");

        // 4/333 -> 0.(012)
        runTest(solution, 4, 333, "0.(012)");

        // -50/8 -> -6.25
        runTest(solution, -50, 8, "-6.25");

        // 1/6 -> 0.1(6)
        runTest(solution, 1, 6, "0.1(6)");
    }

    private static void runTest(Solution s, int n, int d, String expected) {
        String result = s.fractionToDecimal(n, d);
        System.out.println(n + "/" + d + " = " + result + " (Expected: " + expected + ")");

        if (result.equals(expected)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
