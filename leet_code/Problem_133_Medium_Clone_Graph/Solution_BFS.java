package leet_code.Problem_133_Medium_Clone_Graph;

import java.util.*;

// Definition for a Node.
class Node {
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

public class Solution_BFS {

    /**
     * Clones a connected undirected graph.
     * Uses BFS with a HashMap to handle cycles and deep copy.
     * 
     * Sao chép một đồ thị vô hướng đã kết nối.
     * Sử dụng BFS với HashMap để xử lý các chu trình và bản sao sâu.
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map original nodes to their corresponding cloned nodes
        // Ánh xạ các nút gốc sang các nút sao chép tương ứng
        Map<Node, Node> visited = new HashMap<>();

        // Initialize BFS
        // Khởi tạo BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        // Put the first node in the map
        // Đưa nút đầu tiên vào bản đồ
        visited.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node originalNode = queue.poll();

            // Iterate through neighbors of the original node
            // Lặp qua các nút lân cận của nút gốc
            for (Node neighbor : originalNode.neighbors) {
                // If the neighbor hasn't been cloned yet
                // Nếu nút lân cận chưa được sao chép
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor
                    // Sao chép nút lân cận
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add the original neighbor to queue for processing its own neighbors
                    // Thêm nút lân cận gốc vào hàng đợi để xử lý các nút lân cận của nó
                    queue.add(neighbor);
                }

                // Connect the cloned current node to the cloned neighbor
                // Kết nối nút hiện tại đã sao chép với nút lân cận đã sao chép
                visited.get(originalNode).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }

    public static void main(String[] args) {
        Solution_BFS solution = new Solution_BFS();

        // Construct a simple graph for testing
        // 1 - 2
        // | |
        // 4 - 3
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node clonedRoot = solution.cloneGraph(n1);

        // Basic verification
        System.out.println("Root val: " + clonedRoot.val); // Expected: 1
        System.out.println("Neighbor count: " + clonedRoot.neighbors.size()); // Expected: 2
        System.out.println("Independence check: " + (clonedRoot != n1)); // Expected: true
    }
}
