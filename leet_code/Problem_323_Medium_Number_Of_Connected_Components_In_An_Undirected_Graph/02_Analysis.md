# Analysis for Number of Connected Components in an Undirected Graph
# *Phân tích cho bài toán Số lượng Thành phần Liên thông trong Đồ thị Vô hướng*

## 1. Problem Essence & Union Find
## *1. Bản chất vấn đề & Union Find*

### The Challenge
### *Thách thức*
Count distinct subgraphs where all nodes are connected.
DFS/BFS: Visit all nodes, increment count for each unvisited start node.
Union-Find: Start with N components. Merge nodes. Each successful merge decrements count.

### Strategy: Union-Find (DSU)
### *Chiến lược: Union-Find (DSU)*
Initialize `parent` array `0..n-1`. `count = n`.
Process edges. For `(u, v)`:
`rootU = find(u)`.
`rootV = find(v)`.
If `rootU != rootV`:
  `union(rootU, rootV)`.
  `count--`.
Return `count`.

### Alternative: BFS/DFS
### *Thay thế: BFS/DFS*
Build adjacency list.
`visited` array.
For `i` from 0 to `n`:
  If not `visited[i]`:
    bfs(i).
    `count++`.
This constructs the graph ($O(N+E)$) and traverses ($O(N+E)$).
Union-Find: $O(E \alpha(N))$. Very fast. Space $O(N)$. No explicit graph construction needed.

---

## 2. Approach: Union-Find
## *2. Hướng tiếp cận: Union-Find*

### Logic
### *Logic*
(See above).

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **No Adjacency List:** Operates directly on edge list. Less memory overhead for graph structure if edges > N.
    *Không cần danh sách kề: Hoạt động trực tiếp trên danh sách cạnh. Ít tốn bộ nhớ hơn nếu số cạnh lớn.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(E \alpha(N)) \approx O(E)$.
    *Độ phức tạp thời gian: $O(E)$.*
*   **Space Complexity:** $O(N)$.
    *Độ phức tạp không gian: $O(N)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:** n=5, edges=[[0,1],[1,2],[3,4]]
Init count=5. Parent: [0,1,2,3,4].
Edge [0,1]: Unions 0-1. Res 4.
Edge [1,2]: Unions 1-2 (Root 0-1 matches? No, 0 and 2 separate initially). Res 3.
Edge [3,4]: Unions 3-4. Res 2.
Output 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Union-Find is the standard for connectivity counting.
*Union-Find là chuẩn mực để đếm tính liên thông.*
---
*Số lượng thành phần (components) cho biết mức độ phân mảnh của hệ thống. Sự kết nối (connection) làm giảm bớt số lượng nhưng lại gia tăng sức mạnh của từng khối thống nhất.*
The number of components indicates the fragmentation of the system. Connection reduces the quantity but increases the strength of each unified block.
