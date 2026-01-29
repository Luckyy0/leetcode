package leetcode.P428_SerializeAndDeserializeNaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Problem 428: Serialize and Deserialize N-ary Tree
     * Approach: Preorder Traversal (Val, ChildCount)
     */
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null)
            return;

        sb.append(node.val).append(",").append(node.children.size()).append(",");
        for (Node child : node.children) {
            serializeHelper(child, sb);
        }
    }

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
        int numChildren = Integer.parseInt(queue.poll());

        Node node = new Node(val, new ArrayList<>());
        for (int i = 0; i < numChildren; i++) {
            node.children.add(deserializeHelper(queue));
        }

        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // [1,null,3,2,4,null,5,6]
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> n3_children = new ArrayList<>();
        n3_children.add(n5);
        n3_children.add(n6);

        Node n3 = new Node(3, n3_children);
        Node n2 = new Node(2);
        Node n4 = new Node(4);

        List<Node> root_children = new ArrayList<>();
        root_children.add(n3);
        root_children.add(n2);
        root_children.add(n4);
        Node root = new Node(1, root_children);

        String serialized = sol.serialize(root);
        System.out.println("Serialized: " + serialized);

        Node deserialized = sol.deserialize(serialized);
        System.out.println("Deserialized Root Val: " + deserialized.val);
        System.out.println("Child count: " + deserialized.children.size());
    }
}
