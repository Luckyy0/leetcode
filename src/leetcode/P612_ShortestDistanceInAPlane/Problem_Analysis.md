# 612. Shortest Distance in a Plane / Khoảng Cách Ngắn Nhất Trên Mặt Phẳng

## Problem Description / Mô tả bài toán
Write an SQL query to report the shortest distance between any two points from the `Point2D` table. Round the result to 2 decimal places.
Viết một truy vấn SQL để báo cáo khoảng cách ngắn nhất giữa hai điểm bất kỳ từ bảng `Point2D`. Làm tròn kết quả đến 2 chữ số thập phân.

Table: `Point2D`
```
+-----+-----+
| x   | y   |
+-----+-----+
| -1  | -1  |
| 0   | 0   |
| -1  | -2  |
+-----+-----+
```
The table contains unique points.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Cross Join / Cartesian Product / Tích Descartes
We need `min(sqrt((p1.x - p2.x)^2 + (p1.y - p2.y)^2))`.
Join table with itself.
Condition: `p1 != p2` (or `p1.x != p2.x OR p1.y != p2.y`).
Since `(x, y)` is PK or unique, valid condition is `(p1.x, p1.y) != (p2.x, p2.y)`.
Optimization: To avoid double counting and self-distance, enforce ordering e.g., `p1.x < p2.x OR (p1.x = p2.x AND p1.y < p2.y)`. Or just standard `!=` and take min.

Query:
```sql
SELECT
    ROUND(MIN(SQRT(POW(p1.x - p2.x, 2) + POW(p1.y - p2.y, 2))), 2) AS shortest
FROM
    Point2D p1
JOIN
    Point2D p2
ON
    p1.x != p2.x OR p1.y != p2.y
```

### Complexity / Độ phức tạp
- **Time**: O(N^2).
- **Space**: O(N^2) temporary result.

---

## Analysis / Phân tích

### Approach: Self Join and Euclidean Distance

**Algorithm**:
1.  Join Point2D with itself.
2.  Filter out identical points.
3.  Calculate distance.
4.  Find Minimum.
5.  Round.

---
