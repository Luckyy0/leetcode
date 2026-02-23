package leet_code.Problem_919_Medium_Complete_Binary_Tree_Inserter;

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

/**
 * Problem 919: Complete Binary Tree Inserter
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 */
public class CBTInserter {

    private TreeNode root;
    // Deque stores nodes that are part of the insertion frontier
    // i.e., nodes that have 0 or 1 child and can accept new children.
    private Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        this.deque = new LinkedList<>();

        // Populate the deque with candidate parents using BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // If a node is incomplete (has missing left or right child),
            // it is a candidate for insertion.
            // Since it's a complete tree, once we find one such node,
            // all subsequent nodes in level order are also candidates (have 0 children).
            if (node.left == null || node.right == null) {
                deque.offer(node);
            }

            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    /**
     * Inserts a new value into the complete binary tree.
     * Strategy: Use the deque to find the first incomplete parent.
     */
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        // The head of the deque is the first node that can accept a child
        TreeNode parent = deque.peek();

        if (parent.left == null) {
            parent.left = node;
            // Parent now has 1 child, stays in deque (unless it was already full and
            // invalid logic?
            // In complete tree, left is filled first. So if left is null, it stays).
        } else {
            parent.right = node;
            // Parent now has 2 children, so remove from deque
            deque.poll();
        }

        // The new node is a leaf, so it's a candidate for future children
        deque.offer(node);

        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        CBTInserter inserter = new CBTInserter(root);
        System.out.println("Insert 3: Parent " + inserter.insert(3)); // Parent 1. Tree: [1, 2, 3]
        System.out.println("Insert 4: Parent " + inserter.insert(4)); // Parent 2. Tree: [1, 2, 3, 4]

        TreeNode r = inserter.get_root();
        // Simple BFS to print tree
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(r);
        System.out.print("Tree Level Order: ");
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            System.out.print(n.val + " ");
            if (n.left != null)
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
        }
        System.out.println();
    }
}
