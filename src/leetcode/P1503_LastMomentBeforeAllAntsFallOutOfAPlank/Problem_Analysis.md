# 1503. Last Moment Before All Ants Fall Out of a Plank / Khoảnh khắc Cuối cùng Trước khi Tất cả Kiến Rơi ra Khỏi Ván

## Problem Description / Mô tả bài toán
Plank length `n`. Ants moving Left `left[]` (indices), Right `right[]` (indices). Speed 1.
When ants collide, they reverse.
When do all fall off?

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Ant Collision Property
When identical ants collide and reverse, it is equivalent to them passing through each other without changing direction.
So just calculate time for each ant to fall off independently.
Max time is the answer.
Left ants at `x` take `x` time to fall off (towards 0).
Right ants at `x` take `n - x` time to fall off (towards n).
Result `max(max(left), max(n - right))`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Linear Scan
Iterate left array, maximize `x`.
Iterate right array, maximize `n - x`.
Return overall max.
Lặp lại mảng bên trái, tối đa hóa `x`.
Lặp lại mảng bên phải, tối đa hóa `n - x`.
Trả lại tối đa tổng thể.

---
