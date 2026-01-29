# 620. Not Boring Movies / Phim Không Nhàm Chán

## Problem Description / Mô tả bài toán
Write an SQL query to report the movies with an odd-numbered ID and a description that is not `"boring"`.
Viết một truy vấn SQL để báo cáo các bộ phim có ID số lẻ và mô tả không phải là `"boring"`.

Return the result table ordered by `rating` in **descending** order.
Trả về bảng kết quả được sắp xếp theo `rating` theo thứ tự **giảm dần**.

Table: `Cinema`
```
+---------+-----------+--------------+-----------+
| id      | movie     | description  | rating    |
+---------+-----------+--------------+-----------+
| 1       | War       | great 3D     | 8.9       |
| 2       | Science   | fiction      | 8.5       |
| 3       | irish     | boring       | 6.2       |
| 4       | Ice song  | Fantacy      | 8.6       |
| 5       | House card| Interesting  | 9.1       |
+---------+-----------+--------------+-----------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Modulo Operator / Toán Tử Modulo
Conditions:
1. `id % 2 = 1` (Odd).
2. `description != 'boring'`.
Order by `rating DESC`.

Query:
```sql
SELECT *
FROM Cinema
WHERE id % 2 = 1 AND description != 'boring'
ORDER BY rating DESC
```

### Complexity / Độ phức tạp
- **Time**: O(N log N) (sort).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Filter and Sort

**Algorithm**:
1.  Filter by ID modulo check.
2.  Filter by description string check.
3.  Sort solution.

---
