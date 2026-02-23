# Result for Game Play Analysis IV
# *Kết quả cho bài toán Phân tích Trò chơi IV*

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

Write an SQL query to report the **fraction** of players that logged in again on the day after the day they first logged in, **rounded to 2 decimal places**. In other words, you need to count the number of players that logged in for at least two consecutive days starting from their first login date, then divide that number by the total number of players.
*Viết câu lệnh SQL để báo cáo **tỷ lệ** người chơi đăng nhập lại vào ngày sau ngày họ đăng nhập lần đầu tiên, **làm tròn đến 2 chữ số thập phân**. Nói cách khác, bạn cần đếm số lượng người chơi đã đăng nhập trong ít nhất hai ngày liên tiếp kể từ ngày đăng nhập đầu tiên của họ, sau đó chia số đó cho tổng số người chơi.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

## Example 1:
## *Ví dụ 1:*

**Input:** 
Activity table:
```
+-----------+-----------+------------+--------------+
| player_id | device_id | event_date | games_played |
+-----------+-----------+------------+--------------+
| 1         | 2         | 2016-03-01 | 5            |
| 1         | 2         | 2016-03-02 | 6            |
| 2         | 3         | 2017-06-25 | 1            |
| 3         | 1         | 2016-03-02 | 0            |
| 3         | 4         | 2018-07-03 | 5            |
+-----------+-----------+------------+--------------+
```
**Output:** 
```
+-----------+
| fraction  |
+-----------+
| 0.33      |
+-----------+
```
**Explanation:** 
Only the player with id 1 logged back in after the first day they had logged in so the answer is 1/3 = 0.33.

## Constraints:
## *Ràng buộc:*

*   The table has at least one player.
