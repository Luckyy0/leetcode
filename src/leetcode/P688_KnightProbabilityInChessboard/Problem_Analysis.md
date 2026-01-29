# 688. Knight Probability in Chessboard / Xác suất của Quân Mã trên Bàn cờ

## Problem Description / Mô tả bài toán
On an `n x n` chessboard, a knight starts at the cell `(row, column)` and attempts to make exactly `k` moves. The rows and columns are 0-indexed, so the top-left cell is `(0, 0)`, and the bottom-right cell is `(n - 1, n - 1)`.
Trên bàn cờ `n x n`, một quân mã bắt đầu tại ô `(row, column)` và cố gắng thực hiện đúng `k` nước đi. Các hàng và cột được đánh chỉ số từ 0, vì vậy ô trên cùng bên trái là `(0, 0)` và ô dưới cùng bên phải là `(n - 1, n - 1)`.

A chess knight has eight possible moves it can make. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
Một quân mã có tám nước đi khả thi có thể thực hiện. Mỗi nước đi là hai ô theo hướng chính, sau đó một ô theo hướng trực giao.

Return the probability that the knight remains on the board after making exactly `k` moves.
Trả về xác suất để quân mã vẫn còn trên bàn cờ sau khi thực hiện đúng `k` nước đi.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming / Quy hoạch Động
Let `dp[k][r][c]` be the probability of being at cell `(r, c)` after `k` moves.
Gọi `dp[k][r][c]` là xác suất ở ô `(r, c)` sau `k` nước đi.

Initial state: `dp[0][startRow][startColumn] = 1`.

Transition:
From cell `(r, c)` at move `step`, the probability spreads to 8 neighbors at `step + 1`:
`dp[step+1][nr][nc] += dp[step][r][c] / 8.0` if `(nr, nc)` is in bounds.

### Complexity / Độ phức tạp
- **Time**: O(K * N^2) there are K * N^2 states.
- **Space**: O(N^2) using space optimization (only keep current and previous step).

---

## Analysis / Phân tích

### Approach: Iterative State Transition
Calculate probabilities step-by-step. The final answer is the sum of probabilities of all cells on the board after the `Kth` move.
Tính toán xác suất từng bước một. Câu trả lời cuối cùng là tổng xác suất của tất cả các ô trên bàn cờ sau nước đi thứ K.

---
