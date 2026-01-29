# 529. Minesweeper / Trò Chơi Dò Mìn

## Problem Description / Mô tả bài toán
Let's play the Minesweeper game!
Hãy chơi trò chơi Dò Mìn!

You are given an `m x n` char matrix `board` representing the game board where:
Bạn được cho một ma trận ký tự `m x n` `board` đại diện cho bảng trò chơi, trong đó:

- `'M'` represents an unrevealed mine / đại diện cho một quả mìn chưa được tiết lộ.
- `'E'` represents an unrevealed empty square / đại diện cho một ô trống chưa được tiết lộ.
- `'B'` represents a revealed blank square that has no adjacent mines / đại diện cho một ô trống đã được tiết lộ không có mìn lân cận.
- Digit (`'1'` to `'8'`) represents how many mines are adjacent to this revealed square / đại diện cho số lượng mìn lân cận ô đã tiết lộ này.
- `'X'` represents a revealed mine / đại diện cho một quả mìn đã được tiết lộ.

Given an integer array `click` where `click = [clickr, clickc]` represents the next click position among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the Minesweeper rules.
Cho một mảng số nguyên `click`, trong đó `click = [clickr, clickc]` đại diện cho vị trí nhấp chuột tiếp theo trong số tất cả các ô chưa được tiết lộ ('M' hoặc 'E'), hãy trả về bảng sau khi tiết lộ vị trí này theo quy tắc Dò Mìn.

## Constraints / Ràng buộc
- `m == board.length`, `n == board[i].length`
- `1 <= m, n <= 50`

---

## Theoretical Foundation / Cơ sơ lý thuyết

### DFS/BFS Simulation / Mô phỏng DFS/BFS
The rules imply recursive revealing behavior (like filling regions).

Algorithm:
1. If click on 'M': Change to 'X'. Game Over (conceptually). Return board.
2. If click on 'E':
   - Count adjacent mines.
   - If mines > 0: Change 'E' to 'digit'. Stop.
   - If mines == 0: Change 'E' to 'B'. Recursively reveal all 8 neighbors (DFS or BFS).

### Complexity / Độ phức tạp
- **Time**: O(M * N) since each cell is processed at most once.
- **Space**: O(M * N) for recursion stack or queue.

---

## Analysis / Phân tích

### Approach: Recursive Graph Traversal

**Algorithm**:
1.  Check clicked cell content.
2.  If mine -> mark 'X' and return.
3.  If empty, count adjacent mines.
4.  If adjacent mines exist -> show count.
5.  If no adjacent mines -> mark 'B' and recurse on neighbors.

---
