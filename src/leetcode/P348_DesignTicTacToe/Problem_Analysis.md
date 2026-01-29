# 348. Design Tic-Tac-Toe / Thiết Kế Trò Chơi Tic-Tac-Toe

## Problem Description / Mô tả bài toán
Assume the following rules are for the Tic-Tac-Toe game on an `n x n` board between two players:
Giả sử các quy tắc sau đây cho trò chơi Tic-Tac-Toe trên bảng `n x n` giữa hai người chơi:

1.  A move is guaranteed to be valid and is placed on an empty block.
2.  Once a winning condition is reached, no more moves is allowed.
3.  A player who succeeds in placing `n` of their marks in a horizontal, vertical, or diagonal row wins the game.

Implement the `TicTacToe` class:
- `TicTacToe(int n)` Initializes the object the size of the board `n`.
- `int move(int row, int col, int player)` Indicates that the player with id `player` plays at the cell `(row, col)` of the board. The move is guaranteed to be a valid move. Return `0` if no one wins, `1` if player 1 wins, and `2` if player 2 wins.

### Example 1:
```text
Input
["TicTacToe", "move", "move", "move", "move", "move", "move", "move"]
[[3], [0, 0, 1], [0, 2, 2], [2, 2, 1], [1, 1, 2], [2, 0, 1], [1, 0, 2], [2, 1, 1]]
Output
[null, 0, 0, 0, 0, 0, 0, 1]

Explanation
TicTacToe ticTacToe = new TicTacToe(3);
Assume that player 1 is "X" and player 2 is "O" in the board.
ticTacToe.move(0, 0, 1); // return 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

ticTacToe.move(0, 2, 2); // return 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

...
ticTacToe.move(2, 1, 1); // return 1 (player 1 wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
```

## Constraints / Ràng buộc
- `2 <= n <= 100`
- `player` is `1` or `2`.
- `1 <= row, col <= n`
- `(row, col)` are unique for each valid call to `move`.
- At most `n^2` calls will be made to `move`.

**Follow-up**: Could you do better than `O(n^2)` per `move()` operation?

---

## Theoretical Foundation / Cơ sở lý thuyết

### Tally Counters / Bộ Đếm
Instead of checking the entire board O(N^2) or O(N), we can maintain counts.
We need to know for each row/col/diagonal, how many marks Player 1 has vs Player 2.
Optimization:
- Player 1 adds `+1`.
- Player 2 adds `-1`.
- If a row sum is `n`, Player 1 wins.
- If a row sum is `-n`, Player 2 wins.

Data structures:
- `rows[n]` array.
- `cols[n]` array.
- `diagonal` int.
- `antiDiagonal` int.

Complexity for `move`: O(1).

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: O(1) Tally

**Algorithm**:
1.  Arrays `rows`, `cols` size `n`. Ints `diag`, `antiDiag`.
2.  `move(r, c, player)`:
    - `val = (player == 1) ? 1 : -1`.
    - `rows[r] += val`. Check `abs(rows[r]) == n`.
    - `cols[c] += val`. Check `abs(cols[c]) == n`.
    - If `r == c`: `diag += val`. Check `abs`.
    - If `r == n - 1 - c`: `antiDiag += val`. Check `abs`.
    - Return `player` if win, else 0.

---
