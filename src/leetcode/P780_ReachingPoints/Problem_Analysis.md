# 780. Reaching Points / Điểm có thể đến

## Problem Description / Mô tả bài toán
A point `(x, y)` can move to either `(x, x + y)` or `(x + y, y)`.
Một điểm `(x, y)` có thể di chuyển đến `(x, x + y)` hoặc `(x + y, y)`.

Given `sx`, `sy`, `tx`, `ty`, return `true` if it is possible to reach `(tx, ty)` from `(sx, sy)`.
Cho `sx`, `sy`, `tx`, `ty`, hãy trả về `true` nếu có thể đi từ `(sx, sy)` đến `(tx, ty)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Backward Invariant / Bất biến Ngược
From `(sx, sy)` going forward is branching (1 to many).
Going backward from `(tx, ty)` is unique (many to 1).
Đi từ `(sx, sy)` về phía trước là phân nhánh (1 đến nhiều). Đi ngược lại từ `(tx, ty)` là duy nhất (nhiều về 1).

If `tx > ty`, the previous state **must** have been `(tx - ty, ty)`.
If `ty > tx`, the previous state **must** have been `(tx, ty - tx)`.

Algorithm:
1. While `tx > sx` and `ty > sy`:
   - If `tx > ty`, `tx %= ty`.
   - Else `ty %= tx`.
2. check if `tx == sx` and `(ty - sy) % sx == 0`.
3. check if `ty == sy` and `(tx - sx) % sy == 0`.

### Complexity / Độ phức tạp
- **Time**: O(log(max(tx, ty))) which is similar to the Euclidean algorithm.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Reverse Modulo Path
Iteratively reduce the larger coordinate using the modulo of the smaller one. This efficiently skips many small subtraction steps.
Giảm lặp lại tọa độ lớn hơn bằng cách sử dụng phép chia lấy dư (modulo) cho tọa độ nhỏ hơn. Điều này giúp bỏ qua hiệu quả nhiều bước trừ nhỏ.

---
