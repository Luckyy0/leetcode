# 812. Largest Triangle Area / Diện tích Tam giác Lớn nhất

## Problem Description / Mô tả bài toán
Given an array of points on the X-Y plane `points`, return the area of the largest triangle that can be formed by any three different points.
Cho một mảng các điểm trên mặt phẳng X-Y `points`, hãy trả về diện tích của tam giác lớn nhất có thể được tạo thành bởi ba điểm khác nhau bất kỳ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Shoelace Formula / Công thức Shoelace
The area of a triangle with vertices $(x_1, y_1), (x_2, y_2), (x_3, y_3)$ is:
Diện tích của một hình tam giác có các đỉnh $(x_1, y_1), (x_2, y_2), (x_3, y_3)$ là:
$$Area = \frac{1}{2} |x_1(y_2 - y_3) + x_2(y_3 - y_1) + x_3(y_1 - y_2)|$$

Algorithm:
1. iterate through all combinations of 3 points (triple loop).
2. Calculate area for each.
3. Keep track of maximum.

Note: More optimized solutions exist using Convex Hull + Rotating Calipers, but for $N \le 50$, $O(N^3)$ is sufficient.

### Complexity / Độ phức tạp
- **Time**: O(N^3).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Brute Force Combination
Exhaustively test all possible triplets of points. The shoelace formula provides a clean way to calculate area without involving complex trigonometry.
Thử nghiệm triệt để tất cả các bộ ba điểm có thể. Công thức shoelace cung cấp một cách rõ ràng để tính diện tích mà không cần đến toán lượng giác phức tạp.

---
