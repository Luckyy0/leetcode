package leet_code.Problem_682_Easy_Baseball_Game;

import java.util.*;

public class Solution {

    /**
     * Calculates the total score based on a sequence of operations.
     * Strategy: Use a Stack to manage historical scores and their dependencies.
     * Time: O(N), Space: O(N).
     */
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("+")) {
                // Record sum of last two scores
                int top = stack.pop();
                int secondTop = stack.peek();
                int newScore = top + secondTop;
                stack.push(top); // Put back top
                stack.push(newScore); // Add new sum
            } else if (op.equals("D")) {
                // Record double of last score
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                // Invalidate/Cancel last score
                stack.pop();
            } else {
                // Numeric score
                stack.push(Integer.parseInt(op));
            }
        }

        // Sum all scores in the stack
        int total = 0;
        for (int score : stack) {
            total += score;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] ops1 = { "5", "2", "C", "D", "+" };
        System.out.println("Total score (ops1): " + sol.calPoints(ops1)); // 30

        String[] ops2 = { "5", "-2", "4", "C", "D", "9", "+", "+" };
        System.out.println("Total score (ops2): " + sol.calPoints(ops2)); // 27
    }
}
