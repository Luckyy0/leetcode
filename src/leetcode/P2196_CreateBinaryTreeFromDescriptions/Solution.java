package leetcode.P2196_CreateBinaryTreeFromDescriptions;

import leetcode.common.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int pVal = d[0];
            int cVal = d[1];
            boolean isLeft = d[2] == 1;

            TreeNode parent = nodes.computeIfAbsent(pVal, k -> new TreeNode(k));
            TreeNode child = nodes.computeIfAbsent(cVal, k -> new TreeNode(k));

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(cVal);
        }

        for (int val : nodes.keySet()) {
            if (!children.contains(val)) {
                return nodes.get(val); // Root found
            }
        }

        return null;
    }
}
