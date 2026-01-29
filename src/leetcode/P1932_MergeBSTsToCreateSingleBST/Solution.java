package leetcode.P1932_MergeBSTsToCreateSingleBST;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
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

public class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> valToRoot = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (TreeNode t : trees) {
            if (valToRoot.containsKey(t.val))
                return null; // Duplicate roots? Usually distinct constraint.
            valToRoot.put(t.val, t);
            inDegree.putIfAbsent(t.val, 0);

            // Traverse children to mark in-degrees
            // Just direct children? Yes, merging happens at leaves.
            // Any node in input trees (except global root) must be a child somewhere or a
            // root that merges into a leaf.
            // Wait, input trees are small blocks.
            // We need to count occurrences of values in children positions.
            if (t.left != null) {
                inDegree.put(t.left.val, inDegree.getOrDefault(t.left.val, 0) + 1);
            }
            if (t.right != null) {
                inDegree.put(t.right.val, inDegree.getOrDefault(t.right.val, 0) + 1);
            }
        }

        // Find single root
        TreeNode globalRoot = null;
        for (TreeNode t : trees) {
            if (inDegree.get(t.val) == 0) {
                if (globalRoot != null)
                    return null; // Multiple roots
                globalRoot = t;
            }
        }

        if (globalRoot == null)
            return null; // Cycle

        // Build Tree
        // Use a set to track used roots to ensure all are used
        int mergedCount = 1; // Count of 'trees' merged (global root is 1)

        // BFS/DFS to construct
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(globalRoot);

        // Range validation
        // Simple approach: Construct then validate.
        // Be careful of cycles.
        // Since we only merge leaves, we don't need cycle check explicitly if we track
        // count?
        // Wait, simple range check is cleaner.

        return isValidBST(globalRoot, Integer.MIN_VALUE, Integer.MAX_VALUE, valToRoot) && valToRoot.size() == 1
                ? globalRoot
                : null;
        // Wait, I need to remove from valToRoot as I merge to check if all used?
        // Or count.
        // Let's modify approach:
        // Traverse and merge. If valid, return root.
    }

    // We need to perform the merging during traversal for validation to work on the
    // full tree.
    private boolean isValidBST(TreeNode node, long min, long max, Map<Integer, TreeNode> valToRoot) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;

        // Check if this node is a leaf and can be expanded
        if (node.left == null && node.right == null) {
            if (valToRoot.containsKey(node.val) && valToRoot.get(node.val) != node) {
                TreeNode nextTree = valToRoot.get(node.val);
                node.left = nextTree.left;
                node.right = nextTree.right;
                valToRoot.remove(node.val); // Mark as merged
            }
        }

        return isValidBST(node.left, min, node.val, valToRoot) &&
                isValidBST(node.right, node.val, max, valToRoot);
    }
}
