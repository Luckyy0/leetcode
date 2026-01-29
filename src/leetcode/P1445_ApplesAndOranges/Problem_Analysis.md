# 1445. Apples & Oranges / Táo & Cam

## Problem Description / Mô tả bài toán
Table `Sales` (sale_date, fruit, sold_num).
Fruit is 'apples' or 'oranges'.
Report difference: `apples_sold_num - oranges_sold_num` for each day.
Order by `sale_date`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation with Conditional Sum
Group by `sale_date`.
Sum: `CASE WHEN fruit='apples' THEN sold_num ELSE -sold_num END`.

---
