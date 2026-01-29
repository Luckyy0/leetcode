# 597. Friend Requests I: Overall Acceptance Rate / Yêu Cầu Kết Bạn I: Tỷ Lệ Chấp Nhận Chung

## Problem Description / Mô tả bài toán
Write an SQL query to report the overall acceptance rate of requests rounded to 2 decimal places.
Viết một truy vấn SQL để báo cáo tỷ lệ chấp nhận chung của các yêu cầu được làm tròn đến 2 chữ số thập phân.

The acceptance rate is the number of acceptance divided by the number of requests.
Tỷ lệ chấp nhận là số lượng chấp nhận chia cho số lượng yêu cầu.

Table: `FriendRequest`
```
+------+------+-------------+
| sender_id | send_to_id | request_date |
+------+------+-------------+
```
Table: `RequestAccepted`
```
+------+------+-------------+
| requester_id | accepter_id | accept_date |
+------+------+-------------+
```

Note:
- The accepted requests are not necessarily from the table `FriendRequest`. In this case, you just need to simply count the total accepted requests (no matter whether they are in the original requests), and divide it by the number of total requests.
- It is possible that a sender sends multiple requests to the same receiver, and a request could be accepted more than once. In this case, the ‘duplicated’ requests or acceptances are only counted once.
- If there are no requests at all, you should return 0.00.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Count Distinct / Đếm Riêng Biệt
Numerator: `COUNT(DISTINCT requester_id, accepter_id)` from `RequestAccepted`.
Denominator: `COUNT(DISTINCT sender_id, send_to_id)` from `FriendRequest`.

Handle division by zero (if denom is 0, return 0.00).

Query:
```sql
SELECT 
ROUND(
    IFNULL(
        (SELECT COUNT(DISTINCT requester_id, accepter_id) FROM RequestAccepted) /
        NULLIF((SELECT COUNT(DISTINCT sender_id, send_to_id) FROM FriendRequest), 0),
    0), 2) AS accept_rate;
```

### Complexity / Độ phức tạp
- **Time**: O(N + M).
- **Space**: O(1).

---

## Analysis / Phân tích

### Approach: Ratio of Distinct Counts

**Algorithm**:
1.  Count distinct accepted pairs.
2.  Count distinct requested pairs.
3.  Calculate ratio, handling zero denominator.
4.  Round to 2 decimals.

---
