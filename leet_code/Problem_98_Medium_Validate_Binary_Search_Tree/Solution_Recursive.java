package leet_code.Problem_98_Medium_Validate_Binary_Search_Tree;

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

public class Solution_Recursive {

    /**
     * Determines if a binary tree is a valid Binary Search Tree (BST).
     * Uses a recursive approach with lower and upper bounds.
     * Xác định xem một cây nhị phân có phải là Cây Tìm Kiếm Nhị Phân (BST) hợp lệ
     * không.
     * Sử dụng phương pháp đệ quy với các ranh giới dưới và trên.
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        // An empty tree is a valid BST
        // Một cây trống là một BST hợp lệ
        if (node == null) {
            return true;
        }

        // The current node's value must be within the bounds
        // Giá trị của nút hiện tại phải nằm trong các ranh giới
        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        // Recursively validate left and right subtrees
        // Xác thực đệ quy các cây con bên trái và bên phải
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [2,1,3]
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Test Case 1: " + solution.isValidBST(t1));
        // Expected: true

        // Test Case 2: [5,1,4,null,null,3,6]
        TreeNode t2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Test Case 2: " + solution.isValidBST(t2));
        // Expected: false
    }
}
