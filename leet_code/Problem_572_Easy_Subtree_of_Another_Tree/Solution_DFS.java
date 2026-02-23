package leet_code.Problem_572_Easy_Subtree_of_Another_Tree;

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

public class Solution_DFS {

    /**
     * Checks if subRoot is a subtree of root.
     * Strategy: Traversal with recursive equality check.
     * Time: O(M * N), Space: O(H).
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return false;

        // If current trees match, or if subRoot is in left or right subtrees
        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Helper to check if two trees are identical in structure and values.
     */
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;

        return s.val == t.val
                && isSameTree(s.left, t.left)
                && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();

        // Root: [3,4,5,1,2]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // SubRoot: [4,1,2]
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println("Is Subtree: " + solution.isSubtree(root, subRoot)); // true
    }
}
