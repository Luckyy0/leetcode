package leetcode.P099_RecoverBinarySearchTree;

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

    private TreeNode first = null; // First wrong node
    private TreeNode second = null; // Second wrong node
    private TreeNode prev = null; // Previous node in inorder traversal

    /**
     * Problem 99: Recover Binary Search Tree
     * Approach: Inorder Traversal to find inversions
     * 
     * Theoretical Basis:
     * - Inorder traversal of valid BST produces strictly increasing sequence
     * - Two swapped nodes create 1 or 2 inversions in this sequence
     * - First inversion: first = prev (larger), second = curr (smaller)
     * - Second inversion (if exists): update second = curr
     * - Finally swap values of first and second
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) for recursion stack
     */
    public void recoverTree(TreeNode root) {
        // Reset class fields
        first = second = prev = null;

        // Find the two swapped nodes
        inorder(root);

        // Swap values to recover
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        // Left subtree
        inorder(node.left);

        // Process current node: check for inversion
        if (prev != null && prev.val > node.val) {
            // Found an inversion
            if (first == null) {
                // First inversion: first is the larger (prev), second is the smaller (node)
                first = prev;
                second = node;
            } else {
                // Second inversion: update second to current smaller node
                second = node;
            }
        }
        prev = node;

        // Right subtree
        inorder(node.right);
    }

    // Helper: print inorder
    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: [1,3,null,null,2] -> [3,1,null,null,2]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        System.out.print("Before: ");
        printInorder(root1);
        System.out.println();
        solution.recoverTree(root1);
        System.out.print("After:  ");
        printInorder(root1);
        System.out.println();
        System.out.println("Expected inorder: 1 2 3");
        System.out.println("-----------------");

        // Test 2: [3,1,4,null,null,2] -> [2,1,4,null,null,3]
        Solution solution2 = new Solution();
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(2);
        System.out.print("Before: ");
        printInorder(root2);
        System.out.println();
        solution2.recoverTree(root2);
        System.out.print("After:  ");
        printInorder(root2);
        System.out.println();
        System.out.println("Expected inorder: 1 2 3 4");
        System.out.println("-----------------");
    }
}
