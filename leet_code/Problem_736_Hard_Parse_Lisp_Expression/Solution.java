package leet_code.Problem_736_Hard_Parse_Lisp_Expression;

import java.util.*;

public class Solution {

    /**
     * Evaluates a Lisp-like expression.
     * Strategy: Recursive descent with local environment mapping for scoping.
     * Time: O(N^2), Space: O(N^2).
     */
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String exp, Map<String, Integer> parentMap) {
        // Numeric case
        if (exp.charAt(0) != '(') {
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return parentMap.get(exp); // Variable lookup
        }

        // Parenthetical case: strip outer '(' and ')'
        String s = exp.substring(exp.indexOf(' ') + 1, exp.length() - 1);
        List<String> tokens = parse(s);

        // Scope management: always start with a fresh copy to handle shadowing
        Map<String, Integer> currentMap = new HashMap<>(parentMap);

        if (exp.startsWith("(add")) {
            return eval(tokens.get(0), currentMap) + eval(tokens.get(1), currentMap);
        } else if (exp.startsWith("(mult")) {
            return eval(tokens.get(0), currentMap) * eval(tokens.get(1), currentMap);
        } else {
            // "let" case: process pairs and the final expression
            for (int i = 0; i < tokens.size() - 1; i += 2) {
                currentMap.put(tokens.get(i), eval(tokens.get(i + 1), currentMap));
            }
            return eval(tokens.get(tokens.size() - 1), currentMap);
        }
    }

    /**
     * Splits an expression body into high-level tokens effectively.
     */
    private List<String> parse(String s) {
        List<String> tokens = new ArrayList<>();
        int balance = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            if (c == ')')
                balance--;

            if (c == ' ' && balance == 0) {
                tokens.add(sb.toString());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0)
            tokens.add(sb.toString());
        return tokens;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")); // 14
        System.out.println(sol.evaluate("(let x 3 x 2 x)")); // 2
        System.out.println(sol.evaluate("(let x 1 y 2 x (add x y) (add x y))")); // 5
    }
}
