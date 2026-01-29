# 1037. Valid Boomerang / Boomerang Hợp lệ

## Problem Description / Mô tả bài toán
A boomerang is a set of 3 points that are all distinct and not in a straight line.
Một boomerang là một tập hợp gồm 3 điểm phân biệt và không nằm trên một đường thẳng.

Given an array `points` where `points[i] = [xi, yi]`, return `true` if these points match the definition.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Geometry / Cross Product / Hình học / Tích có hướng
Slope check.
Checks if `(y2-y1)/(x2-x1) == (y3-y2)/(x3-x2)`.
Avoid division by zero by using cross product:
`(y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1)`.
Also implicitly checks for distinctness (if points equal, area is 0).

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Collinearity Test
Use the cross-product formula to calculate the area of the triangle formed by the three points. If the area is non-zero, the points are not collinear and must be distinct, satisfying the condition.
Sử dụng công thức tích có hướng để tính diện tích của tam giác được tạo bởi ba điểm. Nếu diện tích khác không, các điểm không thẳng hàng và phải phân biệt, thỏa mãn điều kiện.

---
