package leet_code.Problem_155_Medium_Min_Stack;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {

    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;

    /**
     * Initialized stack objects
     * Khởi tạo các đối tượng ngăn xếp
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * Pushes val onto stack and updates minStack if necessary
     */
    public void push(int val) {
        dataStack.push(val);
        // If minStack is empty or val is smaller/equal to current min, push to minStack
        // Nếu minStack trống hoặc giá trị mới nhỏ hơn hoặc bằng giá trị nhỏ nhất hiện
        // tại
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    /**
     * Removes top element and updates minStack if the popped element was the
     * minimum
     */
    public void pop() {
        // If the element to be removed is the current minimum, pop it from minStack too
        // Nếu phần tử bị loại bỏ là giá trị nhỏ nhất hiện tại, hãy lấy nó ra khỏi
        // minStack
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();
    }

    /**
     * Gets the top element of the main stack
     */
    public int top() {
        return dataStack.peek();
    }

    /**
     * Retrieves the minimum element in constant time
     */
    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("GetMin: " + minStack.getMin()); // Expected: -3
        minStack.pop();
        System.out.println("Top: " + minStack.top()); // Expected: 0
        System.out.println("GetMin: " + minStack.getMin()); // Expected: -2
    }
}
