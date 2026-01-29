package leetcode.P513_FindBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    /**
     * Problem 513: Find Bottom Left Tree Value
     * Approach: Level-order (BFS) Right-to-Left
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(W)
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();

            // To find left-most, process Right then Left
            if (node.right != null)
                queue.offer(node.right);
            if (node.left != null)
                queue.offer(node.left);
        }

        return node.val;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [2,1,3] -> 1
        TreeNode r1 = new TreeNode(2);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(3);
        System.out.println("Result 1: " + sol.findBottomLeftValue(r1) + " (Expected: 1)");

        // [1,2,3,4,null,5,6,null,null,7] -> 7
        TreeNode r2 = new TreeNode(1);
        r2.left = new TreeNode(2);
        r2.right = new TreeNode(3);
        r2.left.left = new TreeNode(4);
        r2.right.left = new TreeNode(5);
        r2.right.right = new TreeNode(6);
        r2.right.left.left = new TreeNode(7);
        System.out.println("Result 2: " + sol.findBottomLeftValue(r2) + " (Expected: 7)");
    }
}
