package leetcode.P255_VerifyPreorderSequenceInBST;

import java.util.Stack;

public class Solution {

    /**
     * Problem 255: Verify Preorder Sequence in BST
     * Approach: Stack (Monotonic logic)
     * 
     * Theoretical Basis:
     * - Keep track of lower bound.
     * - When value increases, it means we are in a right subtree of some ancestor.
     * - That ancestor becomes the lower bound for all future nodes.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;

        for (int val : preorder) {
            // If current value is smaller than current lower bound, it violates BST
            // property
            // (Wait, bound is the value of the root of the right subtree we are in)
            if (val < lowerBound) {
                return false;
            }

            // While current value > stack top, it means the stack top processed its left
            // subtree
            // and we are now going to its right. We pop it and set it as new lower bound.
            while (!stack.isEmpty() && val > stack.peek()) {
                lowerBound = stack.pop();
            }

            stack.push(val);
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [5,2,1,3,6] -> true
        runTest(solution, new int[] { 5, 2, 1, 3, 6 }, true);

        // [5,2,6,1,3] -> false (1 is smaller than 2, but 6 forced LB to 5? No)
        // Trace: 5 push, 2 push, 6 > 2 pop 2 (LB=2), 6 > 5 pop 5 (LB=5).
        // Then 1 arrives. 1 < LB(5). Fail.
        runTest(solution, new int[] { 5, 2, 6, 1, 3 }, false);
    }

    private static void runTest(Solution s, int[] preorder, boolean expected) {
        boolean result = s.verifyPreorder(preorder);
        System.out.println("Result: " + result + " (Expected: " + expected + ")");

        if (result == expected) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("-----------------");
    }
}
