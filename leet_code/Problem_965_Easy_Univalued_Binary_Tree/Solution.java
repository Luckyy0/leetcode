package leet_code.Problem_965_Easy_Univalued_Binary_Tree;

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

/**
 * Problem 965: Univalued Binary Tree
 * https://leetcode.com/problems/univalued-binary-tree/
 */
public class Solution {

    /**
     * Checks if the binary tree is univalued (all nodes have same value).
     * Strategy: Recursive DFS.
     * 
     * @param root Root of the tree.
     * @return true if univalued, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt cây theo chiều sâu (DFS).
     *         2. Tại mỗi nút, so sánh giá trị của nó với con trái và con phải (nếu
     *         tồn tại).
     *         3. Nếu giá trị con khác giá trị cha -> Trả về `false`.
     *         4. Tiếp tục đệ quy kiểm tra cây con trái và cây con phải.
     *         5. Nếu toàn bộ quá trình không phát hiện sai khác -> Trả về `true`.
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Check left child
        if (root.left != null) {
            if (root.left.val != root.val) {
                return false;
            }
        }

        // Check right child
        if (root.right != null) {
            if (root.right.val != root.val) {
                return false;
            }
        }

        // Recursively check children
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(1);
        r1.left.left = new TreeNode(1);
        r1.left.right = new TreeNode(1);
        r1.right.right = new TreeNode(1);

        Solution sol = new Solution();
        System.out.println("Result: " + sol.isUnivalTree(r1)); // true

        // Example 2
        TreeNode r2 = new TreeNode(2);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(2);
        r2.left.left = new TreeNode(5); // Diff
        r2.left.right = new TreeNode(2);

        System.out.println("Result: " + sol.isUnivalTree(r2)); // false
    }
}
