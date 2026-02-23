# Result for Number of Islands II
# *Kết quả cho bài toán Số lượng Đảo II*

## Description
## *Mô tả*

You are given an empty 2D binary grid `grid` of size `m x n`. The grid represents a map where `0`'s represent water and `1`'s represent land. Initially, all the cells of `grid` are water cells (i.e., all the cells are `0`'s).
*Bạn được cho một lưới nhị phân 2D trống `grid` có kích thước `m x n`. Lưới đại diện cho một bản đồ trong đó `0` đại diện cho nước và `1` đại diện cho đất. Ban đầu, tất cả các ô của `grid` đều là ô nước (tức là tất cả các ô đều là `0`).*

We may perform an add land operation which turns the water at position `(row, col)` into a land. You are given an array `positions` where `positions[i] = [ri, ci]` is the position `(ri, ci)` at which we should operate the `i^th` operation.
*Chúng tôi có thể thực hiện thao tác thêm đất, biến nước tại vị trí `(row, col)` thành đất. Bạn được cho một mảng `positions` trong đó `positions[i] = [ri, ci]` là vị trí `(ri, ci)` mà tại đó chúng tôi nên thực hiện thao tác thứ `i`.*

Return *an array of integers* `answer` *where* `answer[i]` *is the number of islands after turning the cell* `(ri, ci)` *into land*.
*Trả về *một mảng số nguyên* `answer` *trong đó* `answer[i]` *là số lượng đảo sau khi biến ô* `(ri, ci)` *thành đất.*

An **island** is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*Một **hòn đảo** được bao quanh bởi nước và được hình thành bằng cách kết nối các vùng đất liền kề theo chiều ngang hoặc chiều dọc. Bạn có thể cho rằng cả bốn cạnh của lưới đều được bao quanh bởi nước.*

## Example 1:
## *Ví dụ 1:*

**Input:** `m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]`
**Output:** `[1,1,2,3]`
**Explanation:**
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.

## Example 2:
## *Ví dụ 2:*

**Input:** `m = 1, n = 1, positions = [[0,0]]`
**Output:** `[1]`

## Constraints:
## *Ràng buộc:*

*   `1 <= m, n, positions.length <= 10^4`
*   `1 <= m * n <= 10^4`
*   `positions[i].length == 2`
*   `0 <= ri < m`
*   `0 <= ci < n`
