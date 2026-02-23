package leet_code.Problem_543_Easy_Diameter_of_Binary_Tree;

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

    private int maxDiameter = 0;

    /**
     * Finds diameter of binary tree.
     * Strategy: Post-order DFS to get depths. Update max diameter at each node.
     * Time: O(N), Space: O(H).
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        getDepth(root);
        return maxDiameter;
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);

        // Path through current node is Left + Right
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // Return depth of this node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        Solution_DFS solution = new Solution_DFS();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Result: " + solution.diameterOfBinaryTree(root)); // 3
    }
}
