# 1076. Project Employees II / Nhân viên Dự án II

## Problem Description / Mô tả bài toán
Table `Project` and `Employee` (same as P1075).
Write an SQL query that reports all the projects that have the most employees.
Viết một truy vấn SQL báo cáo tất cả các dự án có nhiều nhân viên nhất.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Window Functions / SQL Gộp và Hàm Cửa sổ
Count employees per project.
Find the max count.
Select projects with that count.

Query logic:
Method 1: Subquery for max.
`SELECT project_id FROM Project GROUP BY project_id HAVING COUNT(employee_id) = (SELECT MAX(cnt) FROM (SELECT COUNT(employee_id) as cnt FROM Project GROUP BY project_id) t)`

Method 2: `RANK()` or `TOP 1 WITH TIES`.
`SELECT TOP 1 WITH TIES project_id FROM Project GROUP BY project_id ORDER BY COUNT(employee_id) DESC`
(In T-SQL).

---
