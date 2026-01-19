package leetcode.P225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * Problem 225: Implement Stack using Queues
     * Approach: One Queue with Rotation on Push
     * 
     * Theoretical Basis:
     * - Make Push expensive (O(N)) to keep Pop cheap (O(1)).
     * - Every time we push, rotate existing elements behind the new one.
     */
    static class MyStack {
        private Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
            // Rotate the previous n elements to the back
            int sz = queue.size();
            for (int i = 0; i < sz - 1; i++) {
                queue.add(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);

        // top -> 2
        System.out.println("Top: " + myStack.top());

        // pop -> 2
        System.out.println("Pop: " + myStack.pop());

        // empty -> false
        System.out.println("Empty: " + myStack.empty());

        // pop -> 1
        System.out.println("Pop: " + myStack.pop());

        // empty -> true
        System.out.println("Empty: " + myStack.empty());
    }
}
