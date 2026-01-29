# 657. Robot Return to Origin / Robot Quay Về Gốc

## Problem Description / Mô tả bài toán
There is a robot starting at position (0, 0). Given a sequence of moves, judge if this robot ends at (0, 0) after it completes its moves.
Có một robot bắt đầu ở vị trí (0, 0). Cho một chuỗi các bước di chuyển, hãy đánh giá xem robot này có kết thúc ở (0, 0) sau khi hoàn thành các bước di chuyển của nó không.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are R (right), L (left), U (up), and D (down).
Chuỗi di chuyển được biểu diễn bằng một chuỗi, và ký tự moves[i] đại diện cho bước di chuyển thứ i của nó. Các bước di chuyển hợp lệ là R (phải), L (trái), U (lên) và D (xuống).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Counting / Đếm
Count R vs L and U vs D. If both pairs are equal, robot returns to origin.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---
