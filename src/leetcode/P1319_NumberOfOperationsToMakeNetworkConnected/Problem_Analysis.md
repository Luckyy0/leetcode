# 1319. Number of Operations to Make Network Connected / Số lần Thao tác để Kết nối Mạng

## Problem Description / Mô tả bài toán
`n` computers, `connections` array.
Min operations to connect all computers.
Operation: remove cable between two connected computers, add it elsewhere.
If impossible (not enough cables), return -1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Graph Connectivity / Union-Find / DFS
1. Count total cables. If `cables < n - 1`, impossible (need `n-1` edges for tree). Return -1.
2. Find number of connected components `k`.
3. We need `k - 1` cables to connect `k` components.
   - Since we have enough total cables (condition 1), we definitely have redundant cables within components to move.
   - Specifically, if `edges >= n-1`, redundant edges = `edges - (n - k)`.
   - We just need check redundancy sufficiency?
   - Actually, if `edges >= n-1`, we ALWAYS can connect. The number of moves is just `k - 1`.
   - Why? Each component is a connected graph. A connected graph with `v` vertices has at least `v-1` edges. Excess edges are cycles.
   - We need to bridge `k` components. Need `k-1` edges.
   - Total edges needed = `(n - k) + (k - 1) = n - 1`.
   - If we have >= `n-1` edges, we can do it.
   - Moves = `k - 1`.

### Complexity / Độ phức tạp
- **Time**: O(N + E).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Connected Components Counting
First, check if the total number of connections is less than `n - 1`. If so, it is impossible to connect all computers, so return -1.
Otherwise, find the number of connected components `k` in the graph using DFS, BFS, or Union-Find. The minimum number of operations required is `k - 1` (we need `k - 1` cables to bridge `k` components, and we are guaranteed to have enough redundant cables because `total edges >= n - 1`).
Đầu tiên, kiểm tra xem tổng số kết nối có nhỏ hơn `n - 1` hay không. Nếu vậy, không thể kết nối tất cả các máy tính, vì vậy hãy trả về -1.
Nếu không, hãy tìm số lượng các thành phần được kết nối `k` trong đồ thị bằng DFS, BFS hoặc Union-Find. Số lượng thao tác tối thiểu cần thiết là `k - 1` (chúng ta cần `k - 1` cáp để nối `k` thành phần, và chúng ta được đảm bảo có đủ cáp thừa vì `total edges >= n - 1`).

---
