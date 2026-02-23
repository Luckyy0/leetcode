# Analysis for Evaluate Division
# *Phân tích cho bài toán Tính toán Phép chia*

## 1. Problem Essence & Graph Modeling
## *1. Bản chất vấn đề & Mô hình hóa Đồ thị*

### The Challenge
### *Thách thức*
Calculating ratios between variables based on a set of known relative values. This can be viewed as finding paths in a weighted directed graph.

### Strategy: Graph DFS/BFS
### *Chiến lược: Duyệt Đồ thị DFS/BFS*
1.  **Nodes:** Each variable is a node.
2.  **Edges:**
    - If $A / B = V$, add a directed edge $A \to B$ with weight $V$.
    - Add a directed edge $B \to A$ with weight $1/V$.
3.  **Pathfinding:**
    - To query $C / D$, find a path from $C$ to $D$ in the graph.
    - If a path exists ($C \to X_1 \to X_2 \dots \to D$), the answer is the product of weights along the path: $W_1 \cdot W_2 \dots \cdot W_n$.
    - If no path exists, or either node is unknown, return $-1.0$.
    - $C / C$ is $1.0$ if $C$ exists.

---

## 2. Approach: Adjacency List + DFS
## *2. Hướng tiếp cận: Danh sách kề + DFS*

### Logic
### *Logic*
Construct an adjacency list `Map<String, Map<String, Double>>`. Use DFS to find the path and accumulate the multiplication result. Use a `Set` to prevent infinite loops in the graph.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Versatile:** Handles complex chaining of divisions.
    *Linh hoạt: Xử lý được các chuỗi phép chia phức tạp.*
*   **Intuitive:** Directly translates mathematical relationships into graph edges.
    *Trực quan: Chuyển đổi trực tiếp các mối quan hệ toán học thành các cạnh đồ thị.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** 
    - Build graph: $O(E)$, where $E$ is number of equations.
    - Each query: $O(V + E)$ where $V$ is variables and $E$ is edges.
    *Độ phức tạp thời gian: O(E) dựng đồ thị, O(V+E) mỗi truy vấn.*
*   **Space Complexity:** $O(V + E)$ to store the graph.
    *Độ phức tạp không gian: $O(V + E)$.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Equations:** `a/b=2, b/c=3`. **Query:** `a/c`.
1. Graph:
   - `a -> b` (2.0), `b -> a` (0.5)
   - `b -> c` (3.0), `c -> b` (0.33)
2. DFS `a` to `c`:
   - `a -> b`: Weight 2.0.
   - `b -> c`: Weight 3.0.
   - Reach target `c`. Product: $2.0 \times 3.0 = 6.0$.
Result: 6.0.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Graph construction with DFS pathfinding.
*Xây dựng đồ thị với tìm kiếm đường đi bằng DFS.*
---
*Mọi mối quan hệ (equations) đều có thể được kết nối để tạo nên những hiểu biết mới (queries). Bằng cách coi thế giới là một mạng lưới các mắt xích (graph), ta có thể tìm ra con đường liên kết giữa hai điểm dường như không liên quan, chỉ bằng cách đi qua những trung gian (vertices) phù hợp.*
Every relationship (equations) can be connected to create new insights (queries). By seeing the world as a network of links (graph), we can find the connection between two seemingly unrelated points, just by passing through the right intermediaries (vertices).
