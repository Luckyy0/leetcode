package leetcode.P431_EncodeNaryTreeToBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class NaryNode {
        public int val;
        public List<NaryNode> children;

        public NaryNode() {
        }

        public NaryNode(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public NaryNode(int _val, List<NaryNode> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class BinaryNode {
        public int val;
        public BinaryNode left;
        public BinaryNode right;

        public BinaryNode() {
        }

        public BinaryNode(int _val) {
            val = _val;
        }
    }

    /**
     * Problem 431: Encode N-ary Tree to Binary Tree
     * Approach: Left-Child Right-Sibling Representation
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(H) recursion height
     */
    public BinaryNode encode(NaryNode root) {
        if (root == null)
            return null;

        BinaryNode bRoot = new BinaryNode(root.val);

        // The binary left child is the first child of the N-ary node
        if (root.children != null && !root.children.isEmpty()) {
            bRoot.left = encode(root.children.get(0));

            // The others are siblings, linked via right pointers in the binary tree
            BinaryNode curr = bRoot.left;
            for (int i = 1; i < root.children.size(); i++) {
                curr.right = encode(root.children.get(i));
                curr = curr.right;
            }
        }

        return bRoot;
    }

    public NaryNode decode(BinaryNode root) {
        if (root == null)
            return null;

        NaryNode nRoot = new NaryNode(root.val);

        // Successive children are found starting from binary left, then following
        // binary right
        BinaryNode curr = root.left;
        while (curr != null) {
            nRoot.children.add(decode(curr));
            curr = curr.right;
        }

        return nRoot;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // N-ary: [1, [3, 2, 4], [5, 6]]
        NaryNode n5 = new NaryNode(5);
        NaryNode n6 = new NaryNode(6);
        List<NaryNode> c3 = new ArrayList<>();
        c3.add(n5);
        c3.add(n6);
        NaryNode n3 = new NaryNode(3, c3);
        NaryNode n2 = new NaryNode(2);
        NaryNode n4 = new NaryNode(4);
        List<NaryNode> c1 = new ArrayList<>();
        c1.add(n3);
        c1.add(n2);
        c1.add(n4);
        NaryNode root = new NaryNode(1, c1);

        BinaryNode bRoot = sol.encode(root);
        System.out.println("Encoded root val: " + bRoot.val);
        System.out.println("Encoded left child val: " + bRoot.left.val);

        NaryNode reconstructed = sol.decode(bRoot);
        System.out.println("Decoded root val: " + reconstructed.val);
        System.out.println("Child count: " + reconstructed.children.size());
    }
}
