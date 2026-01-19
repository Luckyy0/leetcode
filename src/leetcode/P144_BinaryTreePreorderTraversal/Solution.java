package leetcode.P144_BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 144: Binary Tree Preorder Traversal
     * Approach: Iterative with Stack
     * 
     * Theoretical Basis:
     * - Order: Root -> Left -> Right
     * - Use stack to manage traversal. Push right child before left.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Push right child first so left is processed first
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> null, 2 -> 3
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode n1 = new TreeNode(1, null, n2);

        System.out.println("Test: " + solution.preorderTraversal(n1)); // Expected: [1, 2, 3]
    }
}
