# Analysis for Reachable Nodes In Subdivided Graph
# *Phân tích cho bài toán Các nút có thể đến được trong Đồ thị Chia nhỏ*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
We have a graph where each edge is subdivided into smaller segments (new nodes). We want to find how many total nodes (original + subdivided) are reachable within `maxMoves` from node 0.
*Chúng ta có một đồ thị nơi mỗi cạnh được chia nhỏ thành các đoạn (nút mới). Chúng ta muốn tìm tổng số nút (gốc + được chia nhỏ) có thể đến được trong phạm vi `maxMoves` từ nút 0.*

### KEY INSIGHT
### *Nhận xét quan trọng*
An edge between `u` and `v` with `cnt` new nodes can be treated as a weighted edge of weight `cnt + 1` in the original graph.
- The `cnt` nodes are "internal" to the edge.
- If we reach `u` with `moves` remaining, we can travel `moves` steps into this edge.
*Một cạnh giữa `u` và `v` với `cnt` nút mới có thể được coi là một cạnh có trọng số `cnt + 1` trong đồ thị gốc. `cnt` nút này nằm "bên trong" cạnh. Nếu chúng ta đến `u` và còn lại `moves` bước, chúng ta có thể đi sâu vào cạnh này `moves` bước.*

---

## 2. Strategy: Dijkstra's Algorithm
## *2. Chiến lược: Thuật toán Dijkstra*

### Step 1: Shortest Path to Original Nodes
### *Bước 1: Đường đi ngắn nhất đến các nút gốc*
Use Dijkstra's algorithm to find the minimum moves required to reach each original node. Let `dist[u]` be the minimum moves to reach node `u`.
- Initialize `dist[0] = 0`, others infinity.
- Use a Min-Heap Priority Queue.
- Relax edges: if `dist[u] + weight < dist[v]`, update `dist[v]`.
*Sử dụng thuật toán Dijkstra để tìm số bước tối thiểu cần thiết để đến mỗi nút gốc. Gọi `dist[u]` là số bước tối thiểu đến nút `u`. Khởi tạo `dist[0] = 0`, các nút khác là vô cùng.*

### Step 2: Calculate Reachable Nodes
### *Bước 2: Tính toán các nút có thể đến được*
The total count consists of:
1.  **Original Nodes:** Count node `i` if `dist[i] <= maxMoves`.
    *   **Nút gốc:** Đếm nút `i` nếu `dist[i] <= maxMoves`.*
2.  **Subdivided Nodes:** For each edge `(u, v)` with `cnt` nodes:
    - Nodes reachable from `u`: `a = max(0, maxMoves - dist[u])`.
    - Nodes reachable from `v`: `b = max(0, maxMoves - dist[v])`.
    - Total new nodes covered on this edge: `min(cnt, a + b)`.
    *   **Nút chia nhỏ:** Với mỗi cạnh `(u, v)` có `cnt` nút: Số nút đến được từ `u` là `a`. Số nút đến được từ `v` là `b`. Tổng số nút mới được bao phủ trên cạnh này là `min(cnt, a + b)`.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int reachableNodes(int[][] edges, int maxMoves, int n) {
    List<int[]>[] graph = new ArrayList[n];
    for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
    for (int[] edge : edges) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
        graph[edge[1]].add(new int[]{edge[0], edge[2]});
    }

    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    pq.offer(new int[]{0, 0}); // node, dist
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[0] = 0;

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int u = curr[0], d = curr[1];
        if (d > dist[u]) continue;

        for (int[] neighbor : graph[u]) {
            int v = neighbor[0];
            int weight = neighbor[1] + 1;
            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.offer(new int[]{v, dist[v]});
            }
        }
    }

    int ans = 0;
    for (int d : dist) {
        if (d <= maxMoves) ans++;
    }

    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], cnt = edge[2];
        int a = dist[u] == Integer.MAX_VALUE ? 0 : Math.max(0, maxMoves - dist[u]);
        int b = dist[v] == Integer.MAX_VALUE ? 0 : Math.max(0, maxMoves - dist[v]);
        ans += Math.min(cnt, a + b);
    }

    return ans;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(E \log N)$, where $E$ is the number of edges and $N$ is the number of nodes. This is standard for Dijkstra with a Priority Queue.
    *   **Độ phức tạp thời gian:** $O(E \log N)$, tiêu chuẩn cho thuật toán Dijkstra.*
*   **Space Complexity:** $O(N + E)$ for the adjacency list and distance array.
    *   **Độ phức tạp không gian:** $O(N + E)$ cho danh sách kề và mảng khoảng cách.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Modeling subdivided edges as weighted edges allows us to use standard shortest path algorithms. The tricky part is correctly counting the internal nodes of an edge, which can be reached from both ends.
*Mô hình hóa các cạnh bị chia nhỏ thành các cạnh có trọng số cho phép chúng ta sử dụng các thuật toán tìm đường ngắn nhất tiêu chuẩn. Phần khó là đếm chính xác các nút bên trong của một cạnh, chúng có thể được tiếp cận từ cả hai đầu.*
