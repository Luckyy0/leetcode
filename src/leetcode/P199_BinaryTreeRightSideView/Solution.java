package leetcode.P199_BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
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
     * Problem 199: Binary Tree Right Side View
     * Approach: BFS (Level Order Traversal)
     * 
     * Theoretical Basis:
     * - Visit the tree level by level.
     * - The last node in each level queue is the one visible from the right.
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(W) where W is max width.
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                // If it's the last node in the current level, add to result
                if (i == levelSize - 1) {
                    result.add(current.val);
                }

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: [1,2,3,null,5,null,4]
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2, null, n5);
        TreeNode n3 = new TreeNode(3, null, n4);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println("Test 1: " + solution.rightSideView(n1)); // [1, 3, 4]

        // Example 2: [1, null, 3]
        TreeNode m3 = new TreeNode(3);
        TreeNode m1 = new TreeNode(1, null, m3);
        System.out.println("Test 2: " + solution.rightSideView(m1)); // [1, 3]
    }
}
