# Analysis for Number of Islands
# *Phân tích cho bài toán Số lượng hòn đảo*

## 1. Problem Essence & Graph Traversal
## *1. Bản chất vấn đề & Duyệt đồ thị*

### The "Connected Components" Problem
### *Bài toán "Các thành phần liên thông"*
We can visualize the grid as a graph where each `'1'` is a node. If two `'1'`s are adjacent (up, down, left, right), there is an edge between them. The problem asks for the number of **Connected Components** in this graph.
*Chúng ta có thể hình dung lưới như một đồ thị nơi mỗi `'1'` là một nút. Nếu hai `'1'` nằm cạnh nhau (trên, dưới, trái, phải), có một cạnh nối giữa chúng. Bài toán yêu cầu tìm số lượng **Thành phần liên thông** trong đồ thị này.*

---

## 2. Approach: DFS/BFS Sinking Strategy
## *2. Hướng tiếp cận: Chiến lược "Đánh chìm" bằng DFS/BFS*

To avoid counting the same island multiple times (or creating infinite loops), we need to track visited nodes.
*Để tránh đếm cùng một hòn đảo nhiều lần (hoặc tạo ra vòng lặp vô hạn), chúng ta cần theo dõi các nút đã thăm.*

### The "Sinking" Trick
### *Mẹo "Đánh chìm"*
Instead of using a separate `visited` array (which takes $O(M \times N)$ extra space), we can modify the input `grid` directly.
When we find a `'1'` (an unvisited part of an island):
1.  Increment our `islandCount`.
2.  Trigger a traversal (DFS or BFS) starting from this cell.
3.  During traversal, mark every connected `'1'` as `'0'` (turn land into water).
4.  This effectively "sinks" the entire island so we don't encounter it again in our main loop.
*Thay vì sử dụng mảng `visited` riêng biệt (tốn thêm không gian), chúng ta có thể sửa đổi trực tiếp `grid` đầu vào. Khi tìm thấy `'1'`, tăng đếm, kích hoạt duyệt, và đánh dấu mọi `'1'` kết nối thành `'0'` (biến đất thành nước). Điều này làm "chìm" toàn bộ hòn đảo.*

### Algorithm Steps
### *Các bước thuật toán*
1.  Loop through every cell `(i, j)` in the grid.
2.  If `grid[i][j] == '1'`:
    - `count++`
    - Call `DFS(i, j)` to sink the island.
3.  **DFS(i, j):**
    - Boundary checks: If `out of bounds` or `grid[i][j] == '0'`, return.
    - Set `grid[i][j] = '0'`.
    - Recursively call DFS for `(i+1, j)`, `(i-1, j)`, `(i, j+1)`, `(i, j-1)`.

---

## 3. Structural Advantages
## *3. Ưu điểm cấu trúc*

*   **Space Optimization:** By modifying the grid in-place, we reduce space complexity to the recursion stack depth (or BFS queue size), saving the allocation of a huge boolean matrix.
    *Tối ưu hóa không gian: Bằng cách sửa đổi lưới tại chỗ, chúng ta giảm độ phức tạp không gian xuống độ sâu ngăn xếp đệ quy.*
*   **Simple Logic:** The code structure is very cleaner compared to Union-Find data structures.
    *Logic đơn giản: Cấu trúc mã sạch sẽ hơn nhiều so với cấu trúc dữ liệu Union-Find.*

---

## 4. Complexity Analysis
## *4. Phân tích độ phức tạp*

*   **Time Complexity:** $O(M \times N)$. We visit each cell effectively twice (once in the loop, once in DFS).
    *Độ phức tạp thời gian: $O(M \times N)$.*
*   **Space Complexity:** $O(M \times N)$ in the worst case (if the entire grid is one big snake-like island, the recursion stack can go deep).
    *Độ phức tạp không gian: $O(M \times N)$ trong trường hợp xấu nhất.*

---

## 5. Visualized Dry Run
## *5. Chạy thử bằng hình ảnh*

**Input:**
```
1 1 0
1 0 0
0 0 1
```

1.  Loop finds `(0,0)` is `1`. Count = 1.
    - **DFS(0,0)** -> Sinks (0,0). Calls neighbors.
    - DFS(0,1) -> Sinks (0,1). Calls neighbors.
    - DFS(1,0) -> Sinks (1,0). Calls neighbors.
    - All connected 1s become 0.
2.  Grid becomes:
    ```
    0 0 0
    0 0 0
    0 0 1
    ```
3.  Loop continues... finds `(2,2)` is `1`. Count = 2.
    - **DFS(2,2)** -> Sinks (2,2).
4.  Grid is all 0s. Loop finishes.

**Result:** 2.

---

## 6. Summary Recommendation
## *6. Khuyến nghị tổng kết*

Number of Islands is THE standard graph traversal problem. DFS (Recursion) is usually preferred for its brevity. BFS (Queue) is preferred if you are worried about stack overflow on extremely large inputs. Union-Find is preferred if the grid is dynamic (adding lands allows merging islands in $O(\alpha(N))$). In an interview, stick to DFS sinking unless asked otherwise.
*Số lượng hòn đảo là bài toán duyệt đồ thị tiêu chuẩn NHẤT. DFS (Đệ quy) thường được ưa chuộng vì ngắn gọn. BFS (Hàng đợi) được dùng nếu lo ngại tràn ngăn xếp. Union-Find dùng khi lưới là động. Trong phỏng vấn, hãy bám sát chiến lược DFS đánh chìm trừ khi được yêu cầu khác.*
---
*Những hòn đảo dù tách biệt trên mặt nước nhưng có thể cùng chung một nền đáy biển đồ thị.*
Islands, though separated on the water surface, may share the same graph seabed.
