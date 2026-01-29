# 577. Employee Bonus / Tiền Thưởng Nhân Viên

## Problem Description / Mô tả bài toán
Write an SQL query to report the name and bonus amount of each employee with a bonus less than `1000`.
Viết một truy vấn SQL để báo cáo tên và số tiền thưởng của mỗi nhân viên có tiền thưởng ít hơn `1000`.

Table: `Employee`
```
+-------+--------+-----------+--------+
| empId | name   | supervisor| salary |
+-------+--------+-----------+--------+
| 3     | Brad   | null      | 4000   |
| 1     | John   | 3         | 1000   |
| 2     | Dan    | 3         | 2000   |
| 4     | Thomas | 3         | 4000   |
+-------+--------+-----------+--------+
```

Table: `Bonus`
```
+-------+-------+
| empId | bonus |
+-------+-------+
| 2     | 500   |
| 4     | 2000  |
+-------+-------+
```

Output:
```
+------+-------+
| name | bonus |
+------+-------+
| Brad | null  |
| John | null  |
| Dan  | 500   |
+------+-------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Left Join / Left Join
We need strictly all employees whose bonus is `< 1000` OR whose bonus is `NULL` (did not receive one).
When joining `Employee` (Left) with `Bonus` (Right), employees without a bonus record will have `Bonus.bonus = NULL`.
SQL logic: `WHERE bonus < 1000 OR bonus IS NULL`.

Query:
```sql
SELECT E.name, B.bonus
FROM Employee E
LEFT JOIN Bonus B ON E.empId = B.empId
WHERE B.bonus < 1000 OR B.bonus IS NULL
```

### Complexity / Độ phức tạp
- **Time**: Depends on DB.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Left Join with NULL Check

**Algorithm**:
1.  Perform LEFT JOIN from Employee to Bonus.
2.  Filter rows where bonus < 1000.
3.  Include rows where bonus IS NULL (no record).

---
