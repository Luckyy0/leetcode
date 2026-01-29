# 959. Regions Cut By Slashes / Các vùng bị cắt bởi dấu gạch chéo

## Problem Description / Mô tả bài toán
An `n x n` grid is composed of 1x1 squares. Each square contains '/', '\', or a blank space. These slashes divide the squares into regions.
Một lưới `n x n` bao gồm các ô vuông 1x1. Mỗi ô vuông chứa '/', '\', hoặc một khoảng trắng. Những dấu gạch chéo này chia các ô vuông thành các vùng.

Return the total number of regions.
Hãy trả về tổng số vùng.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Grid Upscaling and BFS/DFS / Phóng to lưới và BFS/DFS
This is essentially a connected components problem.
Về cơ bản đây là bài toán về các thành phần kết nối.

Algorithm:
1. Represent each 1x1 square as a 3x3 block of mini-cells.
   - Blank: all 9 cells are reachable.
   - '/': cells (0,2), (1,1), (2,0) are blocked.
   - '\': cells (0,0), (1,1), (2,2) are blocked.
2. The total grid becomes `(3n) x (3n)`.
3. Count connected components of "reachable" (non-blocked) cells using BFS or DFS.

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2).

---

## Analysis / Phân tích

### Approach: High-Resolution Discretization
By blowing up each cell into a 3x3 sub-grid, we can precisely model the diagonal barriers as physical wall cells. This transforms the complex geometry of slashes into a simple "island counting" problem on a binary grid.
Bằng cách phóng to mỗi ô thành một lưới phụ 3x3, chúng ta có thể mô hình hóa chính xác các rào cản đường chéo dưới dạng các ô tường vật lý. Điều này chuyển đổi hình học phức tạp của các dấu gạch chéo thành một bài toán "đếm đảo" đơn giản trên một lưới nhị phân.

---
