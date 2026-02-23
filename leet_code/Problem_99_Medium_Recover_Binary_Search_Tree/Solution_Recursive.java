package leet_code.Problem_99_Medium_Recover_Binary_Search_Tree;

import java.util.*;

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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    /**
     * Recovers a BST where two nodes were swapped.
     * Uses recursive inorder traversal to find violations.
     * Khôi phục một cây BST nơi có hai nút bị tráo đổi.
     * Sử dụng duyệt theo thứ tự giữa đệ quy để tìm các điểm vi phạm.
     */
    public void recoverTree(TreeNode root) {
        // Reset pointers
        first = null;
        second = null;
        prev = null;

        traverse(root);

        // Swap values back
        // Tráo đổi lại các giá trị
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;

        traverse(root.left);

        // Check for violation
        // Kiểm tra vi phạm
        if (prev != null && prev.val > root.val) {
            // Found first violation
            // Tìm thấy vi phạm đầu tiên
            if (first == null) {
                first = prev;
            }
            // Always update second, in case nodes are not adjacent
            // Luôn cập nhật second, đề phòng trường hợp các nút không liền kề
            second = root;
        }

        prev = root;

        traverse(root.right);
    }

    public static void main(String[] args) {
        Solution_Recursive solution = new Solution_Recursive();

        // Test Case 1: [1,3,null,null,2]
        TreeNode t1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        solution.recoverTree(t1);
        System.out.println("Test Case 1: Root value should be 3, left child value should be 1.");
        System.out.println("Result root: " + t1.val + ", left: " + t1.left.val);
        // Expected: 3, 1

        // Test Case 2: [3,1,4,null,null,2]
        TreeNode t2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        solution.recoverTree(t2);
        System.out.println("Test Case 2: Root value should be 2, left child 1, right child 4 (with child 3).");
        System.out.println("Result root: " + t2.val + ", right left: " + t2.right.left.val);
        // Expected: 2, 3
    }
}
