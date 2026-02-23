package leet_code.Problem_255_Medium_Verify_Preorder_Sequence_In_BST;

import java.util.Stack;

public class Solution_Stack {

    /**
     * Verifies if the sequence is a valid preorder of a BST.
     * Uses a Monotonic Stack to track lower bounds.
     * Time: O(N), Space: O(N).
     * 
     * Xác minh xem chuỗi có phải là preorder hợp lệ của BST không.
     * Sử dụng Ngăn xếp đơn điệu để theo dõi giới hạn dưới.
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int minLimit = Integer.MIN_VALUE;

        for (int num : preorder) {
            // If current number violates the lower limit constraint, return false
            // Nếu số hiện tại vi phạm giới hạn dưới, trả về false
            if (num < minLimit) {
                return false;
            }

            // While we encounter values larger than stack top, it means we are moving
            // to the right child of some ancestor. We pop until we find the parent.
            // The last popped value becomes the new lower limit (parent's value).
            // Khi gặp giá trị lớn hơn đỉnh stack, nghĩa là đang di chuyển sang nhánh phải.
            // Pop cho đến khi tìm thấy cha. Giá trị pop cuối cùng là giới hạn dưới mới.
            while (!stack.isEmpty() && num > stack.peek()) {
                minLimit = stack.pop();
            }

            stack.push(num);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Stack solution = new Solution_Stack();

        // Test Case 1: [5,2,1,3,6] -> true
        int[] p1 = { 5, 2, 1, 3, 6 };
        System.out.println("Verify 1: " + solution.verifyPreorder(p1));

        // Test Case 2: [5,2,6,1,3] -> false
        int[] p2 = { 5, 2, 6, 1, 3 };
        System.out.println("Verify 2: " + solution.verifyPreorder(p2));
    }
}
