# 1204. Last Person to Fit in the Bus / Người Cuối cùng Lên được Xe buýt

## Problem Description / Mô tả bài toán
Table `Queue`: `person_id`, `person_name`, `weight`, `turn`.
Bus weight limit 1000.
Ordered by `turn`.
Find last person (by turn) that can fit.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Cumulative Sum / Tổng Tích lũy SQL
1. Calculate cumulative weight ordered by `turn`.
2. Filter rows where `cum_weight <= 1000`.
3. Select row with max `turn`.

---
