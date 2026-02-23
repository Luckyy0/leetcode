# Analysis for All Nodes Distance K in Binary Tree
# *Phân tích cho bài toán Tất cả các Nút cách Khoảng K trong Cây Nhị phân*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
In a binary tree, we can easily move to children, but not to parents. Finding nodes at distance $K$ from a `target` requires moving in all directions (up, left, right).
*Trong một cây nhị phân, chúng ta có thể dễ dàng di chuyển xuống các nút con, nhưng không thể di chuyển lên nút cha. Tìm các nút cách `target` một khoảng $K$ đòi hỏi phải di chuyển theo mọi hướng (lên, trái, phải).*

---

## 2. Strategy: Graph Transformation + BFS
## *2. Chiến lược: Chuyển đổi Đồ thị + BFS*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Map Parent Links:** Perform a DFS traversal to map each node to its parent. This effectively turns the tree into an undirected graph where each node has up to 3 neighbors.
    *   **Ánh xạ liên kết cha:** Thực hiện duyệt DFS để ánh xạ mỗi nút với nút cha của nó. Điều này chuyển đổi cây thành một đồ thị vô hướng một cách hiệu quả, nơi mỗi nút có tối đa 3 nút láng giềng.*

2.  **Breadth-First Search (BFS):**
    - Treat the `target` node as the starting point.
    - Use a queue for BFS and a set to keep track of visited nodes to avoid cycles/revisiting.
    - After $K$ steps in the BFS, all nodes currently in the queue are at distance $K$.
    *   **Tìm kiếm theo chiều rộng (BFS):** Coi nút `target` là điểm bắt đầu. Sử dụng hàng đợi cho BFS và một tập hợp để theo dõi các nút đã ghé thăm nhằm tránh lặp lại/chu trình. Sau $K$ bước trong BFS, tất cả các nút hiện có trong hàng đợi sẽ cách một khoảng đúng bằng $K$.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    buildParentMap(root, null, parentMap);
    
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();
    queue.offer(target);
    visited.add(target);
    
    int dist = 0;
    while (!queue.isEmpty()) {
        if (dist == k) {
            List<Integer> res = new ArrayList<>();
            for (TreeNode node : queue) res.add(node.val);
            return res;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            // Check left, right, and parent
            if (curr.left != null && !visited.contains(curr.left)) {
                visited.add(curr.left);
                queue.offer(curr.left);
            }
            if (curr.right != null && !visited.contains(curr.right)) {
                visited.add(curr.right);
                queue.offer(curr.right);
            }
            TreeNode parent = parentMap.get(curr);
            if (parent != null && !visited.contains(parent)) {
                visited.add(parent);
                queue.offer(parent);
            }
        }
        dist++;
    }
    return new ArrayList<>();
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N)$, where $N$ is the number of nodes. We visit each node once during parent mapping and once during BFS.
    *   **Độ phức tạp thời gian:** $O(N)$, trong đó $N$ là số lượng nút. Chúng ta ghé thăm mỗi nút một lần trong quá trình ánh xạ cha và một lần trong BFS.*
*   **Space Complexity:** $O(N)$ for the parent map, the queue, and the visited set.
    *   **Độ phức tạp không gian:** $O(N)$ cho ánh xạ cha, hàng đợi và tập hợp các nút đã ghé thăm.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Turning the directional tree into a bi-directional graph using a parent map is the most straightforward way to enable omni-directional BFS.
*Chuyển đổi cây có hướng thành đồ thị hai chiều bằng cách sử dụng bản đồ cha là cách đơn giản nhất để thực hiện BFS đa hướng.*
