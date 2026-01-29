# 1211. Queries Quality and Percentage / Chất lượng và Tỷ lệ Câu hỏi

## Problem Description / Mô tả bài toán
Table `Queries`: `query_name`, `result`, `position`, `rating`.
We define query quality as average of `rating / position`.
Poor query percentage: percentage of queries with `rating < 3`.
For each `query_name`, find quality and poor query percentage. Round to 2 decimals.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation / Tổng hợp SQL
1. Group by `query_name`.
2. Quality: `AVG(rating * 1.0 / position)`.
3. Poor Percentage: `SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END) * 100.0 / COUNT(*)`.

---
