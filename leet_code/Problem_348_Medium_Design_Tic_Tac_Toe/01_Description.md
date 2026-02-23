# Result for Design Tic-Tac-Toe
# *Kết quả cho bài toán Thiết kế Tic-Tac-Toe*

## Description
## *Mô tả*

Design a Tic-tac-toe game that is played between two players on a `n x n` grid.
*Thiết kế một trò chơi Tic-tac-toe được chơi giữa hai người chơi trên một lưới `n x n`.*

You may assume the following rules:
*Bạn có thể giả định các quy tắc sau:*

1.  A move is guaranteed to be valid and is placed on an empty block.
    *Một nước đi được đảm bảo là hợp lệ và được đặt trên một ô trống.*
2.  Once a winning condition is reached, no more moves is allowed.
    *Khi đạt được điều kiện thắng, không được phép thực hiện thêm nước đi nào nữa.*
3.  A player who succeeds in placing `n` of their marks in a horizontal, vertical, or diagonal row wins the game.
    *Người chơi thành công trong việc đặt `n` quân của mình theo hàng ngang, hàng dọc hoặc hàng chéo sẽ thắng trò chơi.*

Implement the `TicTacToe` class:
*Thực hiện lớp `TicTacToe`:*

*   `TicTacToe(int n)` Initializes the object the size of the board `n`.
    *`TicTacToe(int n)` Khởi tạo đối tượng với kích thước bàn cờ `n`.*
*   `int move(int row, int col, int player)` Indicates that the player with id `player` plays at the cell `(row, col)` of the board. The move is guaranteed to be a valid move.
    *`int move(int row, int col, int player)` Chỉ ra rằng người chơi có id `player` đánh tại ô `(row, col)` của bàn cờ. Nước đi được đảm bảo là hợp lệ.*

Return the winner:
*Trả về người chiến thắng:*
- `0` if there is no winner yet.
- `1` if player 1 wins.
- `2` if player 2 wins.

## Example 1:
## *Ví dụ 1:*

**Input:**
`["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]`
`[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]`
**Output:**
`[null, 0, 0, 0, 0, 0, 0, 1]`

**Explanation:**
```java
TicTacToe ticTacToe = new TicTacToe(3);
ticTacToe.move(0, 0, 1); // return 0 (no one wins)
ticTacToe.move(0, 2, 2); // return 0 (no one wins)
ticTacToe.move(2, 2, 1); // return 0 (no one wins)
ticTacToe.move(1, 1, 2); // return 0 (no one wins)
ticTacToe.move(2, 0, 1); // return 0 (no one wins)
ticTacToe.move(1, 0, 2); // return 0 (no one wins)
ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
```

## Constraints:
## *Ràng buộc:*

*   `2 <= n <= 100`
*   `player` is 1 or 2.
*   `0 <= row, col < n`
*   Every call to `move` will be with a unique `(row, col)`.
*   At most `n^2` calls will be made to `move`.

**Follow up:** Could you do better than $O(n^2)$ per `move()` call?
**Câu hỏi mở rộng:** Bạn có thể thực hiện tốt hơn $O(n^2)$ cho mỗi lần gọi `move()` không?
