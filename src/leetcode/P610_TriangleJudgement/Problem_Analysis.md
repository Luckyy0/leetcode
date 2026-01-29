# 610. Triangle Judgement / Đánh Giá Tam Giác

## Problem Description / Mô tả bài toán
Write an SQL query to report for every three line segments whether they can form a triangle.
Viết một truy vấn SQL để báo cáo cho mỗi ba đoạn thẳng xem chúng có thể tạo thành một tam giác hay không.

Table: `Triangle`
```
+----+----+----+
| x  | y  | z  |
+----+----+----+
| 13 | 15 | 30 |
| 10 | 20 | 15 |
+----+----+----+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Triangle Inequality / Bất Đẳng Thức Tam Giác
Three segments x, y, z form a triangle if and only if:
- `x + y > z`
- `x + z > y`
- `y + z > x`

If so, return "Yes", else "No".

Query:
```sql
SELECT x, y, z,
    CASE 
        WHEN x + y > z AND x + z > y AND y + z > x THEN 'Yes'
        ELSE 'No' -- or 'No'
    END AS triangle
FROM Triangle
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Conditional Logic

**Algorithm**:
1.  Check triangular inequality for each row.
2.  Output Yes/No accordingly.

---
