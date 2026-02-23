package leet_code.Problem_429_Medium_Nary_Tree_Level_Order_Traversal;

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

public class Solution_BFS {

    /**
     * Level order traversal of N-ary tree.
     * Uses Queue-based BFS.
     * Time: O(N), Space: O(W).
     * 
     * Duyệt cây N-phân theo mức.
     * Sử dụng BFS dựa trên hàng đợi.
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
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
        Solution_BFS solution = new Solution_BFS();

        // Construct Tree: 1 -> [3, 2, 4] -> [5, 6] (child of 3)
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());
        Node n3 = new Node(3, Arrays.asList(n5, n6));
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());
        Node root = new Node(1, Arrays.asList(n3, n2, n4));

        System.out.println("Result: " + solution.levelOrder(root));
    }
}
