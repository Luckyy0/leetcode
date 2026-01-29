# 1301. Number of Paths with Max Score / Số lượng Đường đi có Điểm Tối đa

## Problem Description / Mô tả bài toán
Grid `board` with digits and 'X' (obstacle), 'E' (start), 'S' (end).
Move from `E` (bottom-right) to `S` (top-left).
Moves: Up, Left, Up-Left.
Each digit adds to score.
Find max score and number of paths with max score.
Modulo `10^9 + 7`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Dynamic Programming
`dp[i][j]` stores `{max_score, count}`.
Start from `E` (bottom-right) to `S` (top-left).
Or reverse: find path from `S` to `E` using Down, Right, Down-Right. Same problem.
Let's iterate from bottom-right to top-left.
For cell `(i, j)`, look at `(i+1, j)`, `(i, j+1)`, `(i+1, j+1)`.
Take maximum score from valid neighbors. Sum counts of neighbors providing max score.
Handle 'X' (unreachable).
Start at `board[n-1][n-1]` (E). If 'X', 0 paths.
Target `board[0][0]` (S).

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) or O(N).

---

## Analysis / Phân tích

### Approach: DP with Score and Count
Let `dp[i][j]` store a pair `{maxScore, count}` representing the maximum score to reach the end `E` from `(i, j)` and the number of ways to achieve it.
Iterate from bottom-right (target) to top-left (start).
For each cell `(i, j)`, consider transitions from `(i+1, j)`, `(i, j+1)`, `(i+1, j+1)`. Identify the maximum score among valid (reachable) neighbors. If multiple neighbors provide the same maximum score, sum their counts modulo $10^9 + 7$.
Initialize the target cell `E` with score 0 and count 1. Unreachable cells have count 0.
Return `dp[0][0]`.
Hãy để `dp[i][j]` lưu trữ một cặp `{maxScore, count}` đại diện cho điểm tối đa để đến đích `E` từ `(i, j)` và số cách để đạt được nó.
Lặp lại từ dưới cùng bên phải (mục tiêu) đến trên cùng bên trái (bắt đầu).
Đối với mỗi ô `(i, j)`, hãy xem xét các chuyển đổi từ `(i+1, j)`, `(i, j+1)`, `(i+1, j+1)`. Xác định điểm tối đa trong số các hàng xóm hợp lệ (có thể truy cập được). Nếu nhiều hàng xóm cung cấp cùng một điểm tối đa, hãy cộng tổng số lượng của chúng modulo $10^9 + 7$.
Khởi tạo ô mục tiêu `E` với điểm 0 và số đếm 1. Các ô không thể truy cập có số đếm 0.
Trả về `dp[0][0]`.

---
