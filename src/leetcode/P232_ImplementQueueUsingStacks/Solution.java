package leetcode.P232_ImplementQueueUsingStacks;

import java.util.Stack;

public class Solution {

    /**
     * Problem 232: Implement Queue using Stacks
     * Approach: Two Stacks (Input and Output)
     * 
     * Theoretical Basis:
     * - Push to Input Stack.
     * - Pop from Output Stack.
     * - If Output Stack empty, move everything from Input to Output (reversing
     * order).
     * 
     * Time Complexity: Amortized O(1)
     * Space Complexity: O(N)
     */
    static class MyQueue {
        private Stack<Integer> inStack;
        private Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                moveInToOut();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                moveInToOut();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void moveInToOut() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);

        // peek -> 1
        System.out.println("Peek: " + q.peek());

        // pop -> 1
        System.out.println("Pop: " + q.pop());

        // empty -> false
        System.out.println("Empty: " + q.empty());

        // pop -> 2
        System.out.println("Pop: " + q.pop());

        // empty -> true
        System.out.println("Empty: " + q.empty());
    }
}
