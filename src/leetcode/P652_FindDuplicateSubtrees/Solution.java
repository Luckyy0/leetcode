package leetcode.P652_FindDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class Solution {
    private Map<String, Integer> count = new HashMap<>();
    private List<TreeNode> result = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return result;
    }

    private String serialize(TreeNode node) {
        if (node == null)
            return "#";

        String serial = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);

        if (count.get(serial) == 2) {
            result.add(node);
        }

        return serial;
    }
}
