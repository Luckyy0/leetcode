# 1391. Check if There is a Valid Path in a Grid / Kiểm tra xem Có Đường dẫn Hợp lệ trong Lưới hay không

## Problem Description / Mô tả bài toán
Grid `m x n` with streets.
Street types:
1: Left-Right
2: Up-Down
3: Left-Down
4: Down-Right
5: Left-Up
6: Up-Right
Check if path exists from (0,0) to (m-1, n-1).
Must follow directions.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### BFS / DFS
Nodes are cells `(r, c)`.
Edges defined by street types.
A valid move means:
- Current cell `(r, c)` has a street connecting to `next`.
- Next cell `(nr, nc)` has a street connecting back to `current`.
Example: Move Right from Type 1 (L-R) works if next cell is Type 1, 3, 5 (needs L connection).
Use BFS or DFS to check reachability.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: BFS with Connectivity Check
Define the connectivity rules for each street type.
Directions: Right, Left, Down, Up.
For each direction, check if current type supports it AND if next cell's type supports the reverse direction (receiving connection).
Example: Moving Right is valid IF:
- Current is 1, 4, 6.
- Next is 1, 3, 5.
Use BFS to traverse from `(0, 0)`. If we reach `(m-1, n-1)`, return true.
Xác định quy tắc kết nối cho từng loại đường phố.
Hướng: Phải, Trái, Xuống, Lên.
Đối với mỗi hướng, kiểm tra xem loại hiện tại có hỗ trợ nó hay không VÀ loại ô tiếp theo có hỗ trợ hướng ngược lại (nhận kết nối) hay không.
Ví dụ: Di chuyển sang Phải là hợp lệ NẾU:
- Hiện tại là 1, 4, 6.
- Tiếp theo là 1, 3, 5.
Sử dụng BFS để duyệt từ `(0, 0)`. Nếu chúng ta đến `(m-1, n-1)`, trả về true.

---
