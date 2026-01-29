# 511. Game Play Analysis I / Phân Tích Lượt Chơi I

## Problem Description / Mô tả bài toán
Write an SQL query to report the **first login date** for each player.
Hãy viết một truy vấn SQL để báo cáo **ngày đăng nhập đầu tiên** của mỗi người chơi.

The table `Activity` is defined as:
```text
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key.
```

### Example:
```text
Input Activity table:
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-05-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+

Output:
+-----------+-------------+
| player_id | first_login |
+-----------+-------------+
| 1         | 2016-03-01  |
| 2         | 2017-06-25  |
| 3         | 2016-03-02  |
+-----------+-------------+
```

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Group By and Min / Group By và Min
This is a simple aggregation problem. We want to find the minimum `event_date` associated with each `player_id`.

SQL Algorithm:
1. Select `player_id` and the minimum `event_date` as `first_login`.
2. Group the results by `player_id`.

---

## Analysis / Phân tích

### Approach: Basic Aggregation

**Algorithm**:
1.  Group by ID.
2.  Aggregate using `MIN()`.

---
