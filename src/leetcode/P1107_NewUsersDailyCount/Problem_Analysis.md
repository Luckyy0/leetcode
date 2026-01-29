# 1107. New Users Daily Count / Số lượng Người dùng Mới Hàng ngày

## Problem Description / Mô tả bài toán
Table: `Traffic` with `user_id`, `activity`, `activity_date`.
Write an SQL query that reports for every date within at most 90 days from today, the number of users that logged in for the first time on that date. Assume today is 2019-06-30.
Viết một truy vấn SQL báo cáo cho mọi ngày trong vòng tối đa 90 ngày kể từ hôm nay, số lượng người dùng đã đăng nhập lần đầu tiên vào ngày đó. Giả sử hôm nay là 2019-06-30.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Grouping and Date Filtering
1. Find first login date for each user (`MIN(activity_date)`).
2. Filter these dates to be within `[2019-06-30 - 90 days, 2019-06-30]`.
3. Group by `login_date` and count users.

---
