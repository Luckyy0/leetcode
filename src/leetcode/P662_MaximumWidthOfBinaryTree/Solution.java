package leetcode.P662_MaximumWidthOfBinaryTree;

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

class Pair {
    TreeNode node;
    int index;

    Pair(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int leftMostIdx = queue.peek().index;
            int currentIdx = 0;

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                TreeNode node = p.node;
                currentIdx = p.index;

                if (node.left != null) {
                    queue.offer(new Pair(node.left, 2 * currentIdx));
                }
                if (node.right != null) {
                    queue.offer(new Pair(node.right, 2 * currentIdx + 1));
                }
            }
            // Update max width: rightmost index - leftmost index + 1
            // Cập nhật độ rộng tối đa: chỉ số bên phải nhất - chỉ số bên trái nhất + 1
            maxWidth = Math.max(maxWidth, currentIdx - leftMostIdx + 1);
        }

        return maxWidth;
    }
}
