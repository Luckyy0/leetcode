package leetcode.P173_BinarySearchTreeIterator;

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
     * Problem 173: Binary Search Tree Iterator
     * Approach: Controlled Stack Simulation (Simulating In-order Traversal)
     * 
     * Theoretical Basis:
     * - Use a stack to store the "left-most" path.
     * - hasNext() is O(1).
     * - next() is average O(1).
     * - Space is O(H).
     */
    static class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftNodes(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                pushLeftNodes(node.right);
            }
            return node.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeftNodes(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    public static void main(String[] args) {
        // [7, 3, 15, null, null, 9, 20]
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15, n9, n20);
        TreeNode n3 = new TreeNode(3);
        TreeNode n7 = new TreeNode(7, n3, n15);

        BSTIterator bSTIterator = new BSTIterator(n7);
        System.out.println("next: " + bSTIterator.next()); // 3
        System.out.println("next: " + bSTIterator.next()); // 7
        System.out.println("hasNext: " + bSTIterator.hasNext()); // true
        System.out.println("next: " + bSTIterator.next()); // 9
        System.out.println("hasNext: " + bSTIterator.hasNext()); // true
        System.out.println("next: " + bSTIterator.next()); // 15
        System.out.println("hasNext: " + bSTIterator.hasNext()); // true
        System.out.println("next: " + bSTIterator.next()); // 20
        System.out.println("hasNext: " + bSTIterator.hasNext()); // false
    }
}
