package leetcode.P106_ConstructBinaryTreeFromInorderAndPostorderTraversal;

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
    private int[] postorder;
    private int postIdx;

    /**
     * Problem 106: Construct Binary Tree from Inorder and Postorder Traversal
     * Approach: Recursion with HashMap and Index Pointer
     * 
     * Theoretical Basis:
     * - Postorder: last element is root of current subtree
     * - Inorder: elements left of root belong to left subtree
     * - Key difference from Problem 105: we consume postorder from END
     * - Therefore we must build RIGHT subtree FIRST, then left
     * 
     * Time Complexity: O(N) - each node processed once with O(1) lookup
     * Space Complexity: O(N) for HashMap + O(H) for recursion stack
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.postIdx = postorder.length - 1;
        this.inorderIndexMap = new HashMap<>();

        // Build index map for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(0, inorder.length - 1);
    }

    private TreeNode build(int inStart, int inEnd) {
        // Base case: no elements to construct
        if (inStart > inEnd) {
            return null;
        }

        // Root is LAST element in current postorder range (consume from end)
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        // Find root position in inorder
        int inIdx = inorderIndexMap.get(rootVal);

        // IMPORTANT: Build RIGHT subtree FIRST
        // Because when consuming postorder backwards: Root -> Right -> Left
        root.right = build(inIdx + 1, inEnd);
        root.left = build(inStart, inIdx - 1);

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

    // Helper: print postorder traversal to verify
    public static void printPostorder(TreeNode root) {
        if (root == null)
            return;
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        int[] inorder1 = { 9, 3, 15, 20, 7 };
        int[] postorder1 = { 9, 15, 7, 20, 3 };
        TreeNode root1 = solution.buildTree(inorder1, postorder1);
        System.out.print("Inorder:   ");
        printInorder(root1);
        System.out.println();
        System.out.print("Postorder: ");
        printPostorder(root1);
        System.out.println();
        System.out.println("-----------------");

        // Test 2: Single node
        Solution solution2 = new Solution();
        int[] inorder2 = { -1 };
        int[] postorder2 = { -1 };
        TreeNode root2 = solution2.buildTree(inorder2, postorder2);
        System.out.print("Inorder: ");
        printInorder(root2);
        System.out.println();
        System.out.println("-----------------");
    }
}
