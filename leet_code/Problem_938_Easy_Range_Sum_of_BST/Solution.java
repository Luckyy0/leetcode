package leet_code.Problem_938_Easy_Range_Sum_of_BST;

import java.util.*;

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
 * Problem 938: Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class Solution {

    /**
     * Calculates the sum of values within the range [low, high].
     * Strategy: Recursive DFS with Pruning.
     * 
     * @param root The root of the BST.
     * @param low  The lower bound.
     * @param high The upper bound.
     * @return Sum of values in range.
     * 
     *         Tóm tắt chiến lược:
     *         1. Duyệt DFS đệ quy.
     *         2. Nếu giá trị nút hiện tại < low: Tất cả các nút bên trái cũng sẽ
     *         nhỏ hơn low (vô ích).
     *         -> Chỉ cần duyệt tiếp bên phải.
     *         3. Nếu giá trị nút hiện tại > high: Tất cả các nút bên phải cũng sẽ
     *         lớn hơn high (vô ích).
     *         -> Chỉ cần duyệt tiếp bên trái.
     *         4. Nếu giá trị nút hiện tại nằm trong khoảng [low, high]:
     *         -> Cộng giá trị nút vào tổng.
     *         -> Duyệt tiếp cả bên trái và bên phải (vì có thể còn các giá trị hợp
     *         lệ ở cả hai nhánh).
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        // If current value is less than low, no need to explore left subtree
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // If current value is greater than high, no need to explore right subtree
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Current value is in range, add it and explore both children
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Solution sol = new Solution();
        System.out.println("Result: " + sol.rangeSumBST(root, 7, 15)); // 32 (7 + 10 + 15)
    }
}
