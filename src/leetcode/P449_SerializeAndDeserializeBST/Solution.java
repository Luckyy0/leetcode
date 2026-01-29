package leetcode.P449_SerializeAndDeserializeBST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Problem 449: Serialize and Deserialize BST
     * Approach: Preorder Traversal utilizing BST properties
     */
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null)
            return;
        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return build(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(Queue<String> queue, int lower, int upper) {
        if (queue.isEmpty())
            return null;

        int val = Integer.parseInt(queue.peek());
        if (val < lower || val > upper)
            return null;

        queue.poll();
        TreeNode node = new TreeNode(val);
        node.left = build(queue, lower, val);
        node.right = build(queue, val, upper);

        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [2,1,3]
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        String s = sol.serialize(root);
        System.out.println("Serialized: " + s);

        TreeNode res = sol.deserialize(s);
        System.out.println("Deserialized Root: " + res.val);
        System.out.println("Left child: " + res.left.val);
        System.out.println("Right child: " + res.right.val);
    }
}
