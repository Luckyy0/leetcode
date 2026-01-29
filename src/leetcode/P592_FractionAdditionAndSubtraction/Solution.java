package leetcode.P592_FractionAdditionAndSubtraction;

import java.util.Scanner;

class Solution {
    public String fractionAddition(String expression) {
        // Use Scanner to parse the expression with delimiter "/|(?=[-+])"
        // Or simpler manual split since scanner with multiple delimiters is tricky for
        // signs
        // Let's iterate manually or split by pattern

        // Easier: add '+' at start if missing to uniform parsing
        // Hoặc chia nhỏ thủ công

        // The expression format is like -1/2+1/2-1/3
        // Can be split by `(?=[-+])` to get terms like ["-1/2", "+1/2", "-1/3"]
        // Wait, if start is "1/3", split might give empty first.
        // Also note that regex split keeps delimiter ?

        // Parsing approach:
        int runningNum = 0;
        int runningDenom = 1;

        // Split into fraction terms
        // Chia thành các thuật ngữ phân số
        // Logic: replace "-" with "+-" to ensure standard splitting logic?
        // Or walk through

        int i = 0;
        int n = expression.length();
        while (i < n) {
            // Parse sign
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-')
                    sign = -1;
                i++;
            }

            // Parse numerator
            int numStart = i;
            while (i < n && Character.isDigit(expression.charAt(i)))
                i++;
            int num = Integer.parseInt(expression.substring(numStart, i));

            i++; // skip '/'

            // Parse denominator
            int denomStart = i;
            while (i < n && Character.isDigit(expression.charAt(i)))
                i++;
            int denom = Integer.parseInt(expression.substring(denomStart, i));

            num = num * sign;

            // Add current fraction to running sum
            // Thêm phân số hiện tại vào tổng tích lũy
            runningNum = runningNum * denom + num * runningDenom;
            runningDenom = runningDenom * denom;

            // Simplify
            int gcd = gcd(Math.abs(runningNum), runningDenom);
            runningNum /= gcd;
            runningDenom /= gcd;
        }

        return runningNum + "/" + runningDenom;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
