package leet_code.Problem_225_Easy_Implement_Stack_Using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Pushes element x to the top of the stack.
     * Uses O(N) time to rotate the element to front.
     */
    public void push(int x) {
        queue.add(x);
        int size = queue.size();
        // Rotate the queue size-1 times to bring the new element to front
        // Xoay hàng đợi size-1 lần để đưa phần tử mới lên đầu
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on the top of the stack and returns it. */
    public int pop() {
        return queue.remove();
    }

    /** Returns the element on the top of the stack. */
    public int top() {
        return queue.peek();
    }

    /** Returns true if the stack is empty, false otherwise. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println("Top: " + myStack.top()); // 2
        System.out.println("Pop: " + myStack.pop()); // 2
        System.out.println("Empty: " + myStack.empty()); // false
    }
}
