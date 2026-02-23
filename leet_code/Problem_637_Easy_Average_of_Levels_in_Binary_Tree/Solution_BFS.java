package leet_code.Problem_637_Easy_Average_of_Levels_in_Binary_Tree;

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

public class Solution_BFS {

    /**
     * Calculates the average value of nodes at each level.
     * Strategy: Level-order traversal (BFS) using a Queue.
     * Time: O(N), Space: O(M).
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Calculate and add average for the current level
            result.add(levelSum / levelSize);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS sol = new Solution_BFS();
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Averages: " + sol.averageOfLevels(root)); // [3.0, 14.5, 11.0]
    }
}
