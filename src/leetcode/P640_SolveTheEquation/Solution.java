package leetcode.P640_SolveTheEquation;

class Solution {
    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        String left = parts[0];
        String right = parts[1];

        int[] lhs = evaluate(left);
        int[] rhs = evaluate(right);

        // coeff * x + constant
        // lhs[0]*x + lhs[1] = rhs[0]*x + rhs[1]
        // (lhs[0] - rhs[0])*x = rhs[1] - lhs[1]

        int coeff = lhs[0] - rhs[0];
        int constant = rhs[1] - lhs[1];

        if (coeff == 0) {
            if (constant == 0)
                return "Infinite solutions";
            else
                return "No solution";
        }

        return "x=" + (constant / coeff);
    }

    private int[] evaluate(String expr) {
        // Break by + or - (and preserve delimiter logic)
        // Split (?=[+-]) splits *before* + or -
        String[] tokens = expr.split("(?=[+-])");

        int coeff = 0;
        int constant = 0;

        for (String token : tokens) {
            if (token.isEmpty())
                continue;

            if (token.equals("+x") || token.equals("x")) {
                coeff += 1;
            } else if (token.equals("-x")) {
                coeff -= 1;
            } else if (token.contains("x")) {
                // e.g. "2x", "-2x"
                int val = Integer.parseInt(token.substring(0, token.indexOf("x"))); // "2" or "-2"
                coeff += val;
            } else {
                // constant
                constant += Integer.parseInt(token);
            }
        }

        return new int[] { coeff, constant };
    }
}
