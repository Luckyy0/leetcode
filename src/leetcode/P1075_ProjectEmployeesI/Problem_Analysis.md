# 1075. Project Employees I / Nhân viên Dự án I

## Problem Description / Mô tả bài toán
Table `Project`: `project_id`, `employee_id`.
Table `Employee`: `employee_id`, `name`, `experience_years`.

Write an SQL query that reports the average experience years of all the employees for each project, rounded to 2 digits.
Viết một truy vấn SQL báo cáo số năm kinh nghiệm trung bình của tất cả nhân viên cho từng dự án, làm tròn đến 2 chữ số.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Rounding / SQL Gộp và Làm tròn
Join `Project` and `Employee`.
Group by `project_id`.
Avg `experience_years`.
Round to 2 decimal places.

Query:
`SELECT p.project_id, ROUND(AVG(CAST(e.experience_years AS DECIMAL)), 2) AS average_years ...`

Use `AVG` generally. Note implementation specific float handling.

---
