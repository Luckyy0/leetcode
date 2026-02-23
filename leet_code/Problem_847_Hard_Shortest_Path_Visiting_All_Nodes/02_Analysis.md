# Analysis for Shortest Path Visiting All Nodes
# *Phân tích cho bài toán Đường đi Ngắn nhất Tham quan Tất cả các Nút*

## 1. Problem Essence & Constraints
## *1. Bản chất vấn đề & Ràng buộc*

### THE CHALLENGE
### *Thách thức*
Find the shortest path that covers all $N$ nodes in an undirected graph. Revisiting nodes and edges is allowed. Since $N$ is small ($N \le 12$), we can use bitmasking to track visited nodes.
*Tìm đường đi ngắn nhất đi qua tất cả $N$ nút trong đồ thị vô hướng. Cho phép đi qua một nút hoặc một cạnh nhiều lần. Vì $N$ nhỏ ($N \le 12$), chúng ta có thể sử dụng mặt nạ bit (bitmask) để theo dõi các nút đã tham quan.*

---

## 2. Strategy: BFS with Bitmask
## *2. Chiến lược: BFS với Mặt nạ Bit*

### State Definition
### *Định nghĩa trạng thái*
A state is defined as `(currentNode, visitedMask)`, where `visitedMask` is an integer where the $i$-th bit is set if node $i$ has been visited.
*Trạng thái được định nghĩa là `(nút_hiện_tại, mặt_nạ_đã_tham_quan)`. `visitedMask` là một số nguyên mà bit thứ $i$ được bật nếu nút $i$ đã được ghé thăm.*

### Why BFS?
### *Tại sao dùng BFS?*
BFS naturally finds the shortest path in an unweighted graph. The first time we reach a state where all bits in `visitedMask` are set, we found our answer.
*BFS tự nhiên tìm thấy đường đi ngắn nhất trong đồ thị không trọng số. Lần đầu tiên ta đạt được trạng thái mà tất cả các bit trong mặt nạ đều được bật, đó chính là kết quả.*

### Algorithm Steps
### *Các bước thuật toán*

1.  **Initialize Queue:** Add all possible starting nodes to the queue: `{node: i, mask: 1 << i, dist: 0}` for $i \in [0, n-1]$.
    *   **Khởi tạo hàng đợi:** Thêm tất cả các nút bắt đầu có thể có vào hàng đợi.*

2.  **Visited Tracker:** Use a 2D boolean array `seen[n][1 << n]` to avoid processing the same `(node, mask)` state multiple times.
    *   **Bộ theo dõi:** Sử dụng mảng boolean 2D `seen` để tránh xử lý trùng một trạng thái `(nút, mặt\_nạ)`.*

3.  **Process BFS:**
    - Dequeue current state.
    - If `mask == (1 << n) - 1`: Return `dist`.
    - Explore neighbors: For each neighbor $v$ of current node $u$:
        - `newMask = mask | (1 << v)`
        - If `seen[v][newMask]` is false:
            - Mark as seen and enqueue `{v, newMask, dist + 1}`.
    *   **Xử lý BFS:** Lấy trạng thái ra khỏi hàng đợi. Nếu mặt nạ đầy đủ, trả về `dist`. Duyệt qua các hàng xóm: tính mặt nạ mới, nếu trạng thái này chưa từng thấy, thêm vào hàng đợi.*

---

## 3. Implementation Logic
## *3. Logic triển khai*

### Java Solution Implementation
### *Triển khai giải pháp Java*

```java
public int shortestPathLength(int[][] graph) {
    int n = graph.length;
    int target = (1 << n) - 1;
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] seen = new boolean[n][1 << n];
    
    for (int i = 0; i < n; i++) {
        queue.add(new int[]{i, 1 << i, 0});
        seen[i][1 << i] = true;
    }
    
    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int u = curr[0], mask = curr[1], dist = curr[2];
        
        if (mask == target) return dist;
        
        for (int v : graph[u]) {
            int nextMask = mask | (1 << v);
            if (!seen[v][nextMask]) {
                seen[v][nextMask] = true;
                queue.add(new int[]{v, nextMask, dist + 1});
            }
        }
    }
    return 0;
}
```

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(N \cdot 2^N)$. There are $N \cdot 2^N$ possible states, and each state explores up to $N$ edges. Total complexity is $O(N^2 \cdot 2^N)$, which for $N=12$ is around $144 \cdot 4096 \approx 6 \cdot 10^5$.
    *   **Độ phức tạp thời gian:** $O(N^2 \cdot 2^N)$, khoảng $6 \cdot 10^5$ thao tác.*
*   **Space Complexity:** $O(N \cdot 2^N)$ for the `seen` array and queue.
    *   **Độ phức tạp không gian:** $O(N \cdot 2^N)$.*

---

## 5. Summary Recommendation
## *6. Khuyến nghị Tổng kết*

Bitmasking is the standard way to handle "visiting all nodes" or "all items" requirements when the count of items is small (usually $\le 20$). Combined with BFS, it perfectly solves shortest path variants.
*Mặt nạ bit là cách tiêu chuẩn để xử lý yêu cầu "ghé thăm tất cả" khi số lượng đối tượng nhỏ. Kết hợp với BFS, nó giải quyết hoàn hảo các bài toán tìm đường đi ngắn nhất.*
