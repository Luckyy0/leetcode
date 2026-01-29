# 550. Game Play Analysis IV / Phân Tích Lượt Chơi IV

## Problem Description / Mô tả bài toán
Write an SQL query to report the **fraction** of players that logged in again on the day after the day they first logged in, rounded to 2 decimal places. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.
Viết một truy vấn SQL để báo cáo **tỷ lệ** người chơi đã đăng nhập lại vào ngày sau ngày họ đăng nhập lần đầu tiên, làm tròn đến 2 chữ số thập phân. Nói cách khác, bạn cần đếm số lượng người chơi đã đăng nhập trong ít nhất hai ngày liên tiếp bắt đầu từ ngày đăng nhập đầu tiên của họ, sau đó chia số đó cho tổng số người chơi.

The `Activity` table schema is the same.
Lược đồ bảng `Activity` giống như cũ.

### Example:
Input:
```text
+-----------+------------+--------------+
| player_id | event_date | games_played |
+-----------+------------+--------------+
| 1         | 2016-03-01 | 5            |
| 1         | 2016-03-02 | 6            |
| 2         | 2017-06-25 | 1            |
| 3         | 2016-03-02 | 0            |
| 3         | 2018-07-03 | 5            |
+-----------+------------+--------------+
```
Output:
```text
+-----------+
| fraction  |
+-----------+
| 0.33      |
+-----------+
```
Explanation: Only player 1 logged in on 2016-03-02 (day after 2016-03-01). Total players = 3. Fraction = 1/3.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Subquery + Left Join / Truy vấn con + Left Join
1. Identify the first login date for each player. (Subquery A).
2. Count total players (Count Distinct player_id from A).
3. Count players who have a record on `first_login + 1 day`.
   - Join `Activity` table with `A` on `player_id` AND `date = first_date + 1`.

Query Structure:
```sql
WITH FirstLogin AS (
    SELECT player_id, MIN(event_date) as first_date
    FROM Activity
    GROUP BY player_id
)
SELECT ROUND(COUNT(distinct A.player_id) / (SELECT COUNT(distinct player_id) FROM Activity), 2)
FROM Activity A
JOIN FirstLogin F ON A.player_id = F.player_id
WHERE A.event_date = DATE_ADD(F.first_date, INTERVAL 1 DAY)
```
Wait, standard query logic might differ slightly based on SQL dialect (MySQL vs MS SQL). The problem usually assumes MySQL.
For calculating the fraction, we need `Numerator / Denominator`.
Denominator: `SELECT COUNT(DISTINCT player_id) FROM Activity`.
Numerator: Count of players in the join result.

### Complexity / Độ phức tạp
- **Time**: Depends on DB.
- **Space**: O(N).

---

## Analysis / Phân tích

### Approach: Self-Join with Aggregation

**Algorithm**:
1.  Find first login date for every player.
2.  Self-join Activity table to find consecutive logins.
3.  Filter for `event_date = first_login + 1`.
4.  Compute fraction of such players vs total players.

---
