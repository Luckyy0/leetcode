# 1210. Minimum Moves to Reach Target with Rotations / Số bước Di chuyển Tối thiểu để Đạt Mục tiêu với Xoay

## Problem Description / Mô tả bài toán
Grid `n x n`. Start state: Snake occupies `(0,0)` and `(0,1)`. Horizontal.
Target: Snake occupies `(n-1, n-2)` and `(n-1, n-1)`. Horizontal.
Moves:
- Move right.
- Move down.
- Rotate clockwise (if horizontal and cells below both empty).
- Rotate counter-clockwise (if vertical and cells right both empty).
Find min moves.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / State Space Search / Tìm kiếm Không gian Trạng thái
State: `(r, c, orientation)`. `(r, c)` is the tail (top-leftmost cell).
Orientation: 0 for horizontal (tail at `(r,c)`, head at `(r, c+1)`), 1 for vertical (tail at `(r,c)`, head at `(r+1, c)`).
Transitions:
1. Right:
   - Horiz: check `(r, c+2)` empty. New: `(r, c+1, 0)`.
   - Vert: check `(r, c+1)` and `(r+1, c+1)` empty. New: `(r, c+1, 1)`.
2. Down:
   - Horiz: check `(r+1, c)` and `(r+1, c+1)` empty. New: `(r+1, c, 0)`.
   - Vert: check `(r+2, c)` empty. New: `(r+1, c, 1)`.
3. Rotate CW (0 -> 1):
   - Needs `(r+1, c)` and `(r+1, c+1)` clear. Pivot is tail `(r, c)`.
   - New: `(r, c, 1)`.
4. Rotate CCW (1 -> 0):
   - Needs `(r, c+1)` and `(r+1, c+1)` clear. Pivot is tail `(r, c)`.
   - New: `(r, c, 0)`.

Use BFS to find shortest path.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: BFS on Snake States
The snake's state is defined by the position of its tail `(row, col)` and its orientation (Horizontal or Vertical). Perform a BFS starting from `(0, 0, Horizontal)`. At each step, explore valid moves (Right, Down, Rotate Clockwise, Rotate Counter-Clockwise) based on grid boundaries and obstacles. Use a `visited` array `[N][N][2]` to avoid redundant processing. The target state is `(N-1, N-2, Horizontal)`.
Trạng thái của con rắn được xác định bởi vị trí đuôi của nó `(row, col)` và hướng của nó (Ngang hoặc Dọc). Thực hiện BFS bắt đầu từ `(0, 0, Ngang)`. Ở mỗi bước, khám phá các bước đi hợp lệ (Phải, Xuống, Xoay theo chiều kim đồng hồ, Xoay ngược chiều kim đồng hồ) dựa trên ranh giới lưới và chướng ngại vật. Sử dụng mảng `visited` `[N][N][2]` để tránh xử lý dư thừa. Trạng thái mục tiêu là `(N-1, N-2, Ngang)`.

---
