package leet_code.Problem_897_Easy_Increasing_Order_Search_Tree;

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
 * Problem 897: Increasing Order Search Tree
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class Solution {

    // Keeps track of the tail of the new linked list
    TreeNode curr;

    /**
     * Rearranges the tree into an increasing order search tree.
     * Strategy: In-order Traversal.
     * 
     * @param root Root of the BST.
     * @return New root of the increasing order tree.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt cây theo thứ tự giữa (In-order: Trái -> Gốc -> Phải).
     *         Điều này đảm bảo chúng ta thăm các nút theo thứ tự giá trị tăng dần.
     *         2. Tạo một nút giả (dummy node) 'ans' để làm đầu của cây mới.
     *         3. Sử dụng biến 'curr' để trỏ đến nút cuối cùng vừa được thêm vào cây
     *         mới.
     *         4. Trong quá trình duyệt:
     *         - Đặt con trái của nút hiện tại thành null (để tránh chu trình/cấu
     *         trúc sai).
     *         - Gán con phải của 'curr' là nút hiện tại.
     *         - Cập nhật 'curr' thành nút hiện tại.
     *         5. Trả về con phải của nút giả (ans.right).
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        curr = ans;
        inorder(root);
        return ans.right;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        // Traverse left subtree
        inorder(node.left);

        // Process current node
        node.left = null; // Important: Clear the left child
        curr.right = node; // Link the previous node to current
        curr = node; // Move curr forward

        // Traverse right subtree
        inorder(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode res = sol.increasingBST(root);

        // Print the right-skewed tree
        TreeNode current = res;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.right;
        }
        System.out.println("null");
        // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> null
    }
}
