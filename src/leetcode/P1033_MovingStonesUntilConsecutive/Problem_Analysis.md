# 1033. Moving Stones Until Consecutive / Di chuyển Đá cho đến khi Liên tiếp

## Problem Description / Mô tả bài toán
Three stones are on a number line at positions `a`, `b`, and `c`.
Change position of a stone (pick endpoint, move to between other two).
Game ends when stones are consecutive (e.g., 1, 2, 3).
Find minimum and maximum moves.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Mathematical Logic / Logic Toán học
Sort stones `x < y < z`.
Gaps: `g1 = y - x - 1`, `g2 = z - y - 1`.

Minimum moves:
- If `g1 == 0` and `g2 == 0`: already consecutive. Moves: 0.
- If `g1 <= 1` or `g2 <= 1`: we can finish in 1 move (slide stone into gap or hop over).
  - Note: `g1 == 1` means `y - x == 2` (e.g., 1, 3). We can put z at 2.
- Otherwise: 2 moves (move x to y+1, then z to y+2).

Maximum moves:
- Just move one step at a time closing the gaps.
- Moves = `g1 + g2`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Gap Analysis
Sorting the positions simplifies the problem to analyzing the two gaps between the stones. The maximum moves are determined by the total empty space (sum of gaps), as we can close gaps one unit at a time. The minimum moves are either 0, 1, or 2, determined by whether stones are already adjacent or if a gap of size 1 or 2 exists, allowing for a quick finish.
Sắp xếp các vị trí đơn giản hóa bài toán thành việc phân tích hai khoảng trống giữa các viên đá. Số lần di chuyển tối đa được xác định bởi tổng không gian trống (tổng các khoảng trống), vì chúng ta có thể đóng các khoảng trống từng đơn vị một. Số lần di chuyển tối thiểu là 0, 1 hoặc 2, được xác định bởi việc liệu các viên đá đã liền kề nhau chưa hoặc nếu khoảng trống có kích thước 1 hoặc 2 tồn tại, cho phép kết thúc nhanh chóng.

---
