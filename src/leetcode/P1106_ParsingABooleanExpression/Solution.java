package leetcode.P1106_ParsingABooleanExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c == ',')
                continue;

            if (c != ')') {
                stack.push(c);
            } else {
                List<Boolean> vals = new ArrayList<>();
                while (stack.peek() != '(') {
                    char val = stack.pop();
                    vals.add(val == 't');
                }
                stack.pop(); // remove '('
                char op = stack.pop();
                boolean res = evaluate(op, vals);
                stack.push(res ? 't' : 'f');
            }
        }

        return stack.pop() == 't';
    }

    private boolean evaluate(char op, List<Boolean> vals) {
        if (op == '!') {
            return !vals.get(0);
        }
        if (op == '&') {
            for (boolean v : vals)
                if (!v)
                    return false;
            return true;
        }
        if (op == '|') {
            for (boolean v : vals)
                if (v)
                    return true;
            return false;
        }
        return false;
    }
}
