package leetcode.P1516_MoveSubTreeOfNAryTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public Node moveSubTree(Node root, Node p, Node q) {
        if (p == q)
            return root;

        // Find parents
        Node parentP = findParent(root, p);
        Node parentQ = findParent(root, q);

        // Check if q is in p's subtree
        // Search p in ancestors of q is not efficient without parent pointers.
        // Better: Search q in p's subtree.
        // Wait, we need to know the direct child of p that leads to q if q is in p's
        // subtree.

        Node childOfPLeadingToQ = findChildLeadingTo(p, q);

        if (childOfPLeadingToQ != null) {
            // q is in p's subtree
            // 1. Remove childOfPLeadingToQ from p's children
            p.children.remove(childOfPLeadingToQ);

            // 2. Connect p to q
            q.children.add(p);

            // 3. Connect childOfPLeadingToQ to p's original parent
            if (parentP == null) {
                // p was root. New root is childOfPLeadingToQ
                return childOfPLeadingToQ;
            } else {
                int index = parentP.children.indexOf(p);
                parentP.children.set(index, childOfPLeadingToQ);
                return root;
            }
        } else {
            // q is NOT in p's subtree
            // Just move p to q
            if (parentP == null) {
                // p is root. It moves under q. But who becomes new root?
                // This case q is NOT in subtree, so p (root) contains q.
                // But if p is root and q is not in p's subtree, q doesn't exist?
                // Ah, q is in p's subtree if p is root.
                // So this branch is only taken if p is NOT root.
                return root; // Impossible case strictly if p is root and q exists
            }

            parentP.children.remove(p);
            q.children.add(p);
            return root;
        }
    }

    private Node findParent(Node root, Node target) {
        if (root == null || root == target)
            return null;
        for (Node child : root.children) {
            if (child == target)
                return root;
            Node res = findParent(child, target);
            if (res != null)
                return res;
        }
        return null; // Should not happen if valid
    }

    private Node findChildLeadingTo(Node root, Node target) {
        // Return direct child of root that is ancestor of target (or is target)
        for (Node child : root.children) {
            if (isInSubtree(child, target)) {
                return child;
            }
        }
        return null;
    }

    private boolean isInSubtree(Node cur, Node target) {
        if (cur == target)
            return true;
        for (Node child : cur.children) {
            if (isInSubtree(child, target))
                return true;
        }
        return false;
    }
}
