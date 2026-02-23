# Result for Transform to Chessboard
# *Kết quả cho bài toán Biến đổi thành Bàn cờ*

## Description
## *Mô tả*

You are given an `n x n` binary grid `board`. In each move, you can swap any two rows with each other, or any two columns with each other.
*Bạn được cho một lưới nhị phân `n x n` `board`. Trong mỗi bước di chuyển, bạn có thể hoán đổi bất kỳ hai hàng nào với nhau, hoặc bất kỳ hai cột nào với nhau.*

Return *the minimum number of moves to transform the board into a **chessboard board***. If the task is impossible, return `-1`.
*Trả về *số bước di chuyển tối thiểu để biến đổi bảng thành một **bàn cờ vua***. Nếu nhiệm vụ là không thể, trả về `-1`.*

A **chessboard board** is a board where no `0`'s and no `1`'s are 4-directionally adjacent.
*Một **bàn cờ vua** là một bảng mà không có số `0` và số `1` nào nằm liền kề theo 4 hướng.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
**Output:** 2
**Explanation:**
One potential sequence of moves is shown below, from left to right:
0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101
The first move swaps the 1st and 2nd column.
The second move swaps the 2nd and 3rd row.

## Example 2:
## *Ví dụ 2:*

**Input:** board = [[0,1],[1,0]]
**Output:** 0
**Explanation:**
Also note that the board with 0 in the top left corner,
01
10
is also a valid chessboard.

## Example 3:
## *Ví dụ 3:*

**Input:** board = [[1,0],[1,0]]
**Output:** -1
**Explanation:**
No matter what sequence of moves you make, you cannot end with a chessboard.

---

## Constraints:
## *Ràng buộc:*

*   `n == board.length`
*   `n == board[i].length`
*   `2 <= n <= 30`
*   `board[i][j]` is either `0` or `1`.
