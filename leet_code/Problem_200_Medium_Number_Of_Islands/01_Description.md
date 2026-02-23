# Result for Number of Islands
# *Kết quả cho bài toán Số lượng hòn đảo*

## Description
## *Mô tả*

Given an `m x n` 2D binary grid `grid` which represents a map of `'1'`s (land) and `'0'`s (water), return *the number of islands*.
*Cho một lưới nhị phân 2D `grid` kích thước `m x n` đại diện cho bản đồ gồm các `'1'` (đất liền) và `'0'` (nước), hãy trả về *số lượng hòn đảo***.*

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*Một **hòn đảo** được bao quanh bởi nước và được hình thành bằng cách nối các vùng đất liền kề theo chiều ngang hoặc chiều dọc. Bạn có thể giả định rằng cả bốn cạnh của lưới đều được bao quanh bởi nước.*

## Example 1:
## *Ví dụ 1:*

**Input:**
```
grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
```
**Output:** `1`

## Example 2:
## *Ví dụ 2:*

**Input:**
```
grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
```
**Output:** `3`

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 300`
*   `grid[i][j]` is `'0'` or `'1'`.
