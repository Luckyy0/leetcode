package leetcode.P1506_FindRootOfNAryTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public Node findRoot(List<Node> tree) {
        if (tree == null || tree.isEmpty())
            return null;

        long sum = 0; // Use long to prevent overflow

        for (Node node : tree) {
            sum += node.val;
            for (Node child : node.children) {
                sum -= child.val;
            }
        }

        // sum is now root.val
        for (Node node : tree) {
            if (node.val == (int) sum) {
                return node;
            }
        }

        return null;
    }
}
