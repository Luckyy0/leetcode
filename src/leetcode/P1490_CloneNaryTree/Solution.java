package leetcode.P1490_CloneNaryTree;

import java.util.ArrayList;
import java.util.List;

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
    public Node cloneTree(Node root) {
        if (root == null)
            return null;

        Node newNode = new Node(root.val);
        newNode.children = new ArrayList<>();

        if (root.children != null) {
            for (Node child : root.children) {
                newNode.children.add(cloneTree(child));
            }
        }

        return newNode;
    }
}
