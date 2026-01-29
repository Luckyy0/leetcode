# 1308. Running Total for Different Genders / Tổng Chạy cho Giới tính Khác nhau

## Problem Description / Mô tả bài toán
Table `Scores`: `player_name`, `gender`, `day`, `score_points`.
Result: `gender`, `day`, `total` (running total of scores for that gender up to that day).
Order by `gender`, `day`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Function
`SUM(score_points) OVER (PARTITION BY gender ORDER BY day)`.
Calculate cumulative sum.

---
