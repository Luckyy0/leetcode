# Result for Valid Tic-Tac-Toe State
# *Kết quả cho bài toán Trạng thái Tic-Tac-Toe Hợp lệ*

## Description
## *Mô tả*

Given a Tic-Tac-Toe board as a string array, return `true` if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
*Cho một bàn cờ Tic-Tac-Toe dưới dạng mảng chuỗi, trả về `true` khi và chỉ khi có thể đạt được vị trí bàn cờ này trong quá trình chơi tic-tac-toe hợp lệ.*

The board is a `3 x 3` array that consists of characters `' '`, `'X'`, and `'O'`. The `' '` character represents an empty square.
*Bàn cờ là một mảng `3 x 3` bao gồm các ký tự `' '`, `'X'`, và `'O'`. Ký tự `' '` đại diện cho một ô trống.*

Here are the rules of Tic-Tac-Toe:
*   Players take turns placing characters into empty squares `' '`.
*   The first player always places `'X'` characters, while the second player always places `'O'` characters.
*   `'X'` and `'O'` characters are always placed into empty squares, never on filled ones.
*   The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
*   The game also ends if all squares are non-empty.
*   No more moves can be played if the game is over.

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = ["O  ","   ","   "]
**Output:** false
**Explanation:** The first player always plays "X".

## Example 2:
## *Ví dụ 2:*

**Input:** board = ["XOX"," X ","   "]
**Output:** false
**Explanation:** Players take turns making moves.

## Example 3:
## *Ví dụ 3:*

**Input:** board = ["XOX","O O","XOX"]
**Output:** true

---

## Constraints:
## *Ràng buộc:*

*   `board.length == 3`
*   `board[i].length == 3`
*   `board[i][j]` is either `'X'`, `'O'`, or `' '`.
