# 580. Count Student Number in Departments / Đếm Số Lượng Sinh Viên Trong Các Khoa

## Problem Description / Mô tả bài toán
Write an SQL query to report the respective department name and number of students majoring in each department for all departments in the `Department` table (even ones with no students).
Viết một truy vấn SQL để báo cáo tên khoa tương ứng và số lượng sinh viên chuyên ngành trong mỗi khoa cho tất cả các khoa trong bảng `Department` (ngay cả những khoa không có sinh viên).

Order the result table by `student_number` in **descending** order. In case of a tie, order them by `dept_name` alphabetically.
Sắp xếp bảng kết quả theo `khối lượng sinh viên` theo thứ tự **giảm dần**. Trong trường hợp hòa, hãy sắp xếp chúng theo `dept_name` theo thứ tự bảng chữ cái.

Table: `Student`
```
+--------------+---------+
| student_id   | student_name | gender | dept_id |
+--------------+---------+
| 1            | Jack    | M      | 1       |
| 2            | Jane    | F      | 1       |
| 3            | Mark    | M      | 2       |
+--------------+---------+
```

Table: `Department`
```
+---------+-------------+
| dept_id | dept_name   |
+---------+-------------+
| 1       | Engineering |
| 2       | Science     |
| 3       | Law         |
+---------+-------------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Right Join or Left Join + Group By / Right Join hoặc Left Join + Nhóm
We want to keep all departments (`Department` table). So we `SELECT ... FROM Department LEFT JOIN Student`.
Then `GROUP BY dept_id`.
Count: `COUNT(student_id)`. Do not use `COUNT(*)` because for departments with no students, the join produces one row with NULLs, `COUNT(*)` would be 1, but `COUNT(student_id)` is 0.

Query:
```sql
SELECT D.dept_name, COUNT(S.student_id) as student_number
FROM Department D
LEFT JOIN Student S ON D.dept_id = S.dept_id
GROUP BY D.dept_name
ORDER BY student_number DESC, D.dept_name ASC
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Left Join Aggregation

**Algorithm**:
1.  Left join Department with Student.
2.  Group by department.
3.  Count distinct student IDs.
4.  Order by count descending, name ascending.

---
