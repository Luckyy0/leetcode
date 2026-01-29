# 755. Pour Water / Đổ Nước

## Problem Description / Mô tả bài toán
You are given an array of integers `heights` representing a reservoir of water. Water is poured at `volume` units one by one at index `k`.
Bạn được cho một mảng các số nguyên `heights` đại diện cho một bể chứa nước. Nước được đổ từng đơn vị một (`volume` lần) tại chỉ số `k`.

Rules for each unit:
1. Try moving **left**. Move as far as possible as long as heights don't increase. If you find a position lower than current, move there.
2. If unable to move left, try moving **right** with the same logic.
3. If unable to move left or right, stay at index `k`.

Return `heights` after all water is poured.
Trả về `heights` sau khi tất cả nước đã được đổ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Simulation / Mô phỏng
We simulate unit by unit.
Chúng ta mô phỏng từng đơn vị một.

For each unit:
- Search most distal left-down point: Start at `k`, move left while `h[i-1] <= h[i]`. Track the best (lowest) point seen so far.
- If best point is `< h[k]`, increment its height and continue to next unit.
- Otherwise, repeat search for the right-down point.
- If neither found, increment `h[k]`.

### Complexity / Độ phức tạp
- **Time**: O(Volume * N) where N is length of heights.
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Greedy Directional Descent
The rules strictly prioritize left, then right, then center. The water unit must settle in the furthest possible downward location within the range it can reach without crossing a "peak".
Các quy tắc ưu tiên nghiêm ngặt bên trái, sau đó là bên phải, rồi đến trung tâm. Đơn vị nước phải nằm ở vị trí đi xuống xa nhất có thể trong phạm vi mà nó có thể đạt được mà không vượt qua một "đỉnh".

---
