package leet_code.Problem_230_Medium_Kth_Smallest_Element_In_A_BST;

import java.util.Stack;

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

public class Solution_InOrder {

    /**
     * Finds the kth smallest element in a BST.
     * Uses Iterative In-Order Traversal.
     * Time: O(H + K), Space: O(H).
     * 
     * Tìm phần tử nhỏ thứ k trong BST.
     * Sử dụng Duyệt trung thứ tự lặp.
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Go as left as possible
            // Đi sang trái hết mức có thể
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop the top node (smallest available)
            // Lấy nút trên cùng (nhỏ nhất hiện có)
            curr = stack.pop();

            // Decrement k
            // Giảm k
            k--;
            if (k == 0) {
                return curr.val;
            }

            // Move to right subtree
            // Di chuyển sang cây con phải
            curr = curr.right;
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        Solution_InOrder solution = new Solution_InOrder();

        // Test Case 1: [3,1,4,null,2], k=1 -> 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println("Kth (1): " + solution.kthSmallest(root, 1));

        // Test Case 2: [5,3,6,2,4,null,null,1], k=3 -> 3
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(1);
        System.out.println("Kth (3): " + solution.kthSmallest(root2, 3));
    }
}
