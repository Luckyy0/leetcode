package leetcode.P429_NaryTreeLevelOrderTraversal;

import java.util.ArrayList;
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
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * Problem 429: N-ary Tree Level Order Traversal
     * Approach: Breadth-First Search (Queue)
     * 
     * Time Complexity: O(N)
     * Space Complexity: O(W)
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                currentLevel.add(node.val);

                if (node.children != null) {
                    for (Node child : node.children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(currentLevel);
        }

        return result;
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
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());

        List<Node> root_children = new ArrayList<>();
        root_children.add(n3);
        root_children.add(n2);
        root_children.add(n4);
        Node root = new Node(1, root_children);

        System.out.println("Result: " + sol.levelOrder(root));
    }
}
