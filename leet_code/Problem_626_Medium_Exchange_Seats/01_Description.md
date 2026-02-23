# Result for Exchange Seats
# *Kết quả cho bài toán Đổi chỗ ngồi*

## Description
## *Mô tả*

**SQL Schema**

Table: `Seat`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| student     | varchar |
+-------------+---------+
id is the primary key column for this table.
Each row of this table indicates the name and the ID of a student.
id is a continuous increment.
```

Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
*Viết một truy vấn SQL để hoán đổi id chỗ ngồi của mỗi hai sinh viên liên tiếp. Nếu số lượng sinh viên là lẻ, id của sinh viên cuối cùng sẽ không được hoán đổi.*

Return the result table ordered by `id` in **ascending order**.
*Trả về bảng kết quả được sắp xếp theo `id` theo thứ tự **tăng dần**.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
Seat table:
```
+----+---------+
| id | student |
+----+---------+
| 1  | Abbot   |
| 2  | Doris   |
| 3  | Emerson |
| 4  | Green   |
| 5  | Jeames  |
+----+---------+
```
**Output:** 
```
+----+---------+
| id | student |
+----+---------+
| 1  | Doris   |
| 2  | Abbot   |
| 3  | Green   |
| 4  | Emerson |
| 5  | Jeames  |
+----+---------+
```
**Explanation:** 
Note that if the number of students is 5, which is odd, the last student Jeames is still has the id = 5.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
