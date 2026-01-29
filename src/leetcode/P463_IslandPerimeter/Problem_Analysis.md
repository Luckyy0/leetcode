# 463. Island Perimeter / Chu Vi Hòn Đảo

## Problem Description / Mô tả bài toán
You are given `grid`, an `row x col` matrix representing a map where `grid[i][j] = 1` represents land and `grid[i][j] = 0` represents water.
Bạn được cho một ma trận `grid` kích thước `row x col` đại diện cho một bản đồ, trong đó `grid[i][j] = 1` đại diện cho đất và `grid[i][j] = 0` đại diện cho nước.

Grid cells are connected **horizontally/vertically** (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
Các ô trong mạng lưới được kết nối **theo chiều ngang/dọc** (không phải đường chéo). Mạng lưới hoàn toàn được bao quanh bởi nước và có đúng một hòn đảo.

Determine the perimeter of the island.
Hãy xác định chu vi của hòn đảo.

### Example 1:
```text
Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
```

### Example 2:
```text
Input: grid = [[1]]
Output: 4
```

## Constraints / Ràng buộc
- `row == grid.length`
- `col == grid[i].length`
- `1 <= row, col <= 100`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cell Adjacency Analysis / Phân tích sự liền kề của các ô
Each land cell (`1`) has 4 possible edges.
For each land cell:
1. Every edge that borders water or the grid boundary contributes `1` to the perimeter.
2. Alternatively, every edge that borders another land cell reduces the potential perimeter by `1`.

Algorithm:
1. Initialize `islands = 0` and `neighbors = 0`.
2. Iterate through each cell in the grid.
3. If the cell is a land cell (`grid[i][j] == 1`):
   - Increment `islands`.
   - Check if the cell below is also land: `i < row - 1 && grid[i+1][j] == 1`. If yes, increment `neighbors`.
   - Check if the cell to the right is also land: `j < col - 1 && grid[i][j+1] == 1`. If yes, increment `neighbors`.
4. The total perimeter is `islands * 4 - neighbors * 2`. (Each neighbor edge is shared by two land cells, so we subtract 2).

### Complexity / Độ phức tạp
- **Time**: O(R * C) where R is rows and C is columns.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan with Shared Edge Counting

**Algorithm**:
1.  Iterate and count land cells.
2.  Count shared edges (down and right only to avoid double counting).
3.  Calculate `4*Land - 2*Shared`.

---
