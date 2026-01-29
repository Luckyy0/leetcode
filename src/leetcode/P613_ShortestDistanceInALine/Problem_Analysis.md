# 613. Shortest Distance in a Line / Khoảng Cách Ngắn Nhất Trên Một Đường Thẳng

## Problem Description / Mô tả bài toán
Write an SQL query to report the shortest distance between any two points from the `Point` table.
Viết một truy vấn SQL để báo cáo khoảng cách ngắn nhất giữa hai điểm bất kỳ từ bảng `Point`.

Table: `Point`
```
+-----+
| x   |
+-----+
| -1  |
| 0   |
| 2   |
+-----+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Self Join or Window Function / Tự Tham Gia hoặc Hàm Cửa Sổ
Join: `ABS(p1.x - p2.x)` where `p1.x != p2.x`. Min of that.
Window: Order by x. Compute `x - LAG(x)`. Min of that.
Window func is usually O(N log N) vs Join O(N^2).
Given small constraints usually, join is fine. For scale, window is better.

Query (Join):
```sql
SELECT MIN(ABS(p1.x - p2.x)) as shortest
FROM Point p1 JOIN Point p2 ON p1.x != p2.x
```
Query (Window - simpler logic conceptually):
```sql
WITH Sorted AS (
    SELECT x, LAG(x) OVER (ORDER BY x) as prev_x
    FROM Point
)
SELECT MIN(x - prev_x) as shortest
FROM Sorted
WHERE prev_x IS NOT NULL
```

### Complexity / Độ phức tạp
- **Time**: Join O(N^2), Window O(N log N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Self Join

**Algorithm**:
1.  Join Point with itself.
2.  Condition p1.x != p2.x.
3.  Min of ABS difference.

---
