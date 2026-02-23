package leet_code.Problem_623_Medium_Add_One_Row_to_Tree;

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
     * Adds a row of nodes with value val at the given depth.
     * Strategy: Recursive DFS to reach depth - 1.
     * Time: O(N), Space: O(H).
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Special case: Adding at the root level
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        insert(root, val, depth, 1);
        return root;
    }

    private void insert(TreeNode node, int val, int depth, int currDepth) {
        if (node == null)
            return;

        // If we am at the level directly above the target depth
        if (currDepth == depth - 1) {
            // Save original subtrees
            TreeNode t = node.left;
            // Create new nodes and reconnect
            node.left = new TreeNode(val);
            node.left.left = t;

            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            // Recurse down the tree
            insert(node.left, val, depth, currDepth + 1);
            insert(node.right, val, depth, currDepth + 1);
        }
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)),
                new TreeNode(6, new TreeNode(5), null));
        TreeNode result = solution.addOneRow(root, 1, 2);
        System.out.println("Modified Root Val: " + result.val);
        System.out.println("Modified Left Val: " + result.left.val); // Should be 1
    }
}
