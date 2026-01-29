# 596. Classes More Than 5 Students / Các Lớp Có Hơn 5 Sinh Viên

## Problem Description / Mô tả bài toán
Write an SQL query to report all the classes that have **at least five students**.
Viết một truy vấn SQL để báo cáo tất cả các lớp có **ít nhất năm sinh viên**.

Table: `Courses`
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
Output:
```
+---------+
| class   |
+---------+
| Math    |
+---------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group By + Having / Nhóm + Có (Điều kiện sau nhóm)
1. Group by `class`.
2. Count distinct `student`.
3. Filter `HAVING count >= 5`.

Query:
```sql
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5
```
Note: Problem usually implies students can be duplicated? Or table implies uniqueness?
Usually `(student, class)` is unique or we want distinct students. `COUNT(DISTINCT student)` is safer unless PK is defined as composite.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Grouping Filter

**Algorithm**:
1.  Group table by class.
2.  Count rows in each group.
3.  Retain groups meeting the threshold.

---
