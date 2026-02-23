# Result for Managers with at Least 5 Direct Reports
# *Kết quả cho bài toán Quản lý có ít nhất 5 Nhân viên cấp dưới*

## Description
## *Mô tả*

**SQL Schema**

Table: `Employee`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
id is the primary key column for this table.
Each row of this table indicates the name of an employee, their department, and the id of their manager.
If managerId is null, then the employee does not have a manager.
No employee will be the manager of themself.
```

Write an SQL query to report the managers who have at least **five direct reports**.
*Viết một câu lệnh SQL để báo cáo những người quản lý có ít nhất **năm nhân viên cấp dưới trực tiếp**.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Employee table:
```
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | None      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
```
**Output:** 
```
+------+
| name |
+------+
| John |
+------+
```

## Constraints:
## *Ràng buộc:*

*   There is at least one employee in the table.
