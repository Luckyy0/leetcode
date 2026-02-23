package leet_code.Problem_606_Easy_Construct_String_from_Binary_Tree;

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

public class Solution_Recursion {

    /**
     * Constructs a string from a binary tree in preorder traversal.
     * Strategy: Recursive preorder with specific omission rules for parentheses.
     * Time: O(N), Space: O(H).
     */
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }

    private void build(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.val);

        // Handle Left Child
        if (node.left != null || node.right != null) {
            sb.append("(");
            build(node.left, sb);
            sb.append(")");
        }

        // Handle Right Child
        if (node.right != null) {
            sb.append("(");
            build(node.right, sb);
            sb.append(")");
        }
    }

    public static void main(String[] args) {
        Solution_Recursion solution = new Solution_Recursion();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3));
        System.out.println("Tree to String: " + solution.tree2str(root)); // 1(2(4))(3)
    }
}
