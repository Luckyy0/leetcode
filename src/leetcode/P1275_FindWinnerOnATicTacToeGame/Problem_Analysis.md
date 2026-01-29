# 1275. Find Winner on a Tic Tac Toe Game / Tìm Người chiến thắng trong Trò chơi Tic Tac Toe

## Problem Description / Mô tả bài toán
Tic Tac Toe moves. `moves[i] = [r, c]`.
Assume moves are valid.
Check winner: A (first), B (second), Draw, or Pending.
Return "A", "B", "Draw", "Pending".

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Array Counting
Board 3x3.
Track row, col, diag sums.
Player A counts as +1, Player B as -1.
`rows[3]`, `cols[3]`, `diag`, `antiDiag`.
If any reaches 3 -> A wins.
If any reaches -3 -> B wins.
If total moves = 9 and no winner -> Draw.
Else Pending.

### Complexity / Độ phức tạp
- **Time**: O(M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Counters
Maintain counters for rows, columns, and diagonals. Iterate through the moves. If it's A's turn (index even), increment counters; if B's turn (index odd), decrement. After each move, check if any counter reached 3 (A wins) or -3 (B wins). If all moves processed and no winner, check if moves count is 9 (Draw), else Pending.
Duy trì các bộ đếm cho hàng, cột và đường chéo. Lặp lại các nước đi. Nếu là lượt của A (chỉ số chẵn), tăng bộ đếm; nếu là lượt của B (chỉ số lẻ), giảm bộ đếm. Sau mỗi nước đi, kiểm tra xem có bất kỳ bộ đếm nào đạt 3 (A thắng) hoặc -3 (B thắng) hay không. Nếu tất cả các nước đi đã được xử lý và không có người chiến thắng, hãy kiểm tra xem số lượng nước đi có phải là 9 (Hòa) không, nếu không thì Đang chờ.

---
