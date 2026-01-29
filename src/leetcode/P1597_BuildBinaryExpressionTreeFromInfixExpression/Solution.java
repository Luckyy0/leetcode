package leetcode.P1597_BuildBinaryExpressionTreeFromInfixExpression;

import java.util.Stack;

class Node {
    char val;
    Node left;
    Node right;

    Node() {
        this.val = ' ';
    }

    Node(char val) {
        this.val = val;
    }

    Node(char val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public Node expTree(String s) {
        Stack<Node> nodes = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                nodes.push(new Node(c));
            } else if (c == '(') {
                ops.push(c);
            } else if (c == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    process(nodes, ops);
                }
                ops.pop(); // Pop '('
            } else {
                while (!ops.isEmpty() && ops.peek() != '(' && precedence(ops.peek()) >= precedence(c)) {
                    process(nodes, ops);
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            process(nodes, ops);
        }

        return nodes.peek();
    }

    private void process(Stack<Node> nodes, Stack<Character> ops) {
        char op = ops.pop();
        Node right = nodes.pop();
        Node left = nodes.pop();
        nodes.push(new Node(op, left, right));
    }

    private int precedence(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        return 0;
    }
}
