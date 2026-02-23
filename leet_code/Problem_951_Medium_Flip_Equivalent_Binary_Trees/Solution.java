package leet_code.Problem_951_Medium_Flip_Equivalent_Binary_Trees;

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
 * Problem 951: Flip Equivalent Binary Trees
 * https://leetcode.com/problems/flip-equivalent-binary-trees/
 */
public class Solution {

    /**
     * Determine if root1 is flip equivalent to root2.
     * Strategy: Recursion.
     * 
     * @param root1 Root of the first binary tree.
     * @param root2 Root of the second binary tree.
     * @return true if flip equivalent, false otherwise.
     * 
     *         Tóm tắt chiến lược:
     *         1. Kiểm tra điều kiện cơ sở:
     *         - Nếu cả hai nút cùng là null (hoặc cùng một tham chiếu), trả về
     *         true.
     *         - Nếu một trong hai là null, hoặc giá trị của chúng khác nhau, trả về
     *         false.
     *         2. Đệ quy kiểm tra hai trường hợp có thể xảy ra để hai cây con tương
     *         đương:
     *         - Trường hợp 1 (Không lật): Cây con trái của r1 tương đương với cây
     *         con trái của r2
     *         VÀ cây con phải của r1 tương đương với cây con phải của r2.
     *         - Trường hợp 2 (Lật): Cây con trái của r1 tương đương với cây con
     *         phải của r2
     *         VÀ cây con phải của r1 tương đương với cây con trái của r2.
     *         3. Trả về true nếu một trong hai trường hợp trên thỏa mãn.
     */
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: Both are null
        if (root1 == root2) {
            return true;
        }

        // Base case: One is null or values are different
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // Check if children are flip equivalent
        // Case 1: No flip needed (left matches left, right matches right)
        // Case 2: Flip needed (left matches right, right matches left)
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    public static void main(String[] args) {
        // Construct Example 1
        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);
        r1.right = new TreeNode(3);
        r1.left.left = new TreeNode(4);
        r1.left.right = new TreeNode(5);
        r1.right.left = new TreeNode(6);
        r1.left.right.left = new TreeNode(7);
        r1.left.right.right = new TreeNode(8);

        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(3);
        r2.right = new TreeNode(2);
        r2.left.right = new TreeNode(6);
        r2.right.left = new TreeNode(4);
        r2.right.right = new TreeNode(5);
        r2.right.right.left = new TreeNode(8);
        r2.right.right.right = new TreeNode(7);

        Solution sol = new Solution();
        System.out.println("Result: " + sol.flipEquiv(r1, r2)); // true
    }
}
