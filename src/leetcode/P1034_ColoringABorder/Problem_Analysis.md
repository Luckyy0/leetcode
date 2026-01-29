# 1034. Coloring A Border / Tô màu Viền

## Problem Description / Mô tả bài toán
You are given an `m x n` integer matrix `grid`, and three integers `row`, `col`, and `color`.
Each value in the grid represents the color of the square.
Mỗi giá trị trong lưới đại diện cho màu của ô vuông.

Change the color of the **border** of the connected component that contains the square `grid[row][col]`.
Thay đổi màu của **viền** của thành phần liên thông chứa ô vuông `grid[row][col]`.

The border of a connected component is all cells in the component that are either on the boundary of the grid or adjacent to a square not in the component.
Viền của một thành phần liên thông là tất cả các ô trong thành phần nằm trên biên của lưới hoặc liền kề với một ô vuông không nằm trong thành phần đó.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS / BFS for Connected Components / DFS / BFS cho Thành phần Liên thông
Algorithm:
1. Identify the `initialColor`.
2. Perform DFS/BFS from `(row, col)` to traverse the full component of `initialColor`.
3. During traversal, check if a cell is a border cell.
   - Border if `r==0`, `r==m-1`, `c==0`, `c==n-1`.
   - OR if neighbor has different color (need to distinguish between original different color and already colored border). Use a `visited` array.
4. If it is a border, mark it for coloring.
5. Apply the new color to marked border cells.

### Complexity / Độ phức tạp
- **Time**: O(M * N).
- **Space**: O(M * N).

---

## Analysis / Phân tích

### Approach: Boundary Identification within Component
Traverse the connected region of uniform color. For every cell in this region, inspect its surroundings. If any neighbor (orthogonal) falls outside the region (either out of bounds or a different color), the cell is essentially a "perimeter" pixel and should be recolored.
Duyệt qua vùng liên thông có màu đồng nhất. Đối với mỗi ô trong vùng này, hãy kiểm tra môi trường xung quanh nó. Nếu bất kỳ hàng xóm nào (trực giao) nằm ngoài vùng (hoặc ngoài giới hạn hoặc có màu khác), ô đó về cơ bản là một pixel "chu vi" và cần được tô màu lại.

---
