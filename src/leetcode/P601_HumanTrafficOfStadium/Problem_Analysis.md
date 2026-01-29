# 601. Human Traffic of Stadium / Lưu Lượng Người Ở Sân Vận Động

## Problem Description / Mô tả bài toán
Write an SQL query to display the records with three or more rows with **consecutive** `id`'s, and the number of people is greater than or equal to 100 for each.
Viết một truy vấn SQL để hiển thị các bản ghi có ba hoặc nhiều hàng có `id` **liên tiếp** và số lượng người lớn hơn hoặc bằng 100 cho mỗi hàng.

Return the result table ordered by `visit_date` in ascending order.
Trả về bảng kết quả được sắp xếp theo `visit_date` theo thứ tự tăng dần.

Table: `Stadium`
```
+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
id is the primary key column for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
No two rows will have the same visit_date, and as the id increases, the dates increase as well.
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Window Functions / Self Join / Hàm Cửa Sổ / Tự Tham Gia
We need to find groups of at least 3 consecutive IDs where `people >= 100`.

Approach 1: Window Functions (`LEAD`, `LAG`).
Filter rows where `people >= 100`.
Then check if `(id+1, id+2)` exist or `(id-1, id+1)` exist or `(id-2, id-1)` exist in the filtered set.
Actually easier:
Use `id - ROW_NUMBER() OVER (ORDER BY id) as grp`.
If IDs are consecutive (1, 2, 3) and filtered by `people >= 100`, their `Row Number` will be (k, k+1, k+2).
Difference `id - row_number` will be constant for a consecutive block.
Group by this difference and filter groups having `COUNT(*) >= 3`.

Approach 2: Self Join.
`S1, S2, S3` where `S1.id + 1 = S2.id` and `S2.id + 1 = S3.id ...`

The `id - ROW_NUMBER()` trick is very standard for "consecutive" problems in SQL.

Algorithm (Gap and Islands):
1.  Filter `Stadium` where `people >= 100`.
2.  Compute `grp = id - ROW_NUMBER() OVER (ORDER BY id)`.
3.  Count rows in each `grp`.
4.  Keep rows where the count of their `grp` is >= 3.
5.  Order by `visit_date`.

### Complexity / Độ phức tạp
- **Time**: O(N log N) (sorting for window function).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Gaps and Islands

**Algorithm**:
1.  Filter rows with >= 100 people.
2.  Assign row numbers to filtered rows.
3.  Calculate difference group identifier (`id - rn`).
4.  Filter groups having count >= 3.
5.  Select original columns.

---
