package leetcode.P133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * Problem 133: Clone Graph
     * Approach: DFS with Mapping
     * 
     * Theoretical Basis:
     * - Use a HashMap to store the mapping between the original node and its clone.
     * - Perform a DFS traversal to explore all nodes and create clones.
     * 
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     */
    private Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        // If node already cloned, return it
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create clone
        Node clone = new Node(node.val);
        visited.put(node, clone);

        // Clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a simple graph: 1 -- 2
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);

        Node clonedN1 = solution.cloneGraph(n1);
        System.out.println("Original 1: " + n1.val + ", Neighbor: " + n1.neighbors.get(0).val);
        System.out.println("Cloned 1: " + clonedN1.val + ", Neighbor: " + clonedN1.neighbors.get(0).val);
        System.out.println("Are they same objects? " + (n1 == clonedN1));
    }
}
