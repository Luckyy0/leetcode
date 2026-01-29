# 1149. Article Views II / Lượt xem Bài viết II

## Problem Description / Mô tả bài toán
Write an SQL query to find the people who viewed more than one article on the same date.
Sorted by id.
Viết một truy vấn SQL để tìm những người đã xem nhiều hơn một bài viết vào cùng một ngày.
Sắp xếp theo id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation
Group by `viewer_id` and `view_date`.
Count distinct `article_id`.
Having count > 1.
Select distinct `viewer_id`.

---
