# Result for Surrounded Regions
# *Kết quả cho bài toán Vùng Bị Bao Vây*

## Description
## *Mô tả*

Given an `m x n` matrix `board` containing `'X'` and `'O'`, *capture all regions that are 4-directionally surrounded by* `'X'`.
*Cho một ma trận `board` kích thước `m x n` chứa các ký tự `'X'` và `'O'`, hãy *chiếm lấy tất cả các vùng bị bao vây 4 phía bởi* `'X'`.**

A region is **captured** by flipping all `'O'`s into `'X'`s in that surrounded region.
*Một vùng được coi là **bị chiếm lấy** bằng cách lật tất cả các ký tự `'O'` thành `'X'` trong vùng bị bao vây đó.*

## Surrounded Regions
## *Vùng Bị Bao Vây*

A region is surrounded if it is not on the edge of the board and none of the `'O'`s in the region are on the edge of the board. Any `'O'` that is not on the edge of the board and is not connected to an `'O'` on the edge of the board will be flipped to `'X'`. Any `'O'` that is on the edge of the board or is connected to an `'O'` on the edge of the board will **not** be flipped.
*Một vùng bị bao vây nếu nó không nằm ở cạnh của bảng và không có ký tự `'O'` nào trong vùng nằm ở cạnh của bảng. Bất kỳ ký tự `'O'` nào không nằm ở cạnh của bảng và không kết nối với một ký tự `'O'` ở cạnh của bảng sẽ bị lật thành `'X'`. Bất kỳ ký tự `'O'` nào nằm ở cạnh của bảng hoặc được kết nối với một ký tự `'O'` ở cạnh của bảng sẽ **không** bị lật.*

## Example 1:
## *Ví dụ 1:*

**Input:** board = `[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]`
**Output:** `[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]`
**Explanation:** Notice that an 'O' should not be flipped if:
- It is on the edge, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the edge, so it is not flipped.
The other three 'O's are surrounded by 'X's so they are flipped.

## Example 2:
## *Ví dụ 2:*

**Input:** board = `[["X"]]`
**Output:** `[["X"]]`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `1 <= m, n <= 200`
*   `board[i][j]` is `'X'` or `'O'`.
