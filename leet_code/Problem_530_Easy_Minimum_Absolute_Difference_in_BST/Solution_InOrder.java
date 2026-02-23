package leet_code.Problem_530_Easy_Minimum_Absolute_Difference_in_BST;

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

public class Solution_InOrder {

    private Integer prev;
    private int minDiff;

    /**
     * Finds minimum absolute difference.
     * Strategy: In-order traversal. Compare current with previous.
     * Time: O(N), Space: O(H).
     */
    public int getMinimumDifference(TreeNode root) {
        prev = null;
        minDiff = Integer.MAX_VALUE;
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;

        inOrder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }
        prev = node.val;

        inOrder(node.right);
    }

    public static void main(String[] args) {
        Solution_InOrder solution = new Solution_InOrder();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println("Result: " + solution.getMinimumDifference(root)); // 1
    }
}
