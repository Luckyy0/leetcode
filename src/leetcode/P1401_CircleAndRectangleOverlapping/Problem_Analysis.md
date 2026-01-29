# 1401. Circle and Rectangle Overlapping / Vòng Tròn và Hình Chữ Nhật Chồng Nhau

## Problem Description / Mô tả bài toán
Check overlap between circle `(xCenter, yCenter, radius)` and rectangle `(x1, y1, x2, y2)`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Closest Point on Rectangle
To check overlap, find the point on the rectangle closest to the circle's center. If the distance from this point to the center is `<=` radius, they overlap.
Closest `x`: `clamp(xCenter, x1, x2)`.
Closest `y`: `clamp(yCenter, y1, y2)`.
Distance squared: `(x - closestX)^2 + (y - closestY)^2`.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Closest Point
Find closest point `(Xn, Yn)` on rectangle to circle center `(Xc, Yc)`.
`Xn = max(x1, min(Xc, x2))`
`Yn = max(y1, min(Yc, y2))`
Check if `dist((Xn, Yn), (Xc, Yc)) <= radius`. (Use squared distance).
Tìm điểm gần nhất `(Xn, Yn)` trên hình chữ nhật đến tâm vòng tròn `(Xc, Yc)`.
`Xn = max(x1, min(Xc, x2))`
`Yn = max(y1, min(Yc, y2))`
Kiểm tra xem `dist((Xn, Yn), (Xc, Yc)) <= radius`.

---
