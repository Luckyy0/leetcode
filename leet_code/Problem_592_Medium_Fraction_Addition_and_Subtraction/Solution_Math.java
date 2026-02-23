package leet_code.Problem_592_Medium_Fraction_Addition_and_Subtraction;

import java.util.Scanner;

public class Solution_Math {

    /**
     * Calculates the sum of fractions in a string expression.
     * Strategy: Iterative summation with GCD simplification.
     * Time: O(N log M), Space: O(1).
     */
    public String fractionAddition(String expression) {
        // Use Scanner with a delimiter that identifies fractions
        // We use lookahead/lookbehind to keep signs as part of the numbers
        Scanner sc = new Scanner(expression).useDelimiter("(?=[-+])|/");

        long A = 0, B = 1; // Current result: A/B

        while (sc.hasNext()) {
            long a = sc.nextLong(); // Next numerator
            long b = sc.nextLong(); // Next denominator

            // Standard fraction addition: A/B + a/b = (A*b + a*B) / (B*b)
            A = A * b + a * B;
            B = B * b;

            // Simplify result immediately to prevent overflow
            long common = Math.abs(gcd(A, B));
            A /= common;
            B /= common;
        }

        return A + "/" + B;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution_Math solution = new Solution_Math();
        System.out.println("-1/2+1/2 = " + solution.fractionAddition("-1/2+1/2")); // 0/1
        System.out.println("1/3-1/2 = " + solution.fractionAddition("1/3-1/2")); // -1/6
    }
}
