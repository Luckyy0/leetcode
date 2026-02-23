package leet_code.Problem_816_Medium_Ambiguous_Coordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * Generates all possible ambiguous coordinates.
     * Strategy: Split string into X and Y, then try all possible decimal placements
     * for each.
     * Time: O(N^3), Space: O(N^3).
     */
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        // Remove '(' and ')'
        String digits = s.substring(1, s.length() - 1);
        int n = digits.length();

        // Try all ways to split into two coordinates: X and Y
        for (int i = 1; i < n; i++) {
            List<String> xValid = getValids(digits.substring(0, i));
            List<String> yValid = getValids(digits.substring(i));

            // Combine all valid X with all valid Y
            for (String x : xValid) {
                for (String y : yValid) {
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }

        return result;
    }

    /**
     * Returns all valid numeric representations of a digit string (integer or
     * decimal).
     */
    private List<String> getValids(String s) {
        List<String> validList = new ArrayList<>();
        int n = s.length();

        // 1. Integer case (no decimal point)
        // Valid if it's "0" or doesn't have a leading zero
        if (n == 1 || s.charAt(0) != '0') {
            validList.add(s);
        }

        // 2. Decimal point insertion cases
        // Decimal point can be after any character except the last one
        for (int dot = 1; dot < n; dot++) {
            String left = s.substring(0, dot);
            String right = s.substring(dot);

            // Validation rules:
            // Left part (integer): No leading zeros (unless it's just "0")
            // Right part (decimal): No trailing zeros
            if ((left.length() == 1 || left.charAt(0) != '0') &&
                    right.charAt(right.length() - 1) != '0') {
                validList.add(left + "." + right);
            }
        }

        return validList;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Result 1: " + sol.ambiguousCoordinates("(123)"));
        System.out.println("Result 2: " + sol.ambiguousCoordinates("(0123)"));
        System.out.println("Result 3: " + sol.ambiguousCoordinates("(00011)"));
    }
}
