# Result for Shortest Distance in a Line
# *Kết quả cho bài toán Khoảng cách Ngắn nhất trên một Đường thẳng*

## Description
## *Mô tả*

**SQL Schema**

Table: `Point`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
+-------------+------+
x is the primary key column for this table.
Each row of this table indicates the position of a point on the 1D line.
```

Write an SQL query to report the shortest distance between any two points from the `Point` table.
*Viết một truy vấn SQL để báo cáo khoảng cách ngắn nhất giữa hai điểm bất kỳ từ bảng `Point`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Point table:
```
+----+
| x  |
+----+
| -1 |
| 0  |
| 2  |
+----+
```
**Output:** 
```
+----------+
| shortest |
+----------+
| 1        |
+----------+
```
**Explanation:** The shortest distance is 1 between points -1 and 0.

---

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
