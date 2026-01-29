# 1459. Rectangles Area / Diện tích Hình chữ nhật

## Problem Description / Mô tả bài toán
Table `Points` (id, x_value, y_value).
Form rectangles with sides parallel to axes using 2 points (p1, p2).
Only if `p1.x != p2.x` and `p1.y != p2.y`.
Area `abs(x1-x2) * abs(y1-y2)`.
Result `p1`, `p2`, `area`. `p1 < p2`.
Order by area DESC, p1, p2.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Self Join
Join `Points` p1 with `Points` p2 on `p1.id < p2.id`.
Filter `x1 != x2` and `y1 != y2`.
Calc area.

---
