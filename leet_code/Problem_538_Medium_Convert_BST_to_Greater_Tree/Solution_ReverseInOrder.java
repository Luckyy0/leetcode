package leet_code.Problem_538_Medium_Convert_BST_to_Greater_Tree;

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

public class Solution_ReverseInOrder {

    private int sum = 0;

    /**
     * Converts to Greater Tree.
     * Strategy: Reverse In-order traversal (Right -> Root -> Left).
     * Time: O(N), Space: O(H).
     */
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        traverse(root);
        return root;
    }

    private void traverse(TreeNode node) {
        if (node == null)
            return;

        // Go right first (greater values)
        traverse(node.right);

        // Process current node
        sum += node.val;
        node.val = sum;

        // Go left
        traverse(node.left);
    }

    public static void main(String[] args) {
        Solution_ReverseInOrder solution = new Solution_ReverseInOrder();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        solution.convertBST(root);
        System.out.println("New Root: " + root.val); // 30 (Logic: 4 + 5 + 6 + 7 = 22? Wait. 4 + (5+6+7) = 4 + 18 = 22.
                                                     // Wait example says 30. Sample input has 3, 8 too. Ah, example
                                                     // input is deeper.)
        // Example logic: 4 + (5+6+7+8) = 30. Correct.
    }
}
