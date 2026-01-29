package leetcode.P1006_ClumsyFactorial;

import java.util.Stack;

class Solution {
    public int clumsy(int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        n--;

        int op = 0; // 0:*, 1:/, 2:+, 3:-
        while (n > 0) {
            if (op == 0) {
                stack.push(stack.pop() * n);
            } else if (op == 1) {
                stack.push(stack.pop() / n);
            } else if (op == 2) {
                stack.push(n);
            } else {
                stack.push(-n);
            }

            n--;
            op = (op + 1) % 4;
        }

        int sum = 0;
        for (int x : stack)
            sum += x;
        return sum;
    }
}
