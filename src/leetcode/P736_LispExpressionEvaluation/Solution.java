package leetcode.P736_LispExpressionEvaluation;

import java.util.*;

class Solution {
    public int evaluate(String expression) {
        return eval(expression, new HashMap<>());
    }

    private int eval(String exp, Map<String, Integer> outerScope) {
        if (exp.charAt(0) != '(') {
            // Number or registered variable
            if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-') {
                return Integer.parseInt(exp);
            }
            return outerScope.get(exp);
        }

        Map<String, Integer> scope = new HashMap<>(outerScope);
        // Remove outer parens
        String content = exp.substring(exp.charAt(1) == ' ' ? 2 : 1, exp.length() - 1);
        List<String> tokens = split(content);
        String operation = tokens.get(0);

        if (operation.equals("add")) {
            return eval(tokens.get(1), scope) + eval(tokens.get(2), scope);
        } else if (operation.equals("mult")) {
            return eval(tokens.get(1), scope) * eval(tokens.get(2), scope);
        } else { // "let"
            for (int j = 1; j < tokens.size() - 1; j += 2) {
                scope.put(tokens.get(j), eval(tokens.get(j + 1), scope));
            }
            return eval(tokens.get(tokens.size() - 1), scope);
        }
    }

    private List<String> split(String s) {
        List<String> res = new ArrayList<>();
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(')
                balance++;
            if (c == ')')
                balance--;
            if (c == ' ' && balance == 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        res.add(sb.toString());
        return res;
    }
}
