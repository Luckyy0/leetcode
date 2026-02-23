# Result for Consecutive Available Seats
# *Kết quả cho bài toán Các Ghế Trống Liên tiếp*

## Description
## *Mô tả*

**SQL Schema**

Table: `Cinema`
```
+-------------+------+
| Column Name | Type |
+-------------+------+
| seat_id     | int  |
| free        | bool |
+-------------+------+
seat_id is an auto-increment primary key column for this table.
Each row of this table indicates whether the i-th seat is free or not. 1 means free while 0 means occupied.
```

Write an SQL query to report all the consecutive available seats in the cinema.
*Viết một truy vấn SQL để báo cáo tất cả các ghế trống liên tiếp trong rạp chiếu phim.*

Return the result table ordered by `seat_id` in **ascending order**.
*Trả về bảng kết quả được sắp xếp theo `seat_id` theo thứ tự **tăng dần**.*

The test cases are generated so that more than two seats are consecutively available.
*Các trường hợp kiểm thử được tạo ra sao cho có nhiều hơn hai ghế trống liên tiếp.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Cinema table:
```
+---------+------+
| seat_id | free |
+---------+------+
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
+---------+------+
```
**Output:** 
```
+---------+
| seat_id |
+---------+
| 3       |
| 4       |
| 5       |
+---------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
