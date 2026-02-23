# Analysis for Find Eventual Safe States
# *Phân tích cho bài toán Tìm các trạng thái an toàn cuối cùng*

## 1. Problem Essence & Cycles
## *1. Bản chất vấn đề & Chu trình*

### The Challenge
### *Thách thức*
A node is "safe" if every path from it leads to a terminal node.
This is equivalent to saying the node is **not** part of any cycle and cannot reach any cycle.
Any node that belongs to a cycle or can reach a node in a cycle is "unsafe".
*Một nút là "an toàn" nếu mọi đường đi từ nó đều dẫn đến nút kết thúc. Điều này tương đương với việc nút đó **không** thuộc bất kỳ chu trình nào và không thể dẫn đến chu trình nào. Bất kỳ nút nào nằm trong chu trình hoặc có thể đi đến chu trình đều là "không an toàn".*

---

## 2. Strategy: DFS or Topological Sort
## *2. Chiến lược: DFS hoặc Sắp xếp Topo*

### Method 1: DFS with 3 Colors
### *Phương pháp 1: DFS với Quy tắc 3 màu*
We can use a state array to color nodes:
- `0`: Unvisited (Chưa thăm)
- `1`: Visiting (Đang thăm - nằm trong nhánh đệ quy hiện tại)
- `2`: Safe (An toàn - đã thăm và không có chu trình)
*Chúng ta có thể dùng mảng trạng thái để tô màu: `0` chưa thăm, `1` đang thăm, `2` an toàn.*

If we encounter a node that is currently being visited (`1`), we've found a cycle. All nodes in that path are unsafe.
If a node only reaches "safe" nodes (`2`), it becomes safe itself.

### Method 2: Topological Sort (Reverse Kahn's)
### *Phương pháp 2: Sắp xếp Topo (Kahn ngược)*
1. Reverse the graph edges.
2. Calculate out-degrees of nodes in original graph (which are in-degrees in reversed graph).
3. Nodes with out-degree 0 are terminal/safe.
4. Use Kahn's algorithm on the reversed graph to find all reachable safe nodes.
*1. Đảo ngược các cạnh đồ thị. 2. Tính bậc ra của các nút. 3. Nút bậc ra 0 là an toàn. 4. Dùng thuật toán Kahn trên đồ thị đảo để tìm tất cả các nút an toàn.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O(V + E)$. We visit every node and edge once.
    *   **Độ phức tạp thời gian:** $O(V + E)$.*
*   **Space Complexity:** $O(V + E)$ or $O(V)$ depending on the method. DFS uses $O(V)$ for coloring and stack.
    *   **Độ phức tạp không gian:** $O(V + E)$ hoặc $O(V)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Input:** `graph = [[1,2],[2,3],[5],[0],[5],[],[]]`
- Node 5, 6: Out-degree 0. (Safe).
- Node 2: Points to 5 (Safe). Node 2 becomes Safe.
- Node 4: Points to 5 (Safe). Node 4 becomes Safe.
- Nodes 0, 1, 3: Form cycle 0 -> 1 -> 2 (no 2 is fine) -> 3 -> 0?
  Wait: 0->1, 1->2 (safe), 1->3, 3->0. Cycle is 0-1-3. Unsafe.
**Result:** [2, 4, 5, 6]

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

DFS with coloring is very efficient and easy to implement for cycle detection in directed graphs.
*DFS với tô màu là cách hiệu quả và dễ cài đặt nhất để phát hiện chu trình trong đồ thị có hướng.*
