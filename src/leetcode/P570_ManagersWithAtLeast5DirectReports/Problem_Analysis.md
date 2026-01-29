# 570. Managers with at Least 5 Direct Reports / Người Quản Lý Có Ít Nhất 5 Báo Cáo Trực Tiếp

## Problem Description / Mô tả bài toán
Write an SQL query to report the managers with at least **5 direct reports**.
Viết một truy vấn SQL để báo cáo những người quản lý có ít nhất **5 báo cáo trực tiếp**.

Table: `Employee`
```
+-----+-------+------------+-----------+
| id  | name  | department | managerId |
+-----+-------+------------+-----------+
| 101 | John  | A          | null      |
| 102 | Dan   | A          | 101       |
| 103 | James | A          | 101       |
| 104 | Amy   | A          | 101       |
| 105 | Anne  | A          | 101       |
| 106 | Ron   | B          | 101       |
+-----+-------+------------+-----------+
```
Output:
```
+------+
| name |
+------+
| John |
+------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group By and Join / Nhóm Và Tham Gia
1. Count direct reports for each `managerId`.
2. Filter for counts >= 5.
3. Join back to `Employee` table to get the name of the `managerId`.

Query:
```sql
SELECT Name
FROM Employee
WHERE Id IN (
    SELECT ManagerId
    FROM Employee
    GROUP BY ManagerId
    HAVING COUNT(*) >= 5
)
```

### Complexity / Độ phức tạp
- **Time**: Database engine dependent.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Grouping and Filtering

**Algorithm**:
1.  Group employees by `ManagerId`.
2.  Count employees in each group.
3.  Filter groups having >= 5 count.
4.  Retrieve manager names associated with filtered IDs.

---
