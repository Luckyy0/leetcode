package leet_code.Problem_652_Medium_Find_Duplicate_Subtrees;

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

public class Solution_Serialization {

    /**
     * Finds all duplicate subtrees in a binary tree.
     * Strategy: Post-order traversal with string serialization and frequency
     * counting.
     * Time: O(N^2), Space: O(N^2).
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        serialize(root, counts, res);
        return res;
    }

    /**
     * Helper to serialize subtrees and track duplicates.
     */
    private String serialize(TreeNode node, Map<String, Integer> counts, List<TreeNode> res) {
        if (node == null)
            return "#";

        // Serialized format: root_val,left_serialized,right_serialized
        // Commas ensure values like "11,2" aren't confused with "1,12"
        String serial = node.val + "," + serialize(node.left, counts, res) + "," + serialize(node.right, counts, res);

        counts.put(serial, counts.getOrDefault(serial, 0) + 1);

        // If we've seen this exact structure exactly twice, add it to results
        if (counts.get(serial) == 2) {
            res.add(node);
        }

        return serial;
    }

    public static void main(String[] args) {
        Solution_Serialization sol = new Solution_Serialization();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, new TreeNode(2, new TreeNode(4), null), new TreeNode(4)));
        List<TreeNode> result = sol.findDuplicateSubtrees(root);
        System.out.println("Number of duplicate roots: " + result.size()); // Should be 2 (Node 4 and Node 2-4)
    }
}
