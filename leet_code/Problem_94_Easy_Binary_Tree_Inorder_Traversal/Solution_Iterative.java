package leet_code.Problem_94_Easy_Binary_Tree_Inorder_Traversal;

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
     * Performs inorder traversal of a binary tree.
     * Uses an iterative approach with a stack.
     * Thực hiện duyệt cây nhị phân theo thứ tự giữa.
     * Sử dụng phương pháp lặp với một ngăn xếp.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the left most node of the current node
            // Đi tới nút ngoài cùng bên trái của nút hiện tại
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the node and visit it
            // Lấy nút ra khỏi ngăn xếp và truy cập nó
            curr = stack.pop();
            res.add(curr.val);

            // Move to the right child
            // Chuyển sang nút con bên phải
            curr = curr.right;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_Iterative solution = new Solution_Iterative();

        // Test Case 1: [1,null,2,3]
        TreeNode t1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Test Case 1: " + solution.inorderTraversal(t1));
        // Expected: [1, 3, 2]

        // Test Case 2: []
        System.out.println("Test Case 2: " + solution.inorderTraversal(null));
        // Expected: []

        // Test Case 3: [1]
        System.out.println("Test Case 3: " + solution.inorderTraversal(new TreeNode(1)));
        // Expected: [1]
    }
}
