package leet_code.Problem_814_Medium_Binary_Tree_Pruning;

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
     * Prunes subtrees that do not contain a 1.
     * Strategy: Post-order recursive traversal (bottom-up).
     * Time: O(N), Space: O(H).
     */
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        // Recurse down to the leaves first
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // Check if the current node needs to be pruned.
        // A node is pruned if it's a leaf after child pruning AND its own value is 0.
        if (root.val == 0 && root.left == null && root.right == null) {
            return null;
        }

        return root;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1: [1,null,0,0,1]
        TreeNode root1 = new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)));
        TreeNode result1 = sol.pruneTree(root1);
        System.out.println("Result 1: Root still exists? " + (result1 != null));
        // Manual verification would involve printing the tree structure.
    }
}
