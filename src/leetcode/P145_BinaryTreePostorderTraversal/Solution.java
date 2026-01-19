package leetcode.P145_BinaryTreePostorderTraversal;

import java.util.LinkedList;
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
     * Problem 145: Binary Tree Postorder Traversal
     * Approach: Iterative with LinkedList (Reverse of Modified Preorder)
     * 
     * Theoretical Basis:
     * - Order: Left -> Right -> Root
     * - Modified Preorder (Root -> Right -> Left) reversed is Postorder.
     * - We can use a LinkedList and add elements to the head to avoid explicit
     * reversal.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // Add to the front of the list
            result.addFirst(node.val);

            // Push left child first so right is processed first for "Modified Preorder"
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> null, 2 -> 3
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2, n3, null);
        TreeNode n1 = new TreeNode(1, null, n2);

        System.out.println("Test: " + solution.postorderTraversal(n1)); // Expected: [3, 2, 1]
    }
}
