# Result for Triangle Judgement
# *Kết quả cho bài toán Đánh giá Hình tam giác*

## Description
## *Mô tả*

**SQL Schema**

Table: `Triangle`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| x           | int  |
| y           | int  |
| z           | int  |
+-------------+------+
(x, y, z) is the primary key column for this table.
Each row of this table contains the lengths of three line segments.
```

Write an SQL query to report for every three line segments whether they can form a triangle.
*Viết một truy vấn SQL để báo cáo cho mỗi ba đoạn thẳng xem chúng có thể tạo thành một hình tam giác hay không.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Triangle table:
```
+----+----+----+
| x  | y  | z  |
+----+----+----+
| 13 | 15 | 30 |
| 10 | 20 | 15 |
+----+----+----+
```
**Output:** 
```
+----+----+----+----------+
| x  | y  | z  | triangle |
+----+----+----+----------+
| 13 | 15 | 30 | No       |
| 10 | 20 | 15 | Yes      |
+----+----+----+----------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
