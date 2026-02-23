# Result for Count Student Number in Departments
# *Kết quả cho bài toán Đếm Số lượng Sinh viên trong các Khoa*

## Description
## *Mô tả*

**SQL Schema**

Table: `Student`
```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| student_id   | int     |
| student_name | varchar |
| gender       | varchar |
| dept_id      | int     |
+--------------+---------+
student_id is the primary key column for this table.
dept_id is a foreign key to dept_id from the Department table.
Each row of this table indicates the name of a student, their gender, and the id of their department.
```

Table: `Department`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| dept_id     | int     |
| dept_name   | varchar |
+-------------+---------+
dept_id is the primary key column for this table.
Each row of this table contains the id and the name of a department.
```

Write an SQL query to report the respective department name and number of students majoring in each department for all departments in the `Department` table (even ones with no current students).
*Viết một truy vấn SQL để báo cáo tên khoa tương ứng và số lượng sinh viên theo học ở mỗi khoa cho tất cả các khoa trong bảng `Department` (ngay cả những khoa không có sinh viên hiện tại).*

Return the result table **ordered** by `student_number` **descending**. In case of a tie, order them by `dept_name` **ascending**.
*Trả về bảng kết quả được **sắp xếp** theo `student_number` **giảm dần**. Trong trường hợp bằng nhau, hãy sắp xếp chúng theo `dept_name` **tăng dần**.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Student table:
```
+------------+--------------+--------+---------+
| student_id | student_name | gender | dept_id |
+------------+--------------+--------+---------+
| 1          | Jack         | M      | 1       |
| 2          | Jane         | F      | 1       |
| 3          | Mark         | M      | 2       |
+------------+--------------+--------+---------+
```
Department table:
```
+---------+-------------+
| dept_id | dept_name   |
+---------+-------------+
| 1       | Engineering |
| 2       | Science     |
| 3       | Law         |
+---------+-------------+
```
**Output:** 
```
+-------------+----------------+
| dept_name   | student_number |
+-------------+----------------+
| Engineering | 2              |
| Science     | 1              |
| Law         | 0              |
+-------------+----------------+
```

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints on the number of departments or students.
Steps: 7247-7249
