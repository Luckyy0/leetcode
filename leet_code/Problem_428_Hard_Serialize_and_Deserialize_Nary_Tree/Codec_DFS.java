package leet_code.Problem_428_Hard_Serialize_and_Deserialize_Nary_Tree;

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

public class Codec_DFS {

    /**
     * Serializes an N-ary tree to a single string.
     * Strategy: Preorder traversal encoding [Value, ChildCount].
     * Time: O(N), Space: O(N).
     */
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.val).append(",");
        sb.append(node.children != null ? node.children.size() : 0).append(",");

        if (node.children != null) {
            for (Node child : node.children) {
                serializeHelper(child, sb);
            }
        }
    }

    /**
     * Deserializes a string back to an N-ary tree.
     */
    public Node deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private Node deserializeHelper(Queue<String> queue) {
        if (queue.isEmpty())
            return null;

        int val = Integer.parseInt(queue.poll());
        int size = Integer.parseInt(queue.poll());

        Node node = new Node(val, new ArrayList<>(size));
        for (int i = 0; i < size; i++) {
            node.children.add(deserializeHelper(queue));
        }

        return node;
    }

    public static void main(String[] args) {
        Codec_DFS codec = new Codec_DFS();

        // Construct Test Tree: 1 -> [3 -> [5, 6], 2, 4]
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        Node n3 = new Node(3, Arrays.asList(n5, n6));
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(n3, n2, n4));

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        Node deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized Root Value: " + deserializedRoot.val);
        System.out.println("Root Children Count: " + deserializedRoot.children.size());
    }
}
