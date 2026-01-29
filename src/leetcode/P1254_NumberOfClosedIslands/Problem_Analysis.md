# 1254. Number of Closed Islands / Số lượng Đảo Đóng

## Problem Description / Mô tả bài toán
Grid with 0 (land) and 1 (water).
Closed island is land totally surrounded by 1s (left, top, right, bottom).
Land on the edge of grid is NOT closed (can walk off grid).
Count closed islands.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / BFS Flood Fill
Iterate all cells. If cell is 0 and not visited:
- Start traversal.
- Track if traversal touches boundary.
- If it does NOT touch boundary, it's a closed island.
Optimization: First traverse all 0s connected to boundary and mark them visited (or as non-island).
Then count remaining components of 0s.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) recursion.

---

## Analysis / Phân tích

### Approach: Boundary Flood Fill
First, perform a flood fill (DFS or BFS) starting from all land cells (`0`) located on the boundary of the grid. Mark these cells (and any land connected to them) as visited or change them to water (`1`), effectively removing any "open" islands. After this preprocessing, iterate through the internal cells of the grid. Any remaining unvisited land cell (`0`) must belong to a "closed" island. Increment the count and flood fill to remove the entire component.
Đầu tiên, thực hiện flood fill (DFS hoặc BFS) bắt đầu từ tất cả các ô đất (`0`) nằm trên ranh giới của lưới. Đánh dấu các ô này (và bất kỳ vùng đất nào được kết nối với chúng) là đã truy cập hoặc thay đổi chúng thành nước (`1`), xóa hiệu quả bất kỳ hòn đảo "mở" nào. Sau quá trình xử lý trước này, hãy lặp lại qua các ô bên trong của lưới. Bất kỳ ô đất (`0`) nào chưa được truy cập còn lại đều phải thuộc về một hòn đảo "đóng". Tăng số đếm và flood fill để loại bỏ toàn bộ thành phần.

---
