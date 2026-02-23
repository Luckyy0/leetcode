package leet_code.Problem_145_Easy_Binary_Tree_Postorder_Traversal;

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

public class Solution_Iterative_Trick {

    /**
     * Performs postorder traversal of a binary tree iteratively.
     * Order: Left -> Right -> Root.
     * Trick: Use a modified Preorder (Root -> Right -> Left) and then reverse the
     * result.
     * 
     * Thực hiện duyệt cây nhị phân theo thứ tự sau bằng vòng lặp.
     * Thứ tự: Trái -> Phải -> Gốc.
     * Mẹo: Sử dụng Thứ tự trước biến đổi (Gốc -> Phải -> Trái) sau đó đảo ngược kết
     * quả.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Modified Preorder: Root -> Right -> Left
        // Thứ tự trước biến đổi: Gốc -> Phải -> Trái
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);

            // Push left child first so that right child is popped first
            // Đẩy con trái trước để con phải được lấy ra trước
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        // Reverse the entire result list to get: Left -> Right -> Root
        // Đảo ngược toàn bộ danh sách để có: Trái -> Phải -> Gốc
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        Solution_Iterative_Trick solution = new Solution_Iterative_Trick();

        // Test Case 1: [1, null, 2, 3] -> [3, 2, 1]
        // 1
        // \
        // 2
        // /
        // 3
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Test Case 1: " + solution.postorderTraversal(root));
        // Expected: [3, 2, 1]
    }
}
