# 619. Biggest Single Number / Số Đơn Lẻ Lớn Nhất

## Problem Description / Mô tả bài toán
Write an SQL query to report the largest **single number**. If there is no single number, report `null`.
Viết một truy vấn SQL để báo cáo **số đơn lẻ** lớn nhất. Nếu không có số đơn lẻ nào, báo cáo `null`.

A single number is a number that appeared only once in the `MyNumbers` table.
Một số đơn lẻ là một số chỉ xuất hiện một lần trong bảng `MyNumbers`.

Table: `MyNumbers`
```
+-----+
| num |
+-----+
| 8   |
| 8   |
| 3   |
| 3   |
| 1   |
| 4   |
| 5   |
| 6   |
+-----+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery Group By / Subquery Nhóm
1. Find numbers with count 1.
2. Select Max of those numbers.
3. Ensure NULL if empty (MAX usually returns NULL on empty set, so safe).

Query:
```sql
SELECT MAX(num) as num
FROM (
    SELECT num
    FROM MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
) t
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Group and Aggregate

**Algorithm**:
1.  Group by number.
2.  Filter count = 1.
3.  Select MAX from the filtered list.

---
