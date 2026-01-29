# 794. Valid Tic-Tac-Toe State / Trạng thái Tic-Tac-Toe Hợp lệ

## Problem Description / Mô tả bài toán
Given a Tic-Tac-Toe board as a string array `board`, return `true` if it is possible to reach this board state during a valid game of Tic-Tac-Toe.
Cho một bảng Tic-Tac-Toe dưới dạng mảng chuỗi `board`, hãy trả về `true` nếu có thể đạt được trạng thái bảng này trong một trò chơi Tic-Tac-Toe hợp lệ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Validity Rules / Quy tắc Hợp lệ
Let `X` be number of 'X' and `O` be number of 'O'.
1. `X` must be `O` or `O + 1`. (X goes first).
   `X` phải là `O` hoặc `O + 1`.

2. If X wins, `X` must be `O + 1`. (X just made the winning move).
   Nếu X thắng, `X` phải bằng `O + 1`.

3. If O wins, `X` must be `O`. (O just made the winning move).
   Nếu O thắng, `X` phải bằng `O`.

4. It's impossible for both X and O to win simultaneously (one must reach 3-in-a-row first).
   Không thể để cả X và O cùng thắng đồng thời.

### Complexity / Độ phức tạp
- **Time**: O(1) (fixed 3x3 board).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: State Constraint Verification
Systematically check the counts of X and O, and verify the logical consistency of win conditions.
Kiểm tra hệ thống số lượng X và O, đồng thời xác minh tính nhất quán logic của các điều kiện thắng.

---
