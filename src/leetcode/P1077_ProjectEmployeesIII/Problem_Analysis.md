# 1077. Project Employees III / Nhân viên Dự án III

## Problem Description / Mô tả bài toán
Tables `Project`, `Employee`.
Write an SQL query that reports the **most experienced** employees in each project. In case of a tie, report all employees with the maximum experience years.
Viết một truy vấn SQL báo cáo những nhân viên **có kinh nghiệm nhất** trong mỗi dự án. Trong trường hợp hòa nhau, báo cáo tất cả nhân viên có số năm kinh nghiệm tối đa.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions / Hàm Cửa sổ SQL
Use `RANK()` or `DENSE_RANK()` partitioned by `project_id` ordered by `experience_years` DESC.
Select where rank is 1.

Query:
`SELECT project_id, employee_id FROM (SELECT p.project_id, e.employee_id, RANK() OVER (PARTITION BY p.project_id ORDER BY e.experience_years DESC) as rnk FROM Project p JOIN Employee e ON p.employee_id = e.employee_id) t WHERE rnk = 1`

---
