package leet_code.Problem_872_Easy_Leaf_Similar_Trees;

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
 * Problem 872: Leaf-Similar Trees
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class Solution {

    /**
     * Determines if two binary trees are leaf-similar.
     * Strategy: Traverse both trees using DFS to collect leaf nodes in order.
     * 
     * @param root1 Root of the first tree.
     * @param root2 Root of the second tree.
     * @return True if leaf sequences match.
     * 
     *         Tóm tắt chiến lược:
     *         Chúng ta sử dụng DFS để duyệt qua từng cây. Khi gặp một nút lá
     *         (không có con trái và con phải), ta sẽ thêm giá trị của nó vào một
     *         danh sách.
     *         Sau khi thu thập xong lá của cả hai cây, ta so sánh hai danh sách
     *         này.
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    /**
     * Helper method to collect leaf values in left-to-right order.
     */
    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }

        // If it's a leaf node
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
            return;
        }

        // Traverse left then right to maintain order
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}
