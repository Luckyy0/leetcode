# 1148. Article Views I / Lượt xem Bài viết I

## Problem Description / Mô tả bài toán
Table `Views`: `article_id`, `author_id`, `viewer_id`, `view_date`.
Write an SQL query to find all the authors that viewed at least one of their own articles.
Sorted by id.
Viết một truy vấn SQL để tìm tất cả các tác giả đã xem ít nhất một trong các bài viết của chính họ.
Sắp xếp theo id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Simple Filtering
Filter `author_id = viewer_id`.
Select distinct `author_id`.
Order by `author_id`.

---
