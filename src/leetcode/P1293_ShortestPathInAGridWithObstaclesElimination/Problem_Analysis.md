# 1293. Shortest Path in a Grid with Obstacles Elimination / Đường đi Ngắn nhất trong Lưới với Loại bỏ Chướng ngại vật

## Problem Description / Mô tả bài toán
`m x n` grid. `k` obstacles can be eliminated.
Shortest path from `(0, 0)` to `(m-1, n-1)`.
Moves: UDLR. Step cost 1.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with State
State: `(row, col, remaining_k)`.
`visisted[row][col]` stores max `remaining_k` seen so far.
If we reach `(row, col)` with `k'` and previously reached with `k'' > k'`, current path is worse (same position, less elimination power).
Only process if `current_k > visited[row][col]`.
Actually, BFS guarantees shortest distance (steps).
So state needs `visited[row][col][rem_k]`. Or optimize: `visited[row][col]` = max `rem_k`. If we arrive with `curr_k <= visited[row][col]`, drop it.
(Because if we reached here before with more or equal `k`, we were faster or equal speed).

### Complexity / Độ phức tạp
- **Time**: O(M * N * K).
- **Space**: O(M * N * K) or O(M * N) with optimized visited.

---

## Analysis / Phân tích

### Approach: BFS with K-check
Use Breadth-First Search since edge weights are uniform (1). The state needs to include the remaining number of obstacles we can eliminate. `State: (row, col, k)`.
Maintain a `visited` array (or `max_k_at_pos[row][col]`) to prune states. If we arrive at `(r, c)` with `k` obstacles remaining, and we previously visited `(r, c)` with `k'` remaining where `k' >= k`, we should skip the current state (since the previous path was shorter or same length, and had more or equal elimination potential).
Initialize `visited` with -1.
Target is `(m-1, n-1)`.
Sử dụng BFS vì trọng số cạnh là chẵn (1). Trạng thái cần bao gồm số lượng chướng ngại vật còn lại mà chúng ta có thể loại bỏ. `State: (row, col, k)`.
Duy trì mảng `visited` (hoặc `max_k_at_pos[row][col]`) để cắt tỉa trạng thái. Nếu chúng ta đến `(r, c)` với `k` chướng ngại vật còn lại, và trước đó chúng ta đã truy cập `(r, c)` với `k'` còn lại trong đó `k' >= k`, chúng ta nên bỏ qua trạng thái hiện tại (vì đường dẫn trước đó ngắn hơn hoặc có cùng độ dài, và có tiềm năng loại bỏ nhiều hơn hoặc bằng).
Khởi tạo `visited` với -1. Đích là `(m-1, n-1)`.

---
