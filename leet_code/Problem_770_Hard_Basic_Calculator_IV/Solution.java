package leet_code.Problem_770_Hard_Basic_Calculator_IV;

import java.util.*;

public class Solution {

    /**
     * Represents a mathematical term with variables and coefficient.
     */
    static class Poly implements Comparable<Poly> {
        // Map from sorted list of variables to coefficient
        // Example: 3*a*b -> key=["a", "b"], value=3
        Map<List<String>, Integer> terms;

        public Poly() {
            terms = new HashMap<>();
        }

        // Create a single term polynomial (variable or constant)
        public static Poly make(String s) {
            Poly p = new Poly();
            if (Character.isDigit(s.charAt(0))) {
                p.terms.put(new ArrayList<>(), Integer.parseInt(s));
            } else {
                List<String> vars = new ArrayList<>();
                vars.add(s);
                p.terms.put(vars, 1);
            }
            return p;
        }

        // Add two polynomials
        public Poly add(Poly other) {
            Poly res = new Poly();
            for (Map.Entry<List<String>, Integer> e : this.terms.entrySet()) {
                res.update(e.getKey(), e.getValue());
            }
            for (Map.Entry<List<String>, Integer> e : other.terms.entrySet()) {
                res.update(e.getKey(), e.getValue());
            }
            return res;
        }

        // Subtract
        public Poly sub(Poly other) {
            Poly res = new Poly();
            for (Map.Entry<List<String>, Integer> e : this.terms.entrySet()) {
                res.update(e.getKey(), e.getValue());
            }
            for (Map.Entry<List<String>, Integer> e : other.terms.entrySet()) {
                res.update(e.getKey(), -e.getValue());
            }
            return res;
        }

        // Multiply
        public Poly mul(Poly other) {
            Poly res = new Poly();
            for (Map.Entry<List<String>, Integer> e1 : this.terms.entrySet()) {
                for (Map.Entry<List<String>, Integer> e2 : other.terms.entrySet()) {
                    List<String> newVars = new ArrayList<>(e1.getKey());
                    newVars.addAll(e2.getKey());
                    Collections.sort(newVars);
                    res.update(newVars, e1.getValue() * e2.getValue());
                }
            }
            return res;
        }

        // Update helper with zero filtering
        void update(List<String> vars, int coef) {
            int newCoef = terms.getOrDefault(vars, 0) + coef;
            if (newCoef == 0) {
                terms.remove(vars);
            } else {
                terms.put(vars, newCoef);
            }
        }

        // For sorting output format
        // Degree descending, then lexicographical
        @Override
        public int compareTo(Poly o) {
            // Not used directly, terms are inside map.
            // We sort output strings.
            return 0;
        }

        // Convert to required output format
        public List<String> toList() {
            List<List<String>> sortedKeys = new ArrayList<>(terms.keySet());
            Collections.sort(sortedKeys, (a, b) -> {
                if (a.size() != b.size())
                    return b.size() - a.size(); // Descending degree
                for (int i = 0; i < a.size(); i++) {
                    int cmp = a.get(i).compareTo(b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return 0;
            });

            List<String> res = new ArrayList<>();
            for (List<String> key : sortedKeys) {
                StringBuilder sb = new StringBuilder();
                sb.append(terms.get(key));
                for (String v : key) {
                    sb.append("*").append(v);
                }
                res.add(sb.toString());
            }
            return res;
        }
    }

    /**
     * Simplifies expression using Polynomial arithmetic.
     * Strategy: Two-stack parsing (shunting-yard variant) with Poly objects.
     * Time: O(len^2 * PolySize), Space: O(PolySize).
     */
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        // Prepare evaluation map
        Map<String, Integer> eval = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            eval.put(evalvars[i], evalints[i]);
        }

        Stack<Poly> operands = new Stack<>();
        Stack<Character> ops = new Stack<>();

        // Pre-parse tokens slightly for easier handling
        int n = expression.length();
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == ' ')
                continue;

            if (Character.isDigit(c)) {
                int val = 0;
                while (i < n && Character.isDigit(expression.charAt(i))) {
                    val = val * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Backtrack
                operands.push(Poly.make(String.valueOf(val)));
            } else if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < n && Character.isLetter(expression.charAt(i))) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                i--;
                String var = sb.toString();
                if (eval.containsKey(var)) {
                    operands.push(Poly.make(String.valueOf(eval.get(var))));
                } else {
                    operands.push(Poly.make(var));
                }
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    process(operands, ops.pop());
                }
                ops.pop(); // Pop '('
            } else {
                // Operator + - *
                while (!ops.isEmpty() && ops.peek() != '(' && precedence(ops.peek()) >= precedence(c)) {
                    process(operands, ops.pop());
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            process(operands, ops.pop());
        }

        return operands.peek().toList();
    }

    private int precedence(char op) {
        if (op == '*')
            return 2;
        return 1;
    }

    private void process(Stack<Poly> operands, char op) {
        Poly r = operands.pop();
        Poly l = operands.pop();
        if (op == '+')
            operands.push(l.add(r));
        if (op == '-')
            operands.push(l.sub(r));
        if (op == '*')
            operands.push(l.mul(r));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String exp1 = "e + 8 - a + 5";
        String[] vars1 = { "e" };
        int[] ints1 = { 1 };
        System.out.println("Result 1: " + sol.basicCalculatorIV(exp1, vars1, ints1));
        // ["-1*a", "14"]

        String exp2 = "(e + 8) * (e - 8)";
        String[] vars2 = {};
        int[] ints2 = {};
        System.out.println("Result 2: " + sol.basicCalculatorIV(exp2, vars2, ints2));
        // ["1*e*e", "-64"]
    }
}
