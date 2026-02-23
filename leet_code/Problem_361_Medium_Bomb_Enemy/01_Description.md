# Result for Bomb Enemy
# *Kết quả cho bài toán Đặt bom Kẻ địch*

## Description
## *Mô tả*

Given an `m x n` matrix `grid` where each cell is either a wall `'W'`, an enemy `'E'` or empty `'0'`, return the maximum enemies you can kill using one bomb.
*Cho một ma trận `m x n` `grid` trong đó mỗi ô là một bức tường `'W'`, một kẻ địch `'E'` hoặc trống `'0'`, hãy trả về số lượng kẻ địch tối đa bạn có thể tiêu diệt bằng một quả bom.*

The bomb kills all the enemies in the same row and column from the planted location until it hits the wall since it is too strong to be destroyed.
*Quả bom tiêu diệt tất cả kẻ địch trong cùng hàng và cột từ vị trí đặt cho đến khi chạm tường, vì nó quá mạnh để bị phá hủy.*

Note that you can only put the bomb at an empty cell.
*Lưu ý rằng bạn chỉ có thể đặt bom tại một ô trống.*

## Example 1:
## *Ví dụ 1:*

**Input:** `grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]`
**Output:** `3`
**Explanation:** 
For the given grid, placing a bomb at `(1,1)` kills 3 enemies.
- Row 1: `(1,0)` (enemy)
- Col 1: `(0,1)` and `(2,1)` (enemies)
The bomb cannot reach `(1,3)` because of the wall `'W'` at `(1,2)`.

## Constraints:
## *Ràng buộc:*

*   `m == grid.length`
*   `n == grid[i].length`
*   `1 <= m, n <= 500`
*   `grid[i][j]` is `'W'`, `'E'`, or `'0'`.
