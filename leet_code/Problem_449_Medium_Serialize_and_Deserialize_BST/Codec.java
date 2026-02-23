package leet_code.Problem_449_Medium_Serialize_and_Deserialize_BST;

import java.util.*;

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
     * Serializes a BST to a single string.
     * Strategy: Preorder traversal.
     */
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString(); // remove last comma
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    /**
     * Deserializes your encoded data to tree.
     * Strategy: Range-based reconstruction from preorder.
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode deserializeHelper(Queue<String> queue, int min, int max) {
        if (queue.isEmpty())
            return null;

        int val = Integer.parseInt(queue.peek());
        if (val < min || val > max)
            return null;

        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserializeHelper(queue, min, val);
        node.right = deserializeHelper(queue, val, max);

        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        // Construct BST: 5 -> [2, 8]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        String s = codec.serialize(root);
        System.out.println("Serialized: " + s);

        TreeNode d = codec.deserialize(s);
        System.out.println("Deserialized Root: " + d.val);
        System.out.println("Left child: " + d.left.val);
        System.out.println("Right child: " + d.right.val);
    }
}
