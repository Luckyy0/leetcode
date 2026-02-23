# Result for Shortest Distance in a Plane
# *Kết quả cho bài toán Khoảng cách Ngắn nhất trên Mặt phẳng*

## Description
## *Mô tả*

**SQL Schema**

Table: `Point2D`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
| y           | int  |
+-------------+------+
(x, y) is the primary key column for this table.
Each row of this table indicates the position of a point on the 2D plane.
```

The distance between two points $P_1(x_1, y_1)$ and $P_2(x_2, y_2)$ is $\sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}$.
*Khoảng cách giữa hai điểm $P_1(x_1, y_1)$ và $P_2(x_2, y_2)$ là $\sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}$.*

Write an SQL query to report the shortest distance between any two points from the `Point2D` table. Round the distance to **two decimal places**.
*Viết một truy vấn SQL để báo cáo khoảng cách ngắn nhất giữa bất kỳ hai điểm nào từ bảng `Point2D`. Làm tròn khoảng cách đến **hai chữ số thập phân**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Point2D table:
```
+----+----+
| x  | y  |
+----+----+
| -1 | -1 |
| 0  | 0  |
| -1 | -2 |
+----+----+
```
**Output:** 
```
+----------+
| shortest |
+----------+
| 1.00     |
+----------+
```
**Explanation:** The shortest distance is 1.00 from point (-1,-1) to (-1,-2).

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
