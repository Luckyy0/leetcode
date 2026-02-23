# Result for Battleships in a Board
# *Kết quả cho bài toán Tàu chiến trên Bàn cờ*

## Description
## *Mô tả*

Given an `m x n` matrix `board` where each cell is a battleship `'X'` or empty `'.'`, return *the number of the **battleships** on `board`*.
*Cho một ma trận `m x n` `board` trong đó mỗi ô là một tàu chiến `'X'` hoặc ô trống `'.'`, hãy trả về *số lượng **tàu chiến** trên `board`*.*

**Battleships** can only be placed horizontally or vertically on `board`. In other words, they can only be made of the shape `1 x k` (1 row, k columns) or `k x 1` (k rows, 1 column), where `k` can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
*Các **tàu chiến** chỉ có thể được đặt nằm ngang hoặc nằm dọc trên `board`. Nói cách khác, chúng chỉ có thể có hình dạng `1 x k` (1 hàng, k cột) hoặc `k x 1` (k hàng, 1 cột), trong đó `k` có thể có kích thước bất kỳ. Luôn có ít nhất một ô trống (theo chiều ngang hoặc dọc) phân cách giữa hai tàu chiến (tức là không có các tàu chiến nằm sát nhau).*

## Example 1:
## *Ví dụ 1:*

**Input:** `board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]`
**Output:** `2`

## Example 2:
## *Ví dụ 2:*

**Input:** `board = [["."]]`
**Output:** `0`

## Constraints:
## *Ràng buộc:*

*   `m == board.length`
*   `n == board[i].length`
*   `1 <= m, n <= 200`
*   `board[i][j]` is either `'X'` or `'.'`.

**Follow up:** Could you do it in one-pass, using only $O(1)$ extra memory and without modifying the values of the board?
*Gợi ý: Bạn có thể giải bài toán này trong một lần duyệt, chỉ sử dụng thêm $O(1)$ bộ nhớ và không thay đổi giá trị của bàn cờ không?*
