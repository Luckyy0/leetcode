# Analysis for Bricks Falling When Hit
# *Phân tích cho bài toán Gạch rơi khi bị va chạm*

## 1. Problem Essence & Connectivity
## *1. Bản chất vấn đề & Tính kết nối*

### The Challenge
### *Thách thức*
We need to track how removing a brick affects the connectivity of other bricks to the top row.
Doing this forward (hitting one by one) is hard because one hit can disconnect a large component. Recalculating everything is $O(H \cdot (M \times N))$. 
$4 \cdot 10^4 \cdot 4 \cdot 10^4 = 1.6 \cdot 10^9$, likely too slow.
*Chúng ta cần theo dõi việc xóa gạch ảnh hưởng thế nào đến kết nối với đỉnh. Làm theo chiều thuận rất khó vì một lần đập có thể làm rơi nhiều gạch, tính lại toàn bộ mảng mất rất nhiều thời gian.*

### Key Insight: Reverse the Process
### *Ý tưởng chính: Đảo ngược quy trình*
Instead of breaking bricks, we "add" them back in reverse order of the hits.
Adding a brick to a component and checking if it connects to the top is a Disjoint Set Union (DSU) problem.
*Thay vì phá gạch, ta "thêm" gạch lại theo thứ tự ngược của các lần đập. Thêm gạch vào một tập hợp và kiểm tra xem có nối với đỉnh không là bài toán DSU.*

---

## 2. Strategy: DSU in Reverse
## *2. Chiến lược: DSU đảo ngược*

### Algorithm
### *Thuật toán*

1.  **Preparation:**
    - Mark all bricks in `grid` that will be hit as 0 (but remember if they were originally 1).
    - Let `tempGrid` be the state after ALL hits.
    *   **Chuẩn bị:** Đánh dấu tất cả gạch bị đập thành 0. `tempGrid` là trạng thái sau khi tất cả các lần đập đã xảy ra.*

2.  **Initial Connectivity:**
    - Create a DSU representing `tempGrid`.
    - Nodes `0` to `M*N-1` represent grid cells.
    - One special node `TOP` (index `M*N`) represents the roof.
    - Connect bricks in row 0 to `TOP`.
    - Connect adjacent bricks in `tempGrid`.
    *   **Kết nối ban đầu:** Tạo DSU. Một nút đặc biệt `TOP` đại diện cho trần. Nối gạch hàng 0 với `TOP`. Nối các gạch kề nhau trong `tempGrid`.*

3.  **Process Hits in Reverse:**
    - For each hit $(r, c)$ in reverse order:
      - If it wasn't a brick originally, skip.
      - Before adding brick $(r, c)$, count how many bricks were connected to `TOP` (call it `oldCount`).
      - Restore brick: `grid[r][c] = 1`. Connect to neighbors. If $r=0$, connect to `TOP`.
      - After adding, count bricks connected to `TOP` (call it `newCount`).
      - Falling bricks = `max(0, newCount - oldCount - 1)`. (-1 because we don't count the brick we just restored).
    *   **Xử lý ngược:** Với mỗi lần đập theo thứ tự ngược: Nếu ban đầu có gạch, đếm số gạch nối với `TOP` trước khi thêm. Thêm gạch lại, đếm số gạch nối với `TOP` sau khi thêm. Số gạch rơi = `newCount - oldCount - 1`.*

---

## 3. Complexity Analysis
## *3. Phân tích độ phức tạp*

*   **Time Complexity:** $O((M \cdot N + H) \cdot \alpha(M \cdot N))$, where $\alpha$ is the Inverse Ackermann function.
    *   **Độ phức tạp thời gian:** $O((M \cdot N + H) \cdot \alpha(M \cdot N))$.*
*   **Space Complexity:** $O(M \cdot N)$ for DSU and grid copies.
    *   **Độ phức tạp không gian:** $O(M \cdot N)$.*

---

## 4. Visualized Dry Run
## *4. Chạy thử bằng Hình ảnh*

**Grid:** `[[1,0,0,0],[1,1,1,0]]`, **Hits:** `[[1,0]]`
1. Rem brick at (1,0). Grid becomes `[[1,0,0,0],[0,1,1,0]]`.
2. Initial DSU: (0,0) conn to TOP. (1,1)-(1,2) conn but NOT to TOP.
   `TOP` component size: 1 (only (0,0)).
3. Reverse Hit (1,0):
   - Add (1,0). Neighbors: (0,0) and (1,1).
   - Union((1,0), (0,0)), Union((1,0), (1,1)).
   - Now TOP conn to (0,0), (1,0), (1,1), (1,2).
   - New size: 4.
   - Fall = $4 - 1 - 1 = 2$.
**Result:** [2].

---

## 5. Summary Recommendation
## *5. Khuyến nghị Tổng kết*

Working backward using DSU is the standard technique for "Connectivity change" problems where things are deleted. Adding is much easier.
*Làm ngược sử dụng DSU là kỹ thuật tiêu chuẩn cho các bài toán thay đổi kết nối khi có vật bị xóa.*
