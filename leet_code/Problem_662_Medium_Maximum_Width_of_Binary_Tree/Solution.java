package leet_code.Problem_662_Medium_Maximum_Width_of_Binary_Tree;

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

public class Solution {

    /**
     * Calculates the maximum width of a binary tree.
     * Strategy: BFS with positional indexing (left child = 2i, right child = 2i +
     * 1).
     * Time: O(N), Space: O(W).
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        // Queue stores pairs of (node, index)
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int firstIndex = 0, lastIndex = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int index = current.index;

                // Record first and last index of the current level
                if (i == 0)
                    firstIndex = index;
                if (i == size - 1)
                    lastIndex = index;

                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, 2 * index));
                }
                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, 2 * index + 1));
                }
            }

            // Calculate width and update max
            maxWidth = Math.max(maxWidth, lastIndex - firstIndex + 1);
        }

        return maxWidth;
    }

    private static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(9)));
        System.out.println("Max Width: " + sol.widthOfBinaryTree(root)); // 4
    }
}
