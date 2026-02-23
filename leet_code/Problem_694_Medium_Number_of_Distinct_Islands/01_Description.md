# Result for Number of Distinct Islands
# *Kết quả cho bài toán Số lượng Đảo phân biệt*

## Description
## *Mô tả*

You are given an `m x n` binary matrix `grid`. An island is a group of `1`s (representing land) connected **4-directionally** (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
*Bạn được cho một ma trận nhị phân `grid` kích thước `m x n`. Một hòn đảo là một nhóm các số `1` (đại diện cho đất liền) được kết nối theo **4 hướng** (ngang hoặc dọc). Bạn có thể giả định rằng cả bốn cạnh của lưới đều được bao quanh bởi nước.*

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
*Một hòn đảo được coi là giống với hòn đảo khác khi và chỉ khi một hòn đảo có thể được tịnh tiến (không được xoay hoặc lật) để trở nên giống hệt hòn đảo kia.*

Return the number of **distinct** islands.
*Hãy trả về số lượng các hòn đảo **phân biệt**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
**Output:** 1

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
**Output:** 3

---

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 50`
*   `grid[i][j]` is either `0` or `1`.
