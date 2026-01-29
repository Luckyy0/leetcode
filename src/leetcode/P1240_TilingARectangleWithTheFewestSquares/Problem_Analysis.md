# 1240. Tiling a Rectangle with the Fewest Squares / Lát Hình chữ nhật với Ít Hình vuông Nhất

## Problem Description / Mô tả bài toán
Tile rectangle `n x m` with minimum number of integer-sided squares.
Return min number.
Constraints: n, m <= 13.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backtracking with Pruning / Quay lui với Cắt tỉa
Since N, M are very small (<= 13), we can use backtracking.
Fill the grid cell by cell (find first empty cell).
Try placing squares of size `k` (max possible size at that position).
Recursively solve.
Optimization (Skyline / Bitmask):
Represent state by the "height profile" of the filled area.
The "first empty cell" corresponds to a "valley" in the skyline.
Try filling the valley.
Pruning: if `current_count >= best_count`, stop.
Special cases? Hardcoded answers or specific edge case patterns (e.g., 11x13 is tricky, requires a central square).
Backtracking finds it if correct.

### Complexity / Độ phức tạp
- **Time**: Exponential but small bounds.
- **Space**: O(N*M).

---

## Analysis / Phân tích

### Approach: Backtracking with Board State
Use DFS to place squares. Maintain the state of the board (occupied cells). At each step, locate the top-leftmost empty cell `(r, c)`. Try placing squares of size `k` at `(r, c)` where `k` ranges from the maximum possible size down to 1. Recurse. Keep track of the minimum count found (`res`). Prune branches where the current count exceeds the best `res`.
Sử dụng DFS để đặt các hình vuông. Duy trì trạng thái của bảng (các ô bị chiếm). Ở mỗi bước, xác định vị trí ô trống trên cùng bên trái `(r, c)`. Thử đặt các hình vuông kích thước `k` tại `(r, c)` trong đó `k` nằm trong khoảng từ kích thước tối đa có thể xuống 1. Đệ quy. Theo dõi số lượng tối thiểu được tìm thấy (`res`). Cắt tỉa các nhánh mà số lượng hiện tại vượt quá `res` tốt nhất.

---
