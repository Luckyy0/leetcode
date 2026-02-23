package leet_code.Problem_110_Easy_Balanced_Binary_Tree;

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

public class Solution_BottomUp {

    /**
     * Checks if a binary tree is height-balanced.
     * Uses an optimized bottom-up DFS approach.
     * Kiểm tra xem một cây nhị phân có cân bằng về chiều cao không.
     * Sử dụng phương pháp DFS từ dưới lên đã được tối ưu hóa.
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    /**
     * Helper function that returns the height of the tree if balanced,
     * or -1 if any subtree is unbalanced.
     * Hàm bổ trợ trả về chiều cao của cây nếu cân bằng,
     * hoặc -1 nếu bất kỳ cây con nào không cân bằng.
     */
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Check left subtree
        // Kiểm tra cây con bên trái
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1)
            return -1;

        // Check right subtree
        // Kiểm tra cây con bên phải
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1)
            return -1;

        // If height difference > 1, current tree is unbalanced
        // Nếu chênh lệch chiều cao > 1, cây hiện tại không cân bằng
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return actual height
        // Trả về chiều cao thực tế
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        Solution_BottomUp solution = new Solution_BottomUp();

        // Test Case 1: [3,9,20,null,null,15,7] (Balanced)
        TreeNode t1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Test Case 1: " + solution.isBalanced(t1));
        // Expected: true

        // Test Case 2: [1,2,2,3,3,null,null,4,4] (Unbalanced)
        TreeNode t2 = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)),
                new TreeNode(2));
        System.out.println("Test Case 2: " + solution.isBalanced(t2));
        // Expected: false

        // Test Case 3: Empty Tree
        System.out.println("Test Case 3: " + solution.isBalanced(null));
        // Expected: true
    }
}
