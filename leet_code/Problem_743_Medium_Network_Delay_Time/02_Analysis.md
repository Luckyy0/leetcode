# Analysis for Network Delay Time
# *Phân tích cho bài toán Thời gian Trễ Mạng*

## 1. Problem Essence & Shortest Path
## *1. Bản chất vấn đề & Đường đi Ngắn nhất*

### The Challenge
### *Thách thức*
We need to find how long it takes for a signal to reach the *furthest* reachable node from a source $k$. This is equivalent to finding the shortest path from $k$ to every other node, and then taking the **maximum** of these shortest paths. If any node is unreachable (distance is infinity), the answer is -1.
*Chúng ta cần tìm xem mất bao lâu để tín hiệu đến được nút *xa nhất* có thể tiếp cận từ nguồn $k$. Điều này tương đương với việc tìm đường đi ngắn nhất từ $k$ đến mọi nút khác, và sau đó lấy giá trị **lớn nhất** trong các khoảng cách ngắn nhất này. Nếu có bất kỳ nút nào không thể tiếp cận (khoảng cách là vô cực), câu trả lời là -1.*

---

## 2. Strategy: Dijkstra's Algorithm
## *2. Chiến lược: Thuật toán Dijkstra*

Since all edge weights (times) are non-negative, Dijkstra's algorithm is the most efficient and standard choice.
*Vì tất cả trọng số cạnh (thời gian) đều không âm, thuật toán Dijkstra là lựa chọn hiệu quả và chuẩn mực nhất.*

### Step-by-Step Logic
### *Logic từng bước*

1.  **Graph Representation:** Use an Adjacency List `Map<Integer, List<int[]>>` or `List<int[]>[]` to store edges `(target, weight)`.
    *   **Biểu diễn Đồ thị:** Sử dụng Danh sách kề để lưu các cạnh `(đích, trọng số)`.*

2.  **Initialization:**
    - `dist` array initialized to Infinity, with `dist[k] = 0`.
    - Priority Queue (Min-Heap) storing `(time, node)`, initialized with `(0, k)`.
    *   **Khởi tạo:** Mảng khoảng cách khởi tạo là Vô cực, với `dist[k] = 0`. Hàng đợi ưu tiên (Min-Heap) lưu `(thời gian, nút)`, bắt đầu bằng `(0, k)`.*

3.  **Relaxation Loop:**
    - While the PQ is not empty:
        - Pop the node `u` with the smallest `d`.
        - If `d > dist[u]`, skip (outdated record).
        - For each neighbor `v` with weight `w`:
            - If `dist[u] + w < dist[v]`:
                - Update `dist[v] = dist[u] + w`.
                - Push `(dist[v], v)` to PQ.
    *   **Vòng lặp Làm mềm (Relaxation):** Khi hàng đợi chưa rỗng: Lấy nút `u` có khoảng cách nhỏ nhất. Nếu tìm thấy đường đi ngắn hơn đến nút kề `v`, cập nhật và đẩy vào hàng đợi.*

4.  **Final Calculation:**
    - Iterate through `1` to `n`. Find `max(dist[i])`.
    - If any `dist[i]` is still Infinity, return -1.
    *   **Tính toán cuối cùng:** Duyệt từ `1` đến `n`. Tìm giá trị lớn nhất. Nếu có nút nào vẫn là Vô cực, trả về -1.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(E \log V)$, where $E$ is the number of edges and $V$ is the number of nodes.
    *   **Độ phức tạp thời gian:** $O(E \log V)$.*
*   **Space Complexity:** $O(V + E)$ for graph storage and dist array.
    *   **Độ phức tạp không gian:** $O(V + E)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**n=4, k=2, edges=[(2,1,1), (2,3,1), (3,4,1)]**
1. PQ: `[(0, 2)]`. dist: `[inf, inf, 0, inf, inf]`
2. Pop 2. Neighbors 1 (w=1), 3 (w=1).
   - dist[1] = 1, push (1, 1).
   - dist[3] = 1, push (1, 3).
   - PQ: `[(1, 1), (1, 3)]`
3. Pop 1. No neighbors.
4. Pop 3. Neighbor 4 (w=1).
   - dist[4] = 1 + 1 = 2, push (2, 4).
   - PQ: `[(2, 4)]`
5. Pop 4. No neighbors.
**Max dist:** 2.

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

For "broadcast time" or "shortest path" in networks with non-negative latency, Dijkstra is the gold standard. Bellman-Ford (or SPFA) is only needed if negative weights exist.
*Đối với "thời gian phát sóng" hoặc "đường đi ngắn nhất" trong mạng có độ trễ không âm, Dijkstra là tiêu chuẩn vàng. Bellman-Ford (hoặc SPFA) chỉ cần thiết nếu tồn tại trọng số âm.*
---
*Độ trễ (Delay) của một hệ thống được định đoạt bởi mắt xích yếu nhất, hay đúng hơn là điểm đến xa xôi nhất. Đồ thị có hướng với trọng số là bản đồ của sự truyền tin. Dữ liệu dạy ta rằng bằng cách ưu tiên những con đường ngắn nhất trước (Priority Queue), ta có thể lan tỏa thông tin một cách tối ưu, đảm bảo không ai bị bỏ lại phía sau (Nodes reachability) trong dòng chảy của kết nối.*
The latency (Delay) of a system is determined by the weakest link, or rather the most distant destination. A directed weighted graph is a map of transmission. Data teaches us that by prioritizing the shortest paths first (Priority Queue), we can propagate information optimally, ensuring no one is left behind (Nodes reachability) in the flow of connection.
