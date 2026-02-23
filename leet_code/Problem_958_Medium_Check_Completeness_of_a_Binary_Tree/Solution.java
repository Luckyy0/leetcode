package leet_code.Problem_958_Medium_Check_Completeness_of_a_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
 * Problem 958: Check Completeness of a Binary Tree
 * https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 */
public class Solution {

    /**
     * Checks if the binary tree is complete.
     * Strategy: BFS with Null Tracking.
     * 
     * @param root Root of the binary tree.
     * @return true if complete, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Một cây nhị phân hoàn chỉnh có tính chất: Khi duyệt theo chiều
     *         rộng (BFS - Level Order),
     *         không bao giờ xuất hiện một nút `null` TRƯỚC một nút KHÔNG `null`.
     *         Tất cả các nút phải được dồn về phía bên trái và các tầng trên phải
     *         đầy đủ.
     *         2. Sử dụng Queue để duyệt BFS.
     *         3. Khi lấy một nút ra khỏi Queue (`poll`), ta kiểm tra:
     *         - Nếu nút đó là `null`: Đánh dấu cờ `seenNull = true`. Điều này có
     *         nghĩa là ta đã gặp một vị trí trống
     *         hoặc đã kết thúc phần cây có giá trị. Từ giờ trở đi, tất cả các nút
     *         lấy ra khỏi Queue PHẢI là `null`.
     *         - Nếu nút đó KHÔNG `null`:
     *         - Nếu cờ `seenNull` đã bật trước đó (`true`), nghĩa là ta đã gặp một
     *         khoảng trống nhưng giờ lại gặp một nút có giá trị.
     *         Điều này vi phạm tính chất cây hoàn chỉnh -> Trả về `false`.
     *         - Nếu chưa gặp `null`, thêm con trái và con phải vào Queue như bình
     *         thường.
     *         4. Nếu duyệt hết Queue mà không vi phạm, trả về `true`.
     */
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean seenNull = false;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                // Once we see a null node, all subsequent nodes must be null
                seenNull = true;
            } else {
                // If we see a non-null node after seeing a null node, it's not complete
                if (seenNull) {
                    return false;
                }
                // Add children to the queue (even if they are null)
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Example 1
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        r1.left.left = new TreeNode(4);
        r1.left.right = new TreeNode(5);
        r1.right.left = new TreeNode(6);

        Solution sol = new Solution();
        System.out.println("Result: " + sol.isCompleteTree(r1)); // true

        // Example 2
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(3);
        r2.left.left = new TreeNode(4);
        r2.left.right = new TreeNode(5);
        r2.right.right = new TreeNode(7); // Gap at right.left -> null

        System.out.println("Result: " + sol.isCompleteTree(r2)); // false
    }
}
