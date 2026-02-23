# Result for Find Customer Referee
# *Kết quả cho bài toán Tìm Người giới thiệu Khách hàng*

## Description
## *Mô tả*

**SQL Schema**

Table: `Customer`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| referee_id  | int     |
+-------------+---------+
id is the primary key column for this table.
Each row of this table indicates the id of a customer, their name, and the id of the customer who referred them.
```

Write an SQL query to report the names of the customer that are **not referred by** the customer with `id = 2`.
*Viết một truy vấn SQL để báo cáo tên của những khách hàng **không được giới thiệu bởi** khách hàng có `id = 2`.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Customer table:
```
+----+------+------------+
| id | name | referee_id |
+----+------+------------+
| 1  | Will | null       |
| 2  | Jane | null       |
| 3  | Alex | 2          |
| 4  | Bill | null       |
| 5  | Zack | 1          |
| 6  | Mark | 2          |
+----+------+------------+
```
**Output:** 
```
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
