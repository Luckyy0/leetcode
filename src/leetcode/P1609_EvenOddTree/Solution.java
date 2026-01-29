package leetcode.P1609_EvenOddTree;

import java.util.LinkedList;
import java.util.Queue;

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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Integer prevVal = null;

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int val = cur.val;

                if (level % 2 == 0) {
                    // Even Level: Odd values, Increasing
                    if (val % 2 == 0)
                        return false;
                    if (prevVal != null && val <= prevVal)
                        return false;
                } else {
                    // Odd Level: Even values, Decreasing
                    if (val % 2 != 0)
                        return false;
                    if (prevVal != null && val >= prevVal)
                        return false;
                }

                prevVal = val;

                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            level++;
        }

        return true;
    }
}
