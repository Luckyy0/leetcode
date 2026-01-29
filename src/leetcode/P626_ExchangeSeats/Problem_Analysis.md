# 626. Exchange Seats / Đổi Chỗ Ngồi

## Problem Description / Mô tả bài toán
Write an SQL query to swap the seat id of every two consecutive students. If the number of students is odd, the id of the last student is not swapped.
Viết một truy vấn SQL để hoán đổi id chỗ ngồi của mỗi hai sinh viên liên tiếp. Nếu số lượng sinh viên là số lẻ, id của sinh viên cuối cùng không được hoán đổi.

Return the result table ordered by `id` in ascending order.
Trả về bảng kết quả được sắp xếp theo `id` theo thứ tự tăng dần.

Table: `Seat`
```
+----+---------+
| id | student |
+----+---------+
| 1  | Abbot   |
| 2  | Doris   |
| 3  | Emerson |
| 4  | Green   |
| 5  | Jeames  |
+----+---------+
```
Output:
```
+----+---------+
| id | student |
+----+---------+
| 1  | Doris   |
| 2  | Abbot   |
| 3  | Green   |
| 4  | Emerson |
| 5  | Jeames  |
+----+---------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### CONDITIONAL ID SWAP / HOÁN ĐỔI ID CÓ ĐIỀU KIỆN
We need to generate a new `id` based on the old `id`.
- If `id` is odd and not the last one -> `id + 1`.
- If `id` is even -> `id - 1`.
- If `id` is odd and is the last one -> `id`.

Query:
```sql
SELECT 
    CASE 
        WHEN id % 2 = 1 AND id != (SELECT MAX(id) FROM Seat) THEN id + 1
        WHEN id % 2 = 0 THEN id - 1
        ELSE id
    END AS id,
    student
FROM Seat
ORDER BY id ASC
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Conditional Projection

**Algorithm**:
1.  Calculate new ID using CASE WHEN.
2.  Handle the edge case of the last odd ID.
3.  Order results.

---
