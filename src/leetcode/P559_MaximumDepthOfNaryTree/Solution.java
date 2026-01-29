package leetcode.P559_MaximumDepthOfNAryTree;

import java.util.List;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public int maxDepth(Node root) {
        if (root == null)
            return 0;

        int maxChildDepth = 0;
        if (root.children != null) {
            for (Node child : root.children) {
                maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
            }
        }

        return maxChildDepth + 1;
    }
}
