# 574. Winning Candidate / Ứng Viên Chiến Thắng

## Problem Description / Mô tả bài toán
Write an SQL query to report the name of the winning candidate (i.e., the candidate who got the largest number of votes).
Viết một truy vấn SQL để báo cáo tên của ứng viên chiến thắng (tức là ứng viên nhận được số phiếu bầu lớn nhất).

Table: `Candidate`
```
+-----+---------+
| id  | name    |
+-----+---------+
| 1   | A       |
| 2   | B       |
| 3   | C       |
| 4   | D       |
| 5   | E       |
+-----+---------+
```
Table: `Vote`
```
+-----+--------------+
| id  | candidateId  |
+-----+--------------+
| 1   | 2            |
| 2   | 4            |
| 3   | 3            |
| 4   | 2            |
| 5   | 5            |
+-----+--------------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group By + Order By Limit / Nhóm + Sắp Xếp Giới Hạn
1. Count votes for each candidate in `Vote` table.
2. Order by count descending.
3. Take top 1 (`LIMIT 1`).
4. Join with `Candidate` to get name.

Query:
```sql
SELECT name
FROM Candidate
WHERE id = (
    SELECT candidateId
    FROM Vote
    GROUP BY candidateId
    ORDER BY COUNT(*) DESC
    LIMIT 1
)
```

### Complexity / Độ phức tạp
- **Time**: O(N).
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Vote Counting Aggregation

**Algorithm**:
1.  Group votes by candidate.
2.  Count occurrences.
3.  Sort by count descending.
4.  Limit 1 to find winner ID.
5.  Retrieve winner name.

---
