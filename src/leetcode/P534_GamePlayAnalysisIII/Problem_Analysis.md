# 534. Game Play Analysis III / Phân Tích Lượt Chơi III

## Problem Description / Mô tả bài toán
Write an SQL query to report for each player and date, how many games played **so far** by the player. That is, the total number of games played by the player until that date.
Viết một truy vấn SQL để báo cáo cho mỗi người chơi và ngày, có bao nhiêu trò chơi đã được chơi **cho đến nay** bởi người chơi đó. Tức là, tổng số trò chơi mà người chơi đã chơi cho đến ngày đó.

The `Activity` table schema is the same as previous problems.
Lược đồ bảng `Activity` giống như các bài toán trước.

### Example:
Input:
```text
+-----------+------------+--------------+
| player_id | event_date | games_played |
+-----------+------------+--------------+
| 1         | 2016-03-01 | 5            |
| 1         | 2016-05-02 | 6            |
...
```
Output:
```text
+-----------+------------+---------------------+
| player_id | event_date | games_played_so_far |
+-----------+------------+---------------------+
| 1         | 2016-03-01 | 5                   |
| 1         | 2016-05-02 | 11                  | (5 + 6)
...
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions / Hàm cửa sổ SQL
The standard way to compute a running total in SQL is using `SUM() OVER (...)`.

Query Structure:
```sql
SELECT player_id, event_date,
       SUM(games_played) OVER (PARTITION BY player_id ORDER BY event_date)
FROM Activity
```

### Complexity / Độ phức tạp
- **Time**: Depends on DB engine, usually O(N log N) for sorting.
- **Space**: O(N) for output.

---

## Analysis / Phân tích

### Approach: Windowed Aggregate

**Algorithm**:
1.  Partition by player.
2.  Order by date.
3.  Calculate cumulative sum.

---
