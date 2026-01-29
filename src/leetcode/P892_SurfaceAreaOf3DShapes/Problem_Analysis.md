# 892. Surface Area of 3D Shapes / Diện tích Bề mặt các Khối 3D

## Problem Description / Mô tả bài toán
You are given an `n x n` grid representing the height of cubes. Return the total surface area.
Bạn được cấp một lưới `n x n` đại diện cho độ cao của các khối lập phương. Hãy trả về tổng diện tích bề mặt.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Surface Subtraction / Trừ diện tích tiếp xúc
Total surface area if all cubes were independent: `sum(heights) * 6`.
But cubes touch each other.

For each cell `(r, c)` with `h = grid[r][c]`:
1. If `h > 0`, it has top and bottom surfaces: `+2`.
2. It has 4 sides: `+ 4 * h`.
3. Subtract contact surfaces with neighbors:
   - Subtract `2 * min(h, neighbors_h)` for each adjacent pair (to avoid double counting, check only right and down).
   - Alternatively: for each cell, subtract `min(h, neighbors_h)` for all 4 neighbors.
   - Also, cubes in a stack touch: `(h - 1)` internal horizontal contacts, each hiding 2 surfaces. Total internal hiding: `2 * (h - 1)`.

Total Area = `sum(2 + 4*h - internal_hiding)` for all cells, then subtract horizontal neighbor contacts.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Add and Prune
Calculate the raw surface of each stack (top, bottom, and total outer vertical surface). Then, decrement the area for every point of contact where adjacent stacks "hide" each other's faces.
Tính diện tích thô của mỗi chồng (mặt trên, mặt dưới và tổng diện tích mặt đứng bên ngoài). Sau đó, giảm diện tích cho mọi điểm tiếp xúc nơi các chồng kề nhau "che" các mặt của nhau.

---
