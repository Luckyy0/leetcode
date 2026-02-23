# Result for Employee Bonus
# *Kết quả cho bài toán Tiền thưởng Nhân viên*

## Description
## *Mô tả*

**SQL Schema**

Table: `Employee`
```
+-------+---------+------------+--------+
| empId | name    | supervisor | salary |
+-------+---------+------------+--------+
| 1     | John    | 3          | 1000   |
| 2     | Dan     | 3          | 2000   |
| 3     | Brad    | null       | 4000   |
| 4     | Thomas  | 3          | 4000   |
+-------+---------+------------+--------+
empId is the primary key column for this table.
Each row of this table indicates the name and the ID of an employee in addition to their salary and the id of their manager.
```

Table: `Bonus`
```
+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
empId is the primary key column for this table.
empId is a foreign key to empId from the Employee table.
Each row of this table contains the id of an employee and their respective bonus.
```

Write an SQL query to report the name and bonus amount of each employee with a bonus **less than 1000**.
*Viết một truy vấn SQL để báo cáo tên và số tiền thưởng của mỗi nhân viên có mức tiền thưởng **nhỏ hơn 1000**.*

Employees with **no bonus** should also be included in the report.
*Những nhân viên **không có tiền thưởng** cũng nên được đưa vào báo cáo.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Employee table:
```
+-------+-------+------------+--------+
| empId | name  | supervisor | salary |
+-------+-------+------------+--------+
| 3     | Brad  | null       | 4000   |
| 1     | John  | 3          | 1000   |
| 2     | Dan   | 3          | 2000   |
| 4     | Thomas| 3          | 4000   |
+-------+-------+------------+--------+
```
Bonus table:
```
+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
```
**Output:** 
```
+------+-------+
| name | bonus |
+------+-------+
| Brad | null  |
| John | null  |
| Dan  | 500   |
+------+-------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific ordering constraints.
