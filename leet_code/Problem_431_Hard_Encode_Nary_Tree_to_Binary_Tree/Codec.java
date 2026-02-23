package leet_code.Problem_431_Hard_Encode_Nary_Tree_to_Binary_Tree;

import java.util.*;

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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    /**
     * Encodes an N-ary tree to a binary tree.
     * Logic: First child goes to left, siblings go to right.
     */
    public TreeNode encode(Node root) {
        if (root == null)
            return null;

        TreeNode res = new TreeNode(root.val);

        if (root.children != null && !root.children.isEmpty()) {
            // First child becomes left child
            res.left = encode(root.children.get(0));

            // Siblings become right chain of the left child
            TreeNode curr = res.left;
            for (int i = 1; i < root.children.size(); i++) {
                curr.right = encode(root.children.get(i));
                curr = curr.right;
            }
        }

        return res;
    }

    /**
     * Decodes a binary tree to an N-ary tree.
     */
    public Node decode(TreeNode root) {
        if (root == null)
            return null;

        Node res = new Node(root.val, new ArrayList<>());

        // Follow the left child to find children list
        TreeNode curr = root.left;
        while (curr != null) {
            res.children.add(decode(curr));
            // Siblings are stored in the right pointer
            curr = curr.right;
        }

        return res;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

        // Construct N-ary Tree: 1 -> [3, 2, 4]
        Node n3 = new Node(3, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(n3, n2, n4));

        TreeNode encoded = codec.encode(root);
        System.out.println("Encoded root: " + encoded.val);
        System.out.println("Left child of root: " + encoded.left.val);
        System.out.println("Sibling of left child: " + encoded.left.right.val);

        Node decoded = codec.decode(encoded);
        System.out.println("Decoded root children size: " + decoded.children.size());
    }
}
