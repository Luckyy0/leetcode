# 478. Generate Random Point in a Circle / Tạo Điểm Ngẫu Nhiên Trong Hình Tròn

## Problem Description / Mô tả bài toán
Given the radius and the position of the center of a circle, implement the function `randPoint` which generates a uniform random point inside the circle.
Cho bán kính và vị trí tâm của một hình tròn, hãy triển khai hàm `randPoint` để tạo ra một điểm ngẫu nhiên phân phối đều bên trong hình tròn đó.

Implement the `Solution` class:
- `Solution(double radius, double x_center, double y_center)` initializes the object with the radius of the circle `radius` and the position of the center `(x_center, y_center)`.
- `randPoint()` returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array `[x, y]`.

### Example 1:
```text
Input: ["Solution","randPoint","randPoint","randPoint"]
[[1,0,0],[],[],[]]
Output: [null,[-0.02493,-0.38077],[0.82314,0.38945],[0.36572,0.27248]]
```

## Constraints / Ràng buộc
- `0 < radius <= 10^8`
- `-10^7 <= x_center, y_center <= 10^7`
- At most `3 * 10^4` calls will be made to `randPoint`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Polar Coordinates (Correct distribution) / Tọa độ cực (Phân phối đúng)
To generate a point $(x, y)$ uniformly in a circle with radius $R$, we can use polar coordinates $(r, \theta)$.
- $\theta$ is uniformly distributed in $[0, 2\pi]$.
- **Crucial**: $r$ is NOT uniformly distributed in $[0, R]$. Because the area of a circle grows with $r^2$, a linear distribution of $r$ would cause a higher density near the center.
  To get a uniform area distribution, we need the Probability Density Function (PDF) of $r$ to be $f(r) = 2r / R^2$. The Cumulative Distribution Function (CDF) is $F(r) = r^2 / R^2$.
  Using the inverse transform sampling: $r = R \sqrt{U}$, where $U$ is uniform in $[0, 1]$.

Transformation:
$x = x\_center + r \cdot \cos(\theta)$
$y = y\_center + r \cdot \sin(\theta)$

### Alternative: Rejection Sampling / Lấy mẫu loại bỏ
1. Generate $(x, y)$ uniformly in the bounding square $[-R, R] \times [-R, R]$.
2. If $x^2 + y^2 \le R^2$, return the point. Otherwise, reject and repeat.
This is easy but might take more random calls.

### Complexity / Độ phức tạp
- **Time**: O(1).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Square-Rooted Radial Distribution

**Algorithm**:
1.  Sample $\theta$ in $[0, 2\pi]$.
2.  Sample $U$ in $[0, 1]$, then $r = R \cdot \sqrt{U}$.
3.  Combine.

---
