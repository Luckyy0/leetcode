package leet_code.Problem_545_Medium_Boundary_of_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
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

public class Solution_Modular {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        result.add(root.val);
        // If root is leaf, return immediately
        if (isLeaf(root))
            return result;

        // Add left boundary
        addLeftBoundary(root.left, result);

        // Add leaves
        addLeaves(root, result);

        // Add right boundary
        addRightBoundary(root.right, result);

        return result;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) {
                result.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        List<Integer> temp = new ArrayList<>();
        while (node != null) {
            if (!isLeaf(node)) {
                temp.add(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        // Add in reverse
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null)
            return;
        if (isLeaf(node)) {
            // Usually, root is added at start. We check isLeaf(root) in main function.
            // If root is leaf, main function returns.
            // If internal call, add leaf.
            // Wait, if node is root and not leaf, we recurse.
            // If we are at a leaf that is NOT root, add it.
            // But main function adds root.
            // When calling addLeaves(root), if root is not leaf, it recurses.
            // If child is leaf, it adds.
            // So if root is not leaf, we won't double add root here because isLeaf(root) is
            // false.
            result.add(node.val);
        } else {
            addLeaves(node.left, result);
            addLeaves(node.right, result);
        }
    }

    // Correction for addLeaves:
    // The problem is that addLeaves(root) traverses everything.
    // If root.left is a leaf, it is added.
    // Is it possible that root.left is also part of Left Boundary?
    // Left Boundary logic: Add if NOT leaf.
    // Leaves logic: Add if leaf.
    // So no intersection between Left/Right Boundary logic and Leaves logic.
    // However, we MUST NOT add root in addLeaves if root is leaf?
    // The main function handles root.
    // If root is not leaf, addLeaves(root) calls children.
    // So safe.
    // One edge case: root.left is defined as leaf in isLeaf.
    // addLeftBoundary iterates root.left.
    // If root.left is leaf, loop condition `!isLeaf` prevents adding.
    // addLeaves will add root.left.
    // Correct.

    public static void main(String[] args) {
        Solution_Modular solution = new Solution_Modular();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        System.out.println("Result: " + solution.boundaryOfBinaryTree(root)); // [1, 3, 4, 2]
    }
}
