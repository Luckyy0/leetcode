package leetcode.P230_KthSmallestElementInABST;

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
     * Problem 230: Kth Smallest Element in a BST
     * Approach: Iterative Inorder Traversal
     * 
     * Theoretical Basis:
     * - Inorder traversal visits nodes in ascending order.
     * - Stop at the k-th node visited.
     * 
     * Time Complexity: O(H + k)
     * Space Complexity: O(H)
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int count = 0;

        while (curr != null || !stack.isEmpty()) {
            // Go to leftmost
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Process node
            curr = stack.pop();
            count++;

            if (count == k) {
                return curr.val;
            }

            // Go right
            curr = curr.right;
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [3,1,4,null,2], k=1 -> 1
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1, null, n2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3, n1, n4);

        System.out.println("Test 1: " + solution.kthSmallest(n3, 1)); // 1

        // [5,3,6,2,4,null,null,1], k=3 -> 3
        TreeNode m1 = new TreeNode(1);
        TreeNode m2 = new TreeNode(2, m1, null);
        TreeNode m4 = new TreeNode(4);
        TreeNode m3 = new TreeNode(3, m2, m4);
        TreeNode m6 = new TreeNode(6);
        TreeNode m5 = new TreeNode(5, m3, m6);

        System.out.println("Test 2: " + solution.kthSmallest(m5, 3)); // 3
    }
}
