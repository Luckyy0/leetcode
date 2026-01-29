package leetcode.P1896_MinimumCostToChangeTheFinalValueOfExpression;

import java.util.Stack;

public class Solution {
    class State {
        int val;
        int cost; // cost to flip

        State(int v, int c) {
            val = v;
            cost = c;
        }
    }

    public int minOperationsToFlip(String expression) {
        Stack<State> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        // Use a dummy wrapper or handle iteration
        // Standard Shunting-yard or 2-stack evaluation

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    process(values, ops.pop());
                }
                ops.pop(); // pop '('
            } else if (c == '&' || c == '|') {
                // Precedence: & > |
                while (!ops.isEmpty() && ops.peek() != '(' && precedence(ops.peek()) >= precedence(c)) {
                    process(values, ops.pop());
                }
                ops.push(c);
            } else {
                // '0' or '1'
                values.push(new State(c - '0', 1));
            }
        }

        while (!ops.isEmpty()) {
            process(values, ops.pop());
        }

        return values.peek().cost;
    }

    private int precedence(char op) {
        if (op == '&')
            return 2;
        if (op == '|')
            return 1;
        return 0;
    }

    private void process(Stack<State> values, char op) {
        State s2 = values.pop();
        State s1 = values.pop();

        int v1 = s1.val;
        int c1 = s1.cost; // cost to flip s1
        int v2 = s2.val;
        int c2 = s2.cost; // cost to flip s2

        int newVal;
        int newCost;

        if (op == '&') {
            newVal = v1 & v2;
            if (newVal == 0) {
                // Current 0. Want 1.
                // Case 0&0 -> Want 1&1 (cost c1+c2) OR Change to | (cost 1 + min(c1,c2) since
                // 0|1 or 1|0 make 1)
                if (v1 == 0 && v2 == 0) {
                    newCost = Math.min(c1 + c2, 1 + Math.min(c1, c2)); // actually 1+min is always better? c>=1. c1+c2
                                                                       // >= 1+min.
                    // e.g. 1+1=2. 1+1=2.
                } else {
                    // One is 0, one is 1.
                    // Change 0->1 (cost cOfZero) OR Change op (cost 1, result 1|0=1).
                    // cost = min(cOfZero, 1).
                    int cZero = (v1 == 0) ? c1 : c2;
                    newCost = Math.min(cZero, 1);
                }
            } else {
                // Current 1 (1&1). Want 0.
                // Keep &: 0&1 or 1&0. cost min(c1, c2).
                // Change |: 1|1=1. Need 0|0 cost 1+c1+c2. Worse.
                newCost = Math.min(c1, c2);
            }
        } else { // op == '|'
            newVal = v1 | v2;
            if (newVal == 1) {
                // Current 1. Want 0.
                // 1|1 -> need 0|0 (cost c1+c2) OR change op (&) -> 1&1=1 (need 0&1 -> no op
                // change gives 1&1=1).
                // Wait. Change op to &: 1&1=1. Wait.
                // If 1|1, we want 0.
                // Change op to &: 1&1=1. Still 1. And we need 0. So change op + flip one?
                // Actually:
                // If 1|1:
                // Keep |: Need 0|0. cost c1+c2.
                // Change to &: Need 0&1 or 1&0 or 0&0. cost 1 + min(c1, c2).
                // 1+min is better.
                if (v1 == 1 && v2 == 1) {
                    newCost = Math.min(c1 + c2, 1 + Math.min(c1, c2));
                } else {
                    // One is 1, one is 0. (e.g. 1|0 = 1).
                    // Keep |: Flip 1->0. Cost cOfOne.
                    // Change to &: 1&0=0. Free! Cost 1.
                    int cOne = (v1 == 1) ? c1 : c2;
                    newCost = Math.min(cOne, 1);
                }
            } else {
                // Current 0 (0|0). Want 1.
                // Keep |: min(c1, c2).
                // Change &: 0&0=0. Need 1&1. Expensive.
                newCost = Math.min(c1, c2);
            }
        }

        values.push(new State(newVal, newCost));
    }
}
