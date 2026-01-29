package leetcode.P501_FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private int currentCount = 0;
    private int maxCount = 0;
    private Integer prev = null;
    private List<Integer> modes = new ArrayList<>();

    /**
     * Problem 501: Find Mode in Binary Search Tree
     * Approach: In-order traversal to utilize BST sorted property
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) for recursion
     */
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++)
            result[i] = modes.get(i);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);

        // Handle current value
        if (prev != null && node.val == prev) {
            currentCount++;
        } else {
            currentCount = 1;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,null,2,2]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] res = sol.findMode(root);
        System.out.println("Result: " + java.util.Arrays.toString(res));
    }
}
