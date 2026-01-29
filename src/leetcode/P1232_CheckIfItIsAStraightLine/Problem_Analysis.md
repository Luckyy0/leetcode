# 1232. Check If It Is a Straight Line / Kiểm tra xem đó có phải là đường thẳng không

## Problem Description / Mô tả bài toán
Given an array of `coordinates` where `coordinates[i] = [x, y]`.
Check if these points make a straight line.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Slope Check / Cross Product
Line defined by first two points.
Slope `(y1 - y0) / (x1 - x0)`.
For every subsequent point `i`: `(yi - y0) / (xi - x0)` must equal slope.
Cross product to avoid division/zero division:
`(y1 - y0) * (xi - x0) == (yi - y0) * (x1 - x0)`.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(1).

---
