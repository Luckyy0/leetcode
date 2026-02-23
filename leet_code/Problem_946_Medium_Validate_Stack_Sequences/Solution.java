package leet_code.Problem_946_Medium_Validate_Stack_Sequences;

import java.util.Stack;

/**
 * Problem 946: Validate Stack Sequences
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class Solution {

    /**
     * Checks if the pushed and popped sequences are valid for a stack.
     * Strategy: Greedy Simulation using Stack.
     * 
     * @param pushed Array of numbers pushed onto the stack.
     * @param popped Array of numbers popped from the stack.
     * @return true if the sequences are valid, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Sử dụng một ngăn xếp (Stack) để mô phỏng quá trình.
     *         2. Duyệt qua từng phần tử trong mảng `pushed` và thêm vào ngăn xếp.
     *         3. Sau mỗi lần thêm, kiểm tra xem phần tử ở đỉnh ngăn xếp có khớp với
     *         phần tử tiếp theo cần `pop` trong mảng `popped` hay không.
     *         4. Nếu khớp, thực hiện `pop` khỏi ngăn xếp và di chuyển con trỏ trong
     *         mảng `popped` sang phần tử tiếp theo.
     *         Lặp lại việc `pop` này chừng nào đỉnh ngăn xếp vẫn còn khớp với phần
     *         tử cần `pop`.
     *         5. Sau khi duyệt hết mảng `pushed`, nếu ngăn xếp rỗng thì chuỗi thao
     *         tác là hợp lệ.
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array

        for (int x : pushed) {
            stack.push(x);
            // Greedily pop if the top of stack matches the next popped element
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, it means all elements were successfully pushed and popped
        // in correct order
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] pushed1 = { 1, 2, 3, 4, 5 };
        int[] popped1 = { 4, 5, 3, 2, 1 };
        System.out.println("Result: " + sol.validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = { 1, 2, 3, 4, 5 };
        int[] popped2 = { 4, 3, 5, 1, 2 };
        System.out.println("Result: " + sol.validateStackSequences(pushed2, popped2)); // false
    }
}
