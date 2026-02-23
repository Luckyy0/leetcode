# Result for Snakes and Ladders
# *Kết quả cho bài toán Rắn và Thang*

## Description
## *Mô tả*

You are given an `n x n` integer matrix `board` where the cells are labeled from `1` to `n*n` in a **Boustrophedon style** starting from the bottom left of the board (i.e. `board[n-1][0]`) and alternating direction each row.
*Bạn được cho một ma trận số nguyên `n x n` `board` trong đó các ô được đánh số từ `1` đến `n*n` theo **kiểu Boustrophedon** bắt đầu từ góc dưới cùng bên trái của bàn cờ (tức là `board[n-1][0]`) và đổi hướng sau mỗi hàng.*

You start on square `1` of the board. In each move, starting from square `curr`, do the following:
*Bạn bắt đầu từ ô `1` của bàn cờ. Trong mỗi bước di chuyển, bắt đầu từ ô `curr`, thực hiện các bước sau:*

*   Choose a destination square `next` with a label in the range `[curr + 1, min(curr + 6, n*n)]`.
    *   *Chọn một ô đích `next` có nhãn trong khoảng `[curr + 1, min(curr + 6, n*n)]`.*
    *   This choice simulates the result of a standard **6-sided die roll**: i.e., there are always at most 6 destinations, regardless of the size of the board.
        *   *Sự lựa chọn này mô phỏng kết quả của việc tung **xúc xắc 6 mặt** tiêu chuẩn: tức là luôn có tối đa 6 điểm đến, bất kể kích thước bàn cờ.*
*   If `next` has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to `next`.
    *   *Nếu `next` có rắn hoặc thang, bạn phải di chuyển đến điểm đích của rắn hoặc thang đó. Ngược lại, bạn di chuyển đến `next`.*
*   The game ends when you reach the square `n*n`.
    *   *Trò chơi kết thúc khi bạn đến ô `n*n`.*

A board square on row `r` and column `c` has a snake or ladder if `board[r][c] != -1`. The destination of that snake or ladder is `board[r][c]`. Squares `1` and `n*n` do not have a snake or ladder.
*Một ô trên bàn cờ ở hàng `r` và cột `c` có rắn hoặc thang nếu `board[r][c] != -1`. Điểm đích của rắn hoặc thang đó là `board[r][c]`. Các ô `1` và `n*n` không có rắn hoặc thang.*

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do **not** follow the subsequent snake or ladder.
*Lưu ý rằng bạn chỉ đi theo rắn hoặc thang tối đa một lần mỗi bước. Nếu điểm đến của một con rắn hoặc cái thang là điểm bắt đầu của một con rắn hoặc cái thang khác, bạn **không** đi theo con rắn hoặc cái thang tiếp theo đó.*

Return *the least number of moves required to reach the square `n*n`*. If it is impossible to reach the square, return `-1`.
*Hãy trả về *số bước di chuyển ít nhất cần thiết để đến ô `n*n`*. Nếu không thể đến ô đó, trả về `-1`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
**Output:** 4
**Explanation:** 
Start at 1. 
You can choose square 2. No snake/ladder. Position: 2.
At 2, choose square 8? No. 
Path: 
1 -> 2 (dice roll 1) -> 15 (ladder from 2 to 15) -> wait, ladder is at 2.
Wait, let's re-read carefully. "Choose next in range... If next has snake/ladder, YOU MUST move to destination."
So if we roll 1 from 1, we land on 2. 2 has ladder to 15. So we end move at 15.
From 15, roll to 17. 17 has snake to 13. End move at 13.
...
Actual shortest path:
1. At 1, roll 4. Land on 5. No snake. Stay at 5.
Wait, example explanation says 4 moves.
1 -> 2 -> 15 (ladder). Move 1.
15 -> 17 -> 13 (snake). Move 2.
13 -> 14 -> 35 (ladder). Move 3.
35 -> 36. Move 4.

## Example 2:
## *Ví dụ 2:*

**Input:** board = [[-1,-1],[-1,3]]
**Output:** 1

---

## Constraints:
## *Ràng buộc:*

*   `n == board.length == board[i].length`
*   `2 <= n <= 20`
*   `board[i][j]` is either `-1` or varies between `1` and `n*n`.
*   The squares `1` and `n*n` do not have a snake or ladder.
