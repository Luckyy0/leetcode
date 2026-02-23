package leet_code.Problem_742_Medium_Closest_Leaf_in_a_Binary_Tree;

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

public class Solution {

    /**
     * Finds the value of the nearest leaf node to target k.
     * Strategy: Convert tree to graph (using parent map) and run BFS from target.
     * Time: O(N), Space: O(N).
     */
    public int findClosestLeaf(TreeNode root, int k) {
        // Map to store parent pointers
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode targetNode = findNodeAndBuildParents(root, k, parents);

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(targetNode);

        // Set to track visited nodes
        Set<TreeNode> visited = new HashSet<>();
        visited.add(targetNode);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            // If it's a leaf, we found the closest one
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }

            // Add neighbors: left, right, and parent
            if (curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if (curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if (parents.containsKey(curr) && visited.add(parents.get(curr))) {
                queue.add(parents.get(curr));
            }
        }

        return -1; // Should not reach here
    }

    // Helper: DFS to find target node and populate parent map
    private TreeNode findNodeAndBuildParents(TreeNode node, int k, Map<TreeNode, TreeNode> parents) {
        if (node == null)
            return null;

        if (node.val == k) {
            // Even if we found the node, we must continue to build full parent map
            // OR finding the node is just part of the traversal.
            // Actually, we can return the node but MUST ensure parents for the SUBTREE are
            // built?
            // Wait, we need parents for the whole tree to go UP.
            // So we can traverse the whole tree.
            // Optimized: We traverse the whole tree to build the map.
            // But we can stop 'finding' once found, but parents need to be populated.
        }

        TreeNode target = null;
        if (node.val == k)
            target = node;

        if (node.left != null) {
            parents.put(node.left, node);
            TreeNode leftRes = findNodeAndBuildParents(node.left, k, parents);
            if (leftRes != null)
                target = leftRes;
        }

        if (node.right != null) {
            parents.put(node.right, node);
            TreeNode rightRes = findNodeAndBuildParents(node.right, k, parents);
            if (rightRes != null)
                target = rightRes;
        }

        return target;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Example 1: root = [1, 3, 2], k = 1
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        System.out.println("Result 1: " + sol.findClosestLeaf(root1, 1)); // 2 or 3

        // Example 3: root = [1,2,3,4,null,null,null,5,null,6], k = 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.left.left = new TreeNode(5);
        root3.left.left.left.left = new TreeNode(6);
        System.out.println("Result 3: " + sol.findClosestLeaf(root3, 2)); // 3
    }
}
