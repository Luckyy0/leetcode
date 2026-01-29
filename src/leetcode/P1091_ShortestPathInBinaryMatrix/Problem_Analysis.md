# 1091. Shortest Path in Binary Matrix / Đường dẫn Ngắn nhất trong Ma trận Nhị phân

## Problem Description / Mô tả bài toán
Given an `n x n` binary matrix `grid`, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
Cho một ma trận nhị phân `n x n` `grid`, hãy trả về độ dài của đường dẫn trống ngắn nhất trong ma trận. Nếu không có đường dẫn trống, hãy trả về -1.

A clear path in a binary matrix is a path from the top-left cell to the bottom-right cell such that:
- All the visited cells of the path are 0.
- All the adjacent cells of the path are 8-directionally connected.

The length of a clear path is the number of visited cells of this path.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Breadth-First Search (BFS) / Tìm kiếm theo Chiều rộng (BFS)
Shortest path in unweighted graph -> BFS.
Graph nodes: cells `(r, c)`.
Edges: 8 directions.
Constraints: `grid[0][0]` and `grid[n-1][n-1]` must be 0.

Algorithm:
1. Check if `grid[0][0] != 0` or `grid[n-1][n-1] != 0` -> return -1.
2. Initialize Queue with `(0, 0, 1)` (row, col, distance).
3. Mark `(0, 0)` as visited (set to 1).
4. While queue not empty:
   - Poll `(r, c, dist)`.
   - If `(r, c) == (n-1, n-1)`, return `dist`.
   - For 8 neighbors:
     - If valid and `grid[nr][nc] == 0`:
       - `grid[nr][nc] = 1` (mark visited immediately).
       - Add to queue with `dist + 1`.
5. Return -1.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: 8-Directional BFS
Utilize Breadth-First Search to find the shortest path in the unweighted grid graph. Explore all 8 distinct neighbors level by level. Ensure to handle edge data (top-left or bottom-right being blocked) initially. Modifying the grid in-place to mark visited cells avoids extra space overhead.
Sử dụng Tìm kiếm theo Chiều rộng để tìm đường đi ngắn nhất trong đồ thị lưới không trọng số. Khám phá tất cả 8 hàng xóm riêng biệt theo từng cấp. Đảm bảo xử lý dữ liệu cạnh (trên cùng bên trái hoặc dưới cùng bên phải bị chặn) ngay từ đầu. Sửa đổi lưới tại chỗ để đánh dấu các ô đã truy cập sẽ tránh tốn thêm dung lượng.

---
