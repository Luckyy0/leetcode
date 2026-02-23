# Result for Max Area of Island
# *Kết quả cho bài toán Diện tích Đảo lớn nhất*

## Description
## *Mô tả*

You are given an `m x n` binary matrix `grid`. An island is a group of `1`s (representing land) connected **4-directionally** (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
*Bạn được cho một ma trận nhị phân `grid` kích thước `m x n`. Một hòn đảo là một nhóm các số `1` (đại diện cho đất liền) được kết nối theo **4 hướng** (ngang hoặc dọc). Bạn có thể giả định rằng cả bốn cạnh của lưới đều được bao quanh bởi nước.*

The **area** of an island is the number of cells with value `1` in the island.
* **Diện tích** của một hòn đảo là số lượng các ô có giá trị `1` trong hòn đảo đó.*

Return the maximum area of an island in `grid`. If there is no island, return `0`.
*Hãy trả về diện tích lớn nhất của một hòn đảo trong `grid`. Nếu không có hòn đảo nào, hãy trả về `0`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
**Output:** 6

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[0,0,0,0,0,0,0,0]]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 50`
*   `grid[i][j]` is either `0` or `1`.
