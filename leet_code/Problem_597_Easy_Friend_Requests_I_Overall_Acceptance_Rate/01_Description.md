# Result for Friend Requests I: Overall Acceptance Rate
# *Kết quả cho bài toán Yêu cầu Kết bạn I: Tỷ lệ Chấp nhận Tổng thể*

## Description
## *Mô tả*

**SQL Schema**

Table: `FriendRequest`
```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| sender_id      | int     |
| send_to_id     | int     |
| request_date   | date    |
+----------------+---------+
There is no primary key for this table, it may contain duplicates.
This table contains the ID of the user who sent the request, the ID of the user who received the request, and the date of the request.
```

Table: `RequestAccepted`
```
+----------------+---------+
| Column Name    | Type    |
+----------------+---------+
| requester_id   | int     |
| accepter_id    | int     |
| accept_date    | date    |
+----------------+---------+
There is no primary key for this table, it may contain duplicates.
This table contains the ID of the user who sent the request, the ID of the user who accepted the request, and the date of acceptance.
```

Write an SQL query to report the combined acceptance rate of requests, which is the number of acceptance divided by the number of requests. Round the answer to 2 decimal places.
*Viết một truy vấn SQL để báo cáo tỷ lệ chấp nhận yêu cầu kết hợp, tức là số lượt chấp nhận chia cho số lượt yêu cầu. Làm tròn câu trả lời đến 2 chữ số thập phân.*

The **acceptance rate** is calculated by dividing the total number of distinct accepted requests by the total number of distinct requests.
* **Tỷ lệ chấp nhận** được tính bằng cách chia tổng số yêu cầu được chấp nhận riêng biệt cho tổng số yêu cầu riêng biệt.*

If there are no requests at all, you should return `0.00` as the `accept_rate`.
*Nếu không có yêu cầu nào cả, bạn nên trả về `0.00` là `accept_rate`.*

---

## Example 1:
## *Ví dụ 1:*

**Input:** 
FriendRequest table:
```
+-----------+------------+--------------+
| sender_id | send_to_id | request_date |
+-----------+------------+--------------+
| 1         | 2          | 2016/06/01   |
| 1         | 3          | 2016/06/01   |
| 1         | 4          | 2016/06/01   |
| 2         | 3          | 2016/06/02   |
| 3         | 4          | 2016/06/09   |
+-----------+------------+--------------+
```
RequestAccepted table:
```
+--------------+-------------+-------------+
| requester_id | accepter_id | accept_date |
+--------------+-------------+-------------+
| 1            | 2           | 2016/06/03  |
| 1            | 3           | 2016/06/08  |
| 2            | 3           | 2016/06/08  |
| 3            | 4           | 2016/06/09  |
| 3            | 4           | 2016/06/10  |
+--------------+-------------+-------------+
```
**Output:** 
```
+-------------+
| accept_rate |
+-------------+
| 0.8         |
+-------------+
```
**Explanation:** 
There are 4 unique accepted requests, and there are 5 unique requests. So the rate is 4/5 = 0.80.

## Constraints:
## *Ràng buộc:*

*   There are no specific constraints.

## Follow-up:
- Could you write a query to return the acceptance rate for every month?
- Could you write a query to return the cumulative acceptance rate for every day?
- *Bạn có thể viết truy vấn để trả về tỷ lệ chấp nhận cho mỗi tháng không?*
- *Bạn có thể viết truy vấn để trả về tỷ lệ chấp nhận tích lũy cho mỗi ngày không?*
