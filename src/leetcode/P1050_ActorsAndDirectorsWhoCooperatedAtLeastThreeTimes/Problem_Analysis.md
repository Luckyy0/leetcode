# 1050. Actors and Directors Who Cooperated At Least Three Times / Các Diễn viên và Đạo diễn Hợp tác Ít nhất Ba lần

## Problem Description / Mô tả bài toán
Table: `ActorDirector`
- `actor_id` (int)
- `director_id` (int)
- `timestamp` (int)

Write a SQL query for a report that provides the pairs `(actor_id, director_id)` where the actor has cooperated with the director at least three times.
Viết một truy vấn SQL cho một báo cáo cung cấp các cặp `(actor_id, director_id)` trong đó diễn viên đã hợp tác với đạo diễn ít nhất ba lần.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL GROUP BY and HAVING / SQL GROUP BY và HAVING
Logic:
`SELECT actor_id, director_id FROM ActorDirector GROUP BY actor_id, director_id HAVING COUNT(*) >= 3`

---

## Analysis / Phân tích

### Approach: Group Filtering
Aggregate the records by the actor-director pair key. Apply a filter to retain only those groups with a count of 3 or more.
Tổng hợp các bản ghi theo khóa cặp diễn viên-đạo diễn. Áp dụng bộ lọc để chỉ giữ lại những nhóm có số lượng từ 3 trở lên.

---
