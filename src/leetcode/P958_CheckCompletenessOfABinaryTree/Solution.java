package leetcode.P958_CheckCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                seenNull = true;
            } else {
                if (seenNull)
                    return false;
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}
