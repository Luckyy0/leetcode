# 1197. Minimum Knight Moves / Di chuyển Mã Tối thiểu

## Problem Description / Mô tả bài toán
In an infinite chess board with coordinates from -infinity to +infinity, you start at square `[0, 0]`.
Find min moves to reach `[x, y]`.
Target can be negative. But board is symmetrical. We can use `abs(x), abs(y)`.
In infinite board, BFS works.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS with Symmetry / Pruning / BFS với Đối xứng / Cắt tỉa
Symmetry: `f(x, y) = f(|x|, |y|)`.
Also `f(x, y) = f(y, x)`.
So target is `(abs(x), abs(y))`.
Limit search space: Since knight moves 2+1, we don't need to go far beyond target bounds. `Range: [-2, x+2]`.
Optimization: Bidirectional BFS? Or regular BFS with restricted bounds.
Bounds: `visited` set. If `currX > targetX + 4` or `currY > targetY + 4`, likely too far? Actually, just restrict to positive quadrant + slight buffer region (e.g. -2 to x+2) because optimal path might slightly go back or negative to jump forward optimally.
Actually simple BFS with `Set<String> visited` is fine if we limit search space roughly.

### Complexity / Độ phức tạp
- **Time**: O(max(|x|, |y|)). Knight moves cover distance efficiently.
- **Space**: O(max(|x|, |y|)^2) visited.

---

## Analysis / Phân tích

### Approach: Symmetric BFS
Leverage symmetry to handle only the first quadrant (`x = abs(x), y = abs(y)`). Run a standard BFS from `(0, 0)` to `(x, y)`. To optimize, constrain the search area; we only need to explore coordiantes within `[-2, x+2]` and `[-2, y+2]` because moving significantly outside the target's bonding box is suboptimal, though small detours (like moving to regular negative coordinates momentarily) can be part of an optimal path. A `visited` set prevents cycles.
Tận dụng tính đối xứng để chỉ xử lý góc phần tư thứ nhất (`x = abs(x), y = abs(y)`). Chạy BFS tiêu chuẩn từ `(0, 0)` đến `(x, y)`. Để tối ưu hóa, hãy hạn chế khu vực tìm kiếm; chúng ta chỉ cần khám phá các tọa độ trong `[-2, x+2]` và `[-2, y+2]` vì di chuyển đáng kể ra ngoài hộp giới hạn của mục tiêu là không tối ưu, mặc dù các đường vòng nhỏ (như di chuyển đến tọa độ âm thông thường trong giây lát) có thể là một phần của đường đi tối ưu. Tập hợp `visited` ngăn chặn các chu kỳ.

---
