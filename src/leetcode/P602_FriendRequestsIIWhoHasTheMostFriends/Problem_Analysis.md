# 602. Friend Requests II: Who Has the Most Friends / Yêu Cầu Kết Bạn II: Ai Có Nhiều Bạn Nhất

## Problem Description / Mô tả bài toán
Write an SQL query to find the people who have the most friends and the most friends number.
Viết một truy vấn SQL để tìm những người có nhiều bạn nhất và số lượng bạn nhiều nhất.

The friend request could be accepted two ways, either by the sender or the receiver.
Yêu cầu kết bạn có thể được chấp nhận theo hai cách, bởi người gửi hoặc người nhận.

Table: `RequestAccepted`
```
+--------------+-------------+-------------+
| requester_id | accepter_id | accept_date |
+--------------+-------------+-------------+
| 1            | 2           | 2016/06/03  |
| 1            | 3           | 2016/06/08  |
| 2            | 3           | 2016/06/08  |
| 3            | 4           | 2016/06/09  |
+--------------+-------------+-------------+
```
Output:
```
+------+------+
| id   | num  |
+------+------+
| 3    | 3    |
+------+------+
```

Note:
- It is guaranteed there is only 1 person having the most friends.
- The friend request could only be accepted once, which mean there is no multiple records with the same requester_id and accepter_id pair.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Union All + Group By / Hợp Tất Cả + Nhóm
A friendship involves two IDs. Each record `(A, B)` contributes to A's friend count and B's friend count.
1. `SELECT requester_id AS id FROM RequestAccepted`
2. `UNION ALL`
3. `SELECT accepter_id AS id FROM RequestAccepted`
4. Encapsulate in a subquery or CTE.
5. Group by `id` and `COUNT(*)`.
6. Order by count DESC, Limit 1.

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Union and Aggregate

**Algorithm**:
1.  Combine requester and accepter columns into a single list of IDs.
2.  Group by ID.
3.  Count occurrences.
4.  Find maximum.

---
