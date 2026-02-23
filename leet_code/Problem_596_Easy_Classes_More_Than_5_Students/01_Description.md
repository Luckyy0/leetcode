# Result for Classes More Than 5 Students
# *Kết quả cho bài toán Các Lớp có nhiều hơn 5 Sinh viên*

## Description
## *Mô tả*

**SQL Schema**

Table: `Courses`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| student     | varchar |
| class       | varchar |
+-------------+---------+
(student, class) is the primary key column for this table.
Each row of this table indicates the name of a student and the class in which they are enrolled.
```

Write an SQL query to report all the classes that have **at least five students**.
*Viết một truy vấn SQL để báo cáo tất cả các lớp có **ít nhất năm sinh viên**.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Courses table:
```
+---------+----------+
| student | class    |
+---------+----------+
| A       | Math     |
| B       | English  |
| C       | Math     |
| D       | Biology  |
| E       | Math     |
| F       | Computer |
| G       | Math     |
| H       | Math     |
| I       | Math     |
+---------+----------+
```
**Output:** 
```
+---------+
| class   |
+---------+
| Math    |
+---------+
```
**Explanation:** 
- Math has 6 students, so we include it.
- English has 1 student, so we do not include it.
- Biology has 1 student, so we do not include it.
- Computer has 1 student, so we do not include it.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.
