# Result for Friend Requests II: Who Has the Most Friends
# *Kết quả cho bài toán Yêu cầu Kết bạn II: Ai có nhiều Bạn nhất*

## Description
## *Mô tả*

**SQL Schema**

Table: `RequestAccepted`
```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
(requester_id, accepter_id) is the primary key for this table.
This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date when the request was accepted.
```

Write an SQL query to find the people who have the most friends and the most friends number.
*Viết một truy vấn SQL để tìm những người có nhiều bạn nhất và số lượng bạn nhiều nhất đó.*

The test cases are generated so that only one person has the most friends.
*Các trường hợp kiểm thử được tạo ra sao cho chỉ có một người có nhiều bạn nhất.*

The query result format is in the following example.
*Định dạng kết quả truy vấn theo ví dụ sau.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
RequestAccepted table:
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
**Output:** 
```
+----+-----+
| id | num |
+----+-----+
| 3  | 3   |
+----+-----+
```
**Explanation:** 
- The person with id 3 is friends with people 1, 2, and 4, so he has 3 friends in total, which is the most number than any others.

## Follow up:
In the real world, multiple people could have the same most friends number. Can you find all these people?
*Trong thực tế, nhiều người có thể có cùng số lượng bạn nhiều nhất. Bạn có thể tìm thấy tất cả những người này không?*
