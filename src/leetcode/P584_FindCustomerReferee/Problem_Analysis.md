# 584. Find Customer Referee / Tìm Người Giới Thiệu Khách Hàng

## Problem Description / Mô tả bài toán
Write an SQL query to report the names of the customer that are **not referred by** the customer with `id = 2`.
Viết một truy vấn SQL để báo cáo tên của khách hàng **không được giới thiệu bởi** khách hàng có `id = 2`.

Table: `Customer`
```
+----+------+------------+
| id | name | referee_id |
+----+------+------------+
| 1  | Will | null       |
| 2  | Jane | null       |
| 3  | Alex | 2          |
| 4  | Bill | null       |
| 5  | Zack | 1          |
| 6  | Mark | 2          |
+----+------+------------+
```
Output:
```
+------+
| name |
+------+
| Will |
| Jane |
| Bill |
| Zack |
+------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### NULL Handling / Xử Lý NULL
Standard logic `referee_id != 2` will exclude rows where `referee_id` is `NULL`.
We must check `referee_id != 2 OR referee_id IS NULL`.

Query:
```sql
SELECT name
FROM Customer
WHERE referee_id != 2 OR referee_id IS NULL
```
Alternatively:
```sql
SELECT name
FROM Customer
WHERE COALESCE(referee_id, 0) != 2
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Conditional Filtering with Null Check

**Algorithm**:
1.  Select names.
2.  Filter where referee_id is NOT 2.
3.  Explicitly include NULL referee_id cases.

---
