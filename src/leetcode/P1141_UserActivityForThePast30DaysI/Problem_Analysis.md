# 1141. User Activity for the Past 30 Days I / Hoạt động Người dùng trong 30 Ngày qua I

## Problem Description / Mô tả bài toán
Table `Activity`: `user_id`, `session_id`, `activity_date`, `activity_type`.
Write an SQL query to find the daily active user count for a period of 30 days ending `2019-07-27` inclusively.
Viết một truy vấn SQL để tìm số lượng người dùng hoạt động hàng ngày trong khoảng thời gian 30 ngày kết thúc vào `2019-07-27` (bao gồm cả ngày này).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Filtering and Aggregation
1. Filter `activity_date BETWEEN '2019-06-28' AND '2019-07-27'`.
2. Group by `activity_date`.
3. Count distinct `user_id`.

---
