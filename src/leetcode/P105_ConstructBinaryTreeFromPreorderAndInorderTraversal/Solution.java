package leetcode.P105_ConstructBinaryTreeFromPreorderAndInorderTraversal;

import java.util.HashMap;
import java.util.Map;

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

    private Map<Integer, Integer> inorderIndexMap;
    private int[] preorder;

    /**
     * Problem 105: Construct Binary Tree from Preorder and Inorder Traversal
     * Approach: Recursion with HashMap
     * 
     * Theoretical Basis:
     * - Preorder: first element is root of current subtree
     * - Inorder: elements left of root belong to left subtree, elements right
     * belong to right subtree
     * - HashMap allows O(1) lookup of root position in inorder array
     * - Recursively build left and right subtrees using computed ranges
     * 
     * Time Complexity: O(N) - each node processed once with O(1) lookup
     * Space Complexity: O(N) for HashMap + O(H) for recursion stack
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorderIndexMap = new HashMap<>();

        // Build index map for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, 0, inorder.length - 1);
    }

    private TreeNode build(int preIdx, int inStart, int inEnd) {
        // Base case: no elements to construct
        if (inStart > inEnd) {
            return null;
        }

        // Root is first element in current preorder range
        int rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int inIdx = inorderIndexMap.get(rootVal);

        // Calculate left subtree size
        int leftSize = inIdx - inStart;

        // Build left subtree:
        // - Preorder starts at preIdx + 1
        // - Inorder range is [inStart, inIdx - 1]
        root.left = build(preIdx + 1, inStart, inIdx - 1);

        // Build right subtree:
        // - Preorder starts at preIdx + 1 + leftSize (skip root and all left subtree
        // nodes)
        // - Inorder range is [inIdx + 1, inEnd]
        root.right = build(preIdx + 1 + leftSize, inIdx + 1, inEnd);

        return root;
    }

    // Helper: print inorder traversal to verify
    public static void printInorder(TreeNode root) {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // Helper: print preorder traversal to verify
    public static void printPreorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        int[] preorder1 = { 3, 9, 20, 15, 7 };
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        TreeNode root1 = solution.buildTree(preorder1, inorder1);
        System.out.print("Preorder: ");
        printPreorder(root1);
        System.out.println();
        System.out.print("Inorder:  ");
        printInorder(root1);
        System.out.println();
        System.out.println("-----------------");

        // Test 2: Single node
        Solution solution2 = new Solution();
        int[] preorder2 = { -1 };
        int[] inorder2 = { -1 };
        TreeNode root2 = solution2.buildTree(preorder2, inorder2);
        System.out.print("Preorder: ");
        printPreorder(root2);
        System.out.println();
        System.out.println("-----------------");
    }
}
