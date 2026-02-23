package leet_code.Problem_671_Easy_Second_Minimum_Node_In_a_Binary_Tree;

/**
 * Definition for a binary tree node.
 */
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

public class Solution {

    /**
     * Finds the second minimum value in a special binary tree where Parent =
     * min(Children).
     * Strategy: Pruned DFS to find the smallest value strictly greater than
     * root.val.
     * Time: O(N), Space: O(H).
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null)
            return -1;
        return find(root, root.val);
    }

    private int find(TreeNode node, int minVal) {
        // Base case: if node is null, no candidate found
        if (node == null)
            return -1;

        // If current node's value is already greater than global minimum, it's a
        // candidate
        // We don't need to look at its children because they will be >= this node's
        // value.
        if (node.val > minVal)
            return node.val;

        // If current node's value is equal to global minimum, we must look at both
        // subtrees
        int left = find(node.left, minVal);
        int right = find(node.right, minVal);

        // If both subtrees have valid candidates (> minVal), return the smaller one
        if (left != -1 && right != -1) {
            return Math.min(left, right);
        }

        // Otherwise, return whichever one is valid (or -1 if neither is)
        return left != -1 ? left : right;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        TreeNode root1 = new TreeNode(2,
                new TreeNode(2),
                new TreeNode(5, new TreeNode(5), new TreeNode(7)));
        System.out.println("Second Min Example 1: " + sol.findSecondMinimumValue(root1)); // 5

        // Example 2
        TreeNode root2 = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println("Second Min Example 2: " + sol.findSecondMinimumValue(root2)); // -1
    }
}
