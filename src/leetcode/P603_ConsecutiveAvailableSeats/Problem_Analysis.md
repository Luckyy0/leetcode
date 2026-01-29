# 603. Consecutive Available Seats / Ghế Trống Liên Tiếp

## Problem Description / Mô tả bài toán
Several friends at a cinema ticket office would like to reserve **consecutive** available seats.
Một số người bạn tại phòng vé rạp chiếu phim muốn đặt trước các ghế trống **liên tiếp**.

Can you help to query all the consecutive available seats order by the seat_id using the following `Cinema` table?
Bạn có thể giúp truy vấn tất cả các ghế trống liên tiếp được sắp xếp theo seat_id bằng cách sử dụng bảng `Cinema` sau không?

Table: `Cinema`
```
+---------+------+
| seat_id | free |
+---------+------+
| 1       | 1    |
| 2       | 0    |
| 3       | 1    |
| 4       | 1    |
| 5       | 1    |
+---------+------+
```
Output:
```
+---------+
| seat_id |
+---------+
| 3       |
| 4       |
| 5       |
+---------+
```
`free` column: 1 means free, 0 means occupied.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Self Join / Tự Tham Gia
We want seats `a` where `a.free = 1` AND (`(a.id - 1 is free)` OR `(a.id + 1 is free)`).
Consecutive means a block of size >= 2.
So any free seat adjacent to another free seat is part of a consecutive block.

Query:
```sql
SELECT DISTINCT a.seat_id
FROM Cinema a JOIN Cinema b
ON ABS(a.seat_id - b.seat_id) = 1
WHERE a.free = 1 AND b.free = 1
ORDER BY a.seat_id;
```

### Complexity / Độ phức tạp
- **Time**: O(N log N) (sort).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Self Join Adjacency Check

**Algorithm**:
1.  Join table with itself on `id` difference of 1.
2.  Filter for both sides being free.
3.  Select distinct IDs.
4.  Order by ID.

---
