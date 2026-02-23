# Result for Generate Random Point in a Circle
# *Kết quả cho bài toán Tạo Điểm Ngẫu nhiên trong Hình tròn*

## Description
## *Mô tả*

Given the radius and the position of the center of a circle, implement the function `randPoint` which generates a uniform random point inside the circle.
*Cho bán kính và vị trí tâm của một hình tròn, hãy triển khai hàm `randPoint` để tạo ra một điểm ngẫu nhiên đồng nhất bên trong hình tròn.*

Implement the `Solution` class:
- `Solution(double radius, double x_center, double y_center)` initializes the object with the radius of the circle `radius` and the position of the center `(x_center, y_center)`.
- `double[] randPoint()` returns a random point inside the circle. A point on the circumference of the circle is considered to be in the circle. The answer is returned as an array `[x, y]`.

## Example 1:
## *Ví dụ 1:*

**Input:**
`["Solution", "randPoint", "randPoint", "randPoint"]`
`[[1.0, 0.0, 0.0], [], [], []]`
**Output:** `[null, [-0.02493, -0.38077], [0.82314, 0.38115], [0.35163, -0.71008]]`

## Constraints:
## *Ràng buộc:*

*   `0 < radius <= 10^8`
*   `-10^7 <= x_center, y_center <= 10^7`
*   At most `3 * 10^4` calls will be made to `randPoint`.
