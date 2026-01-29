# 595. Big Countries / Các Quốc Gia Lớn

## Problem Description / Mô tả bài toán
Write an SQL query to report the name, population, and area of the big countries.
Viết một truy vấn SQL để báo cáo tên, dân số và diện tích của các quốc gia lớn.

A country is considered big if:
- it has an area of at least three million (i.e., `3000000 km2`), or
- it has a population of at least twenty-five million (i.e., `25000000`).

Table: `World`
```
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| name        | varchar |
| continent   | varchar |
| area        | int     |
| population  | int     |
| gdp         | bigint  |
+-------------+---------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Conditional Selection / Lựa Chọn Có Điều Kiện
Simple `WHERE` clause with `OR`.
`area >= 3000000 OR population >= 25000000`.

Query:
```sql
SELECT name, population, area
FROM World
WHERE area >= 3000000 OR population >= 25000000
```
Note: Some people suggest `UNION` is faster than `OR` in some DBs if indexes are separate, but `OR` is standard.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Filter

**Algorithm**:
1.  Select columns.
2.  Filter based on area or population threshold.

---
