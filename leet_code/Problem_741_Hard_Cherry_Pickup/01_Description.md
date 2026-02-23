# Result for Cherry Pickup
# *Kết quả cho bài toán Nhặt Cherry (Cherry Pickup)*

## Description
## *Mô tả*

You are given an `n x n` `grid` representing a field of cherries, each cell is one of the following:
*Bạn được cho một lưới `n x n` đại diện cho một cánh đồng cherry, mỗi ô là một trong các loại sau:*

*   `0` means the cell is empty, so you can pass through.
    *   *`0` nghĩa là ô trống, bạn có thể đi qua.*
*   `1` means the cell contains a cherry, that you can pick up and pass through.
    *   *`1` nghĩa là ô chứa một quả cherry, bạn có thể nhặt và đi qua.*
*   `-1` means the cell contains a thorn that blocks your way.
    *   *`-1` nghĩa là ô chứa gai chặn đường bạn.*

Your task is to collect maximum number of cherries possible by following the rules below:
*Nhiệm vụ của bạn là thu thập số lượng cherry lớn nhất có thể bằng cách tuân theo các quy tắc sau:*

*   Starting at the position `(0, 0)` and reaching `(n - 1, n - 1)` by moving right or down through valid path cells (cells with value `0` or `1`).
    *   *Bắt đầu tại vị trí `(0, 0)` và đi đến `(n - 1, n - 1)` bằng cách di chuyển sang phải hoặc xuống dưới qua các ô hợp lệ (ô có giá trị `0` hoặc `1`).*
*   After reaching `(n - 1, n - 1)`, returning to `(0, 0)` by moving left or up through valid path cells.
    *   *Sau khi đến `(n - 1, n - 1)`, quay trở lại `(0, 0)` bằng cách di chuyển sang trái hoặc lên trên qua các ô hợp lệ.*
*   When passing through a path cell containing a cherry, you pick it up, and the cell becomes an empty cell (`0`).
    *   *Khi đi qua ô chứa cherry, bạn nhặt nó lên và ô đó trở thành ô trống (`0`).*
*   If there is no valid path between `(0, 0)` and `(n - 1, n - 1)`, then no cherries can be collected.
    *   *Nếu không có đường đi hợp lệ nào giữa `(0, 0)` và `(n - 1, n - 1)`, thì không thể thu thập được cherry nào.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** grid = [[0,1,-1],[1,0,-1],[1,1,1]]
**Output:** 5
**Explanation:** 
The player started at (0, 0) and went down, down, right right to reach (2, 2).
4 cherries were picked up.
The player started at (2, 2) and went left, up, up, left to reach (0, 0).
1 cherry was picked up.
Total cherries picked up = 4 + 1 = 5.

## Example 2:
## *Ví dụ 2:*

**Input:** grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
**Output:** 0

---

## Constraints:
## *Ràng buộc:*

*   `n == grid.length`
*   `n == grid[i].length`
*   `1 <= n <= 50`
*   `grid[i][j]` is `-1`, `0`, or `1`.
*   `grid[0][0] != -1`
*   `grid[n - 1][n - 1] != -1`
