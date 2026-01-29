# 615. Average Salary: Departments VS Company / Lương Trung Bình: Các Phòng Ban VS Công Ty

## Problem Description / Mô tả bài toán
Write an SQL query to report the comparison result (higher/lower/same) of the average salary of employees in a department to the company's average salary for each month.
Viết một truy vấn SQL để báo cáo kết quả so sánh (cao hơn/thấp hơn/giống như) của mức lương trung bình của nhân viên trong một phòng ban so với mức lương trung bình của công ty cho mỗi tháng.

Table: `Salary`
```
+----+-------------+--------+
| id | employee_id | amount | pay_date |
+----+-------------+--------+
```
Table: `Employee`
```
+-------------+---------------+
| employee_id | department_id | 
+-------------+---------------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Aggregation with Join and Window Functions / Tổng Hợp Với Tham Gia và Hàm Cửa Sổ
1. Calculate Company Month Average.
2. Calculate Department Month Average.
3. Compare.

Steps:
1. `JOIN Salary` and `Employee` to get `pay_date`, `amount`, `dept_id`.
2. Format `pay_date` to `YYYY-MM`.
3. Compute `avg_salary` per month (Window/Group).
4. Compute `avg_salary` per month/dept (Group).
5. Join or use derived tables to compare.

Query Structure:
```sql
WITH MonthlyStats AS (
    SELECT 
        LEFT(pay_date, 7) AS pay_month,
        department_id,
        AVG(amount) OVER(PARTITION BY LEFT(pay_date, 7)) AS company_avg,
        AVG(amount) OVER(PARTITION BY LEFT(pay_date, 7), department_id) AS dept_avg
    FROM Salary s JOIN Employee e ON s.employee_id = e.employee_id
)
SELECT DISTINCT pay_month, department_id,
    CASE
        WHEN dept_avg > company_avg THEN 'higher'
        WHEN dept_avg < company_avg THEN 'lower'
        ELSE 'same'
    END AS comparison
FROM MonthlyStats
ORDER BY pay_month DESC, department_id;
```

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Window Functions for Multi-Level Aggregation

**Algorithm**:
1.  Join tables.
2.  Extract month.
3.  Calculate Company Average (Partition by Month).
4.  Calculate Dept Average (Partition by Month, Dept).
5.  Compare values row by row using Case.
6.  Select distinct results.

---
