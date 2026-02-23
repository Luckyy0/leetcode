# Result for Human Traffic of Stadium
# *Kết quả cho bài toán Lưu lượng Người tại Sân vận động*

## Description
## *Mô tả*

**SQL Schema**

Table: `Stadium`
```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
visit_date is the primary key for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
As the id increases, the date increases as well.
```

Write an SQL query to display the records with three or more rows with **consecutive** `id`'s, and the number of people is greater than or equal to 100 for each.
*Viết một truy vấn SQL để hiển thị các bản ghi có ba hàng trở lên có `id` **liên tiếp**, và số lượng người lớn hơn hoặc bằng 100 cho mỗi hàng đó.*

Return the result table ordered by `visit_date` in **ascending order**.
*Trả về bảng kết quả được sắp xếp theo `visit_date` theo thứ tự **tăng dần**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Stadium table:
```
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 1    | 2017-01-01 | 10        |
| 2    | 2017-01-02 | 109       |
| 3    | 2017-01-03 | 150       |
| 4    | 2017-01-04 | 99        |
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
```
**Output:** 
```
+------+------------+-----------+
| id   | visit_date | people    |
+------+------------+-----------+
| 5    | 2017-01-05 | 145       |
| 6    | 2017-01-06 | 1455      |
| 7    | 2017-01-07 | 199       |
| 8    | 2017-01-08 | 188       |
+------+------------+-----------+
```
**Explanation:** 
The ids 5, 6, 7, and 8 have consecutive ids and each of them has >= 100 people. Note that ids 2 and 3 are not included because we need at least three consecutive ids.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
