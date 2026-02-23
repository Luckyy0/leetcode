# Result for Game Play Analysis II
# *Kết quả cho bài toán Phân tích Trò chơi II*

## Description
## *Mô tả*

**SQL Schema**

Table: `Activity`

```
+--------------+---------+
| Column Name  | Type    |
+--------------+---------+
| player_id    | int     |
| device_id    | int     |
| event_date   | date    |
| games_played | int     |
+--------------+---------+
(player_id, event_date) is the primary key of this table.
This table shows the activity of players of some games.
Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on someday using some device.
```

Write an SQL query to report the **device** that is first logged in for each player.
*Viết câu lệnh SQL để báo cáo **thiết bị** được đăng nhập đầu tiên cho mỗi người chơi.*

Return the result table in **any order**.
*Trả về bảng kết quả theo **bất kỳ thứ tự nào**.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Activity table:
```
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-05-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
```
**Output:** 
```
+-----------+-----------+
| player_id | device_id |
+-----------+-----------+
| 1         | 2         |
| 2         | 3         |
| 3         | 1         |
+-----------+-----------+
```
