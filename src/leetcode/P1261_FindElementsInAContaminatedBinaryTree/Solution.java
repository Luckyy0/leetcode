package leetcode.P1261_FindElementsInAContaminatedBinaryTree;

import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class FindElements {
    Set<Integer> values;

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        if (root != null) {
            root.val = 0;
            recover(root);
        }
    }

    private void recover(TreeNode node) {
        values.add(node.val);

        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            recover(node.left);
        }

        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            recover(node.right);
        }
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
