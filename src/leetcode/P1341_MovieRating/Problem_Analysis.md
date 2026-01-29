# 1341. Movie Rating / Xếp hạng Phim

## Problem Description / Mô tả bài toán
Tables `Movies` (movie_id, title), `Users` (user_id, name), `MovieRating` (movie_id, user_id, rating, created_at).
1. Find user who rated most movies. Tie break: lexicographically smaller name.
2. Find movie with highest average rating in Feb 2020. Tie break: lexicographically smaller title.
Return single table with `results` column. Union the two results rows.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL UNION ALL
Part 1:
Select `name` from Users join MovieRating.
Group by user_id.
Order by count desc, name asc.
Limit 1.

Part 2:
Select `title` from Movies join MovieRating.
Filter `created_at` in '2020-02'.
Group by movie_id.
Order by avg rating desc, title asc.
Limit 1.

Union All.

---
