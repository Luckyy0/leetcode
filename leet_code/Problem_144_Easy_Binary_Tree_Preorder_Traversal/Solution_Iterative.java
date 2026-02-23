package leet_code.Problem_144_Easy_Binary_Tree_Preorder_Traversal;

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

public class Solution_Iterative {

    /**
     * Performs preorder traversal of a binary tree iteratively.
     * Order: Root -> Left -> Right.
     * Use a Stack to simulate recursion.
     * 
     * Thực hiện duyệt cây nhị phân theo thứ tự trước bằng vòng lặp.
     * Thứ tự: Gốc -> Trái -> Phải.
     * Sử dụng Stack để mô phỏng đệ quy.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            // Push right child first so that left child is processed first (FILO)
            // Đẩy nút con phải trước để nút con trái được xử lý trước (Vào trước ra sau)
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1, null, 2, 3]
        // 1
        // \
        // 2
        // /
        // 3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Test Case 1: " + solution.preorderTraversal(root));
        // Expected: [1, 2, 3]
    }
}
