package leetcode.P297_SerializeAndDeserializeBinaryTree;

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

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * Problem 297: Serialize and Deserialize Binary Tree
     * Approach: Preorder Traversal
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public static class Codec {

        private static final String SPLITTER = ",";
        private static final String NN = "X";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append(NN).append(SPLITTER);
            } else {
                sb.append(node.val).append(SPLITTER);
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> nodes = new LinkedList<>();
            nodes.addAll(Arrays.asList(data.split(SPLITTER)));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Queue<String> nodes) {
            String val = nodes.poll();
            if (val.equals(NN)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }
    }

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();

        // Tree: 1 -> left(2), right(3 -> left(4), right(5))
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3, n4, n5);
        TreeNode n2 = new TreeNode(2);
        TreeNode root = new TreeNode(1, n2, n3);

        String serialized = ser.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode result = deser.deserialize(serialized);
        String reserialized = ser.serialize(result);
        System.out.println("Re-Serialized: " + reserialized);

        if (serialized.equals(reserialized)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }
}
