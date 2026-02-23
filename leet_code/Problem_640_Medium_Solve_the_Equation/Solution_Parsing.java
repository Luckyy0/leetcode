package leet_code.Problem_640_Medium_Solve_the_Equation;

import java.util.*;

public class Solution_Parsing {

    /**
     * Solves a linear equation for x.
     * Strategy: Parse terms into coefficient of x and constant for each side.
     * Time: O(L), Space: O(L).
     */
    public String solveEquation(String equation) {
        String[] sides = equation.split("=");
        int[] left = parseSide(sides[0]);
        int[] right = parseSide(sides[1]);

        int xCount = left[0] - right[0];
        int constant = right[1] - left[1];

        if (xCount == 0) {
            if (constant == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }

        return "x=" + (constant / xCount);
    }

    private int[] parseSide(String side) {
        // Regex split keeping the delimiters (+ and -)
        // Using positive lookahead (?=[+-]) splits before any + or -
        String[] terms = side.split("(?=[+-])");
        int xCoeff = 0;
        int constant = 0;

        for (String term : terms) {
            if (term.isEmpty())
                continue;

            if (term.endsWith("x")) {
                // Determine coefficient for x
                String val = term.substring(0, term.length() - 1);
                if (val.isEmpty() || val.equals("+")) {
                    xCoeff += 1;
                } else if (val.equals("-")) {
                    xCoeff -= 1;
                } else {
                    xCoeff += Integer.parseInt(val);
                }
            } else {
                // Ordinary number
                constant += Integer.parseInt(term);
            }
        }

        return new int[] { xCoeff, constant };
    }

    public static void main(String[] args) {
        Solution_Parsing sol = new Solution_Parsing();
        System.out.println("Result (x+5-3+x=6+x-2): " + sol.solveEquation("x+5-3+x=6+x-2")); // x=2
        System.out.println("Result (x=x): " + sol.solveEquation("x=x")); // Infinite solutions
        System.out.println("Result (2x=x): " + sol.solveEquation("2x=x")); // x=0
    }
}
