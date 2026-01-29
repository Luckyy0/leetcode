# 1020. Number of Enclaves / Số lượng Vùng nằm trong

## Problem Description / Mô tả bài toán
You are given an `m x n` binary matrix `grid`, where `0` represents a sea cell and `1` represents a land cell.
Bạn được cho một ma trận nhị phân `m x n` `grid`, trong đó `0` đại diện cho ô biển và `1` đại diện cho ô đất liền.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the `grid`.
Một bước di chuyển bao gồm việc đi bộ từ một ô đất liền sang một ô đất liền lân cận (4 hướng) hoặc đi ra khỏi biên của `grid`.

Return the number of land cells in `grid` for which we cannot walk off the boundary of the grid in any number of moves.
Hãy trả về số lượng ô đất liền trong `grid` mà chúng ta không thể đi ra khỏi biên của lưới sau bất kỳ số bước di chuyển nào.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Boundary Flood Fill (DFS/BFS) / Loang Biên (DFS/BFS)
Any land cell connected to the boundary can walk off.
Bất kỳ ô đất liền nào kết nối với biên đều có thể đi ra ngoài.
Any land cell NOT connected to the boundary is an enclave.

Algorithm:
1. Iterate over all boundary cells (first row, last row, first col, last col).
2. If a boundary cell is `1`, perform DFS/BFS to mark all reachable land cells (e.g., change `1` to `0` or `2`).
3. After processing boundaries, iterate over the entire grid.
4. Count remaining `1`s. These are the enclaves.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N) for recursion stack or queue.

---

## Analysis / Phân tích

### Approach: Perimeter Erosion
Identify all land masses connected to the grid's edge. By initiating flood-fill traversals from every boundary land cell, we effectively "sink" or mark all land capable of reaching the outside world. The remaining, untouched land cells are the isolated enclaves.
Xác định tất cả các khối đất liền kết nối với rìa của lưới. Bằng cách bắt đầu các lượt duyệt loang từ mọi ô đất liền ở biên, chúng ta "nhấn chìm" hoặc đánh dấu hiệu quả tất cả đất đai có khả năng tiếp cận thế giới bên ngoài. Các ô đất liền còn lại, chưa được xử lý là các vùng đất biệt lập.

---
