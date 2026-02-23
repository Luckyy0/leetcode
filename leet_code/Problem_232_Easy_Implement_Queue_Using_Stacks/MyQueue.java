package leet_code.Problem_232_Easy_Implement_Queue_Using_Stacks;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * Pushes element x to the back of the queue.
     * Time: O(1).
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes the element from the front of the queue and returns it.
     * Time: Amortized O(1), Worst O(N).
     */
    public int pop() {
        ensureOutputStack();
        return outputStack.pop();
    }

    /**
     * Returns the element at the front of the queue.
     * Time: Amortized O(1), Worst O(N).
     */
    public int peek() {
        ensureOutputStack();
        return outputStack.peek();
    }

    /** Returns true if the queue is empty, false otherwise. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Moves elements from inputStack to outputStack if outputStack is empty
    // Di chuyển các phần tử từ inputStack sang outputStack nếu outputStack trống
    private void ensureOutputStack() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println("Peek: " + myQueue.peek()); // 1
        System.out.println("Pop: " + myQueue.pop()); // 1
        System.out.println("Empty: " + myQueue.empty()); // false
    }
}
