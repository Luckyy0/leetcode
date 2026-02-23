# Result for Game Play Analysis III
# *Kết quả cho bài toán Phân tích Trò chơi III*

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

Write an SQL query to report for each player and date, how many games played **so far** by the player. That is, the total number of games played by the player until that date. Check the example for clarification.
*Viết câu lệnh SQL để báo cáo cho mỗi người chơi và ngày, số trò chơi đã chơi **cho đến nay** bởi người chơi. Nghĩa là, tổng số trò chơi đã chơi bởi người chơi cho đến ngày đó. Xem ví dụ để làm rõ.*

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
| 1         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
```
**Output:** 
```
+-----------+------------+---------------------+
| player_id | event_date | games_played_so_far |
+-----------+------------+---------------------+
| 1         | 2016-03-01 | 5                   |
| 1         | 2016-05-02 | 11                  |
| 1         | 2017-06-25 | 12                  |
| 3         | 2016-03-02 | 0                   |
| 3         | 2018-07-03 | 5                   |
+-----------+------------+---------------------+
```
**Explanation:** 
For the player with id 1, 5 + 6 = 11 games played by 2016-05-02, and 5 + 6 + 1 = 12 games played by 2017-06-25.
For the player with id 3, 0 + 5 = 5 games played by 2018-07-03.
Note that for each player we only care about the days when the player logged in.
