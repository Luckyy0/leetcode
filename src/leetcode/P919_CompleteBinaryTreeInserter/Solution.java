package leetcode.P919_CompleteBinaryTreeInserter;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
        while (!temp.isEmpty()) {
            TreeNode node = temp.poll();
            if (node.left == null || node.right == null) {
                queue.add(node);
            }
            if (node.left != null)
                temp.add(node.left);
            if (node.right != null)
                temp.add(node.right);
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode p = queue.peek();
        if (p.left == null) {
            p.left = node;
        } else {
            p.right = node;
            queue.poll();
        }
        queue.add(node);
        return p.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
