package leet_code.Problem_513_Medium_Find_Bottom_Left_Tree_Value;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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
     * Finds bottom left value.
     * Strategy: BFS Right-to-Left. The last node visited is the answer.
     * Time: O(N), Space: O(W).
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = root.val;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result = node.val;

            // Add right first, then left
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println("Result: " + solution.findBottomLeftValue(root)); // 1
    }
}
