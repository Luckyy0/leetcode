# 1113. Reported Posts / Bài viết được Báo cáo

## Problem Description / Mô tả bài toán
Table `Actions`: `user_id`, `post_id`, `action_date`, `action`, `extra`.
Write an SQL query that reports the number of posts reported yesterday for each report reason. Assume today is `2019-07-05`.
Viết một truy vấn SQL báo cáo số lượng bài viết được báo cáo ngày hôm qua cho mỗi lý do báo cáo. Giả sử hôm nay là `2019-07-05`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Filter and Group / Lọc và Gộp SQL
1. Filter action_date = '2019-07-04'.
2. Filter action = 'report'.
3. Count distinct `post_id` (so repeated reports on same post? Wait, multiple users report same post? Or single user multiple times? Usually distinct per post_id or per user+post?).
   - "number of posts reported".
   - Probably `COUNT(DISTINCT post_id)` grouped by `extra` (reason).
   - `extra` is the reason.

---
