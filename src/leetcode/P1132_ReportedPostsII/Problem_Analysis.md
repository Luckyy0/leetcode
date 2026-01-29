# 1132. Reported Posts II / Bài viết được Báo cáo II

## Problem Description / Mô tả bài toán
Table `Actions`: `user_id`, `post_id`, `action_date`, `action`, `extra`.
Table `Removals`: `post_id`, `remove_date`.
Write an SQL query to find the average daily percentage of posts that got removed after being reported as spam, rounded to 2 decimal places.
Viết một truy vấn SQL để tìm tỷ lệ phần trăm trung bình hàng ngày của các bài viết đã bị xóa sau khi bị báo cáo là spam, làm tròn đến 2 chữ số thập phân.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Daily Aggregation then Average / Tổng hợp Hàng ngày SQL rồi Trung bình
1. Filter Actions for `extra = 'spam'`.
2. Group by `action_date`.
3. For each date:
   - Total distinct posts reported as spam.
   - Total distinct posts that exist in `Removals` table.
   - Calculate percentage: `removed / reported * 100`.
4. Average these percentages over all dates.

---
