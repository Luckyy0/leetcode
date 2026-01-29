package leetcode.P1628_DesignAnExpressionTreeWithEvaluateFunction;

import java.util.Stack;

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumNode extends Node {
    int val;

    NumNode(int val) {
        this.val = val;
    }

    public int evaluate() {
        return val;
    }
}

class OpNode extends Node {
    char op;
    Node left, right;

    OpNode(char op, Node left, Node right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public int evaluate() {
        int l = left.evaluate();
        int r = right.evaluate();
        switch (op) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
            case '/':
                return l / r;
        }
        return 0;
    }
}

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for (String s : postfix) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Node right = stack.pop();
                Node left = stack.pop();
                stack.push(new OpNode(s.charAt(0), left, right));
            } else {
                stack.push(new NumNode(Integer.parseInt(s)));
            }
        }
        return stack.peek();
    }
}
