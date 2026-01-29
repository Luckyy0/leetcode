# 1142. User Activity for the Past 30 Days II / Hoạt động Người dùng trong 30 Ngày qua II

## Problem Description / Mô tả bài toán
Write an SQL query to find the average number of sessions per user for a period of 30 days ending 2019-07-27. Rounded to 2 decimal places.
Viết một truy vấn SQL để tìm số phiên trung bình cho mỗi người dùng trong khoảng thời gian 30 ngày kết thúc vào năm 2019-07-27. Làm tròn đến 2 chữ số thập phân.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Average Calculation
1. Filter dates.
2. Calculate total distinct sessions / total distinct users.
   - Wait, if no users, handle NULL (return 0.0 or NULL).
   - Use `ISNULL(COUNT(DISTINCT session_id) * 1.0 / NULLIF(COUNT(DISTINCT user_id), 0), 0)`.

---
