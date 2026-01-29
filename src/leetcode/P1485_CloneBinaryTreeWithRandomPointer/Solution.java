package leetcode.P1485_CloneBinaryTreeWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node left;
    Node right;
    Node random;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    NodeCopy() {
    }

    NodeCopy(int val) {
        this.val = val;
    }

    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.random = random;
    }
}

class Solution {
    Map<Node, NodeCopy> map = new HashMap<>();

    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null)
            return null;
        if (map.containsKey(root))
            return map.get(root);

        NodeCopy newNode = new NodeCopy(root.val);
        map.put(root, newNode);

        newNode.left = copyRandomBinaryTree(root.left);
        newNode.right = copyRandomBinaryTree(root.right);
        newNode.random = copyRandomBinaryTree(root.random);

        return newNode;
    }
}
