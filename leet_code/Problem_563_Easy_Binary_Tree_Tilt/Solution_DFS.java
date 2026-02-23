package leet_code.Problem_563_Easy_Binary_Tree_Tilt;

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

public class Solution_DFS {

    private int totalTilt = 0;

    /**
     * Finds total tilt of the binary tree.
     * Strategy: Post-order DFS to calculate subtree sums and tilt.
     * Time: O(N), Space: O(H).
     */
    public int findTilt(TreeNode root) {
        totalTilt = 0;
        sumNodes(root);
        return totalTilt;
    }

    private int sumNodes(TreeNode node) {
        if (node == null)
            return 0;

        int leftSum = sumNodes(node.left);
        int rightSum = sumNodes(node.right);

        // Tilt is absolute difference of subtree sums
        totalTilt += Math.abs(leftSum - rightSum);

        // Return sum including current node value
        return leftSum + rightSum + node.val;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("Result Tilt: " + solution.findTilt(root)); // 15
    }
}
