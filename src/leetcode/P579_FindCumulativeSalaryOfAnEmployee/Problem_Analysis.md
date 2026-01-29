# 579. Find Cumulative Salary of an Employee / Tìm Lương Tích Lũy Của Một Nhân Viên

## Problem Description / Mô tả bài toán
Write an SQL query to calculate the cumulative salary summary for every employee.
Viết một truy vấn SQL để tính tổng lương tích lũy cho mỗi nhân viên.

The cumulative salary summary for an employee can be calculated as follows:
Tổng lương tích lũy cho một nhân viên có thể được tính như sau:

- For each month that the employee worked, calculate the sum of salaries the employee earned in that **month** and the **previous two months**. (This is the 3-month rolling sum).
- Do not include the **most recent** month (the last month the employee worked) in the result.
- Order result by `id` ASC, then `month` DESC.

Table: `Employee`
```
+----+-------+--------+
| Id | Month | Salary |
+----+-------+--------+
| 1  | 1     | 20     |
| 2  | 1     | 20     |
| 1  | 2     | 30     |
| 1  | 3     | 40     |
| 3  | 2     | 40     |
| 3  | 3     | 60     |
| 1  | 4     | 60     |
+----+-------+--------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Window Functions (Sum Over Range) / Hàm Cửa Sổ (Tổng Trong Phạm Vi)
We need a window function `SUM(Salary) OVER (...)`.
The window is: `PARTITION BY Id ORDER BY Month ROWS BETWEEN 2 PRECEDING AND CURRENT ROW`.
But we need to exclude the **last month** for each employee.

Steps:
1. Calculate the MAX month for each employee.
2. Filter the main table to exclude rows where `Month == Max_Month`.
3. Apply the 3-month rolling sum on the remaining rows.

Query Structure:
```sql
WITH MaxMonth AS (
    SELECT Id, MAX(Month) as mm
    FROM Employee
    GROUP BY Id
)
SELECT E.Id, E.Month,
       SUM(E.Salary) OVER (PARTITION BY E.Id ORDER BY E.Month ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) as Salary
FROM Employee E
JOIN MaxMonth M ON E.Id = M.Id
WHERE E.Month < M.mm
ORDER BY E.Id ASC, E.Month DESC
```

### Complexity / Độ phức tạp
- **Time**: O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Filtered Window Aggregate

**Algorithm**:
1.  Identify max month for each ID.
2.  Filter data to exclude max month.
3.  Compute 3-month rolling sum window.
4.  Order results.

---
