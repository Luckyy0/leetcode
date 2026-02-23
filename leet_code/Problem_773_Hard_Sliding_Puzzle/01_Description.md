# Result for Sliding Puzzle
# *Kết quả cho bài toán Trò chơi Trượt số*

## Description
## *Mô tả*

On a `2 x 3` board, there are 5 tiles represented by the integers `1` through `5`, and an empty square represented by `0`.
*Trên một bảng `2 x 3`, có 5 ô số được đại diện bởi các số nguyên từ `1` đến `5`, và một ô trống được đại diện bởi `0`.*

A move consists of choosing `0` and a 4-directionally adjacent number and swapping it.
*Một bước di chuyển bao gồm việc chọn ô `0` và một số nằm liền kề theo 4 hướng và hoán đổi vị trí của chúng.*

The state of the board is solved if and only if the board is `[[1,2,3],[4,5,0]]`.
*Trạng thái của bảng được coi là đã giải quyết khi và chỉ khi bảng là `[[1,2,3],[4,5,0]]`.*

Given the puzzle board `board`, return the least number of moves required so that the state of the board is solved. If it is impossible for the state of the board to be solved, return `-1`.
*Cho bảng trò chơi `board`, hãy trả về số bước di chuyển ít nhất cần thiết để giải quyết trạng thái của bảng. Nếu không thể giải quyết trạng thái của bảng, trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = [[1,2,3],[4,0,5]]
**Output:** 1
**Explanation:** Swap the 0 and the 5 in one move.

## Example 2:
## *Ví dụ 2:*

**Input:** board = [[1,2,3],[5,4,0]]
**Output:** -1
**Explanation:** No number of moves will make the board solved.

## Example 3:
## *Ví dụ 3:*

**Input:** board = [[4,1,2],[5,0,3]]
**Output:** 5
**Explanation:** 5 is the smallest number of moves that solves the board.
An example path:
[[4,1,2],[5,0,3]]
[[4,1,2],[0,5,3]]
[[0,1,2],[4,5,3]]
[[1,0,2],[4,5,3]]
[[1,2,0],[4,5,3]]
[[1,2,3],[4,5,0]]

---

## Constraints:
## *Ràng buộc:*

*   `board.length == 2`
*   `board[0].length == 3`
*   `board[i][j]` values are in range `[0, 5]`.
