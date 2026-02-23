package leet_code.Problem_297_Hard_Serialize_And_Deserialize_Binary_Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Codec {

    private static final String SPLITTER = ",";
    private static final String NN = "X"; // Null Node marker

    // Encodes a tree to a single string.
    // Mã hóa một cây thành một chuỗi duy nhất.
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

    // Decodes a single string to a list of strings.
    // Giải mã một chuỗi duy nhất thành một danh sách chuỗi.
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

    public static void main(String[] args) {
        Codec ser = new Codec();
        Codec deser = new Codec();

        // Test Case
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String str = ser.serialize(root);
        System.out.println("Serialized: " + str);

        TreeNode restored = deser.deserialize(str);
        System.out.println("Restored Root: " + restored.val);
        System.out.println("Restored Right-Left: " + restored.right.left.val);
    }
}
