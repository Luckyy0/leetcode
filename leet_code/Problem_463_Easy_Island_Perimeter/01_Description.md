# Result for Island Perimeter
# *Kết quả cho bài toán Chu vi Đảo*

## Description
## *Mô tả*

You are given `row x col` `grid` representing a map where `grid[i][j] = 1` represents land and `grid[i][j] = 0` represents water.
*Bạn được cho một ma trận `grid` kích thước `row x col` đại diện cho một bản đồ, trong đó `grid[i][j] = 1` đại diện cho đất liền và `grid[i][j] = 0` đại diện cho nước.*

Grid cells are connected **horizontally/vertically** (not diagonally). The `grid` is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
*Các ô trong lưới được kết nối theo **chiều ngang/chiều dọc** (không phải đường chéo). Lưới được bao quanh hoàn toàn bởi nước, và có đúng một hòn đảo (tức là một hoặc nhiều ô đất liền kết nối với nhau).*

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*Hòn đảo không có "hồ", nghĩa là nước bên trong không kết nối với nước xung quanh đảo. Mỗi ô là một hình vuông có độ dài cạnh bằng 1. Lưới có hình chữ nhật, chiều rộng và chiều cao không quá 100. Hãy xác định chu vi của hòn đảo.*

## Example 1:
## *Ví dụ 1:*

**Input:** `grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]`
**Output:** `16`

## Example 2:
## *Ví dụ 2:*

**Input:** `grid = [[1]]`
**Output:** `4`

## Example 3:
## *Ví dụ 3:*

**Input:** `grid = [[1,0]]`
**Output:** `4`

## Constraints:
## *Ràng buộc:*

*   `row == grid.length`
*   `col == grid[i].length`
*   `1 <= row, col <= 100`
*   `grid[i][j]` is `0` or `1`.
*   There is exactly one island in `grid`.
