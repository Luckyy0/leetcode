# 1084. Sales Analysis III / Phân tích Bán hàng III

## Problem Description / Mô tả bài toán
Write an SQL query that reports the products that were **only** sold in the first quarter of 2019 (between 2019-01-01 and 2019-03-31 inclusive).
Viết một truy vấn SQL báo cáo các sản phẩm **chỉ** được bán trong quý đầu tiên của năm 2019 (từ 2019-01-01 đến 2019-03-31).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Grouping and Condition Bounds
Group by `product_id`.
Cond 1: Min sale_date >= '2019-01-01'.
Cond 2: Max sale_date <= '2019-03-31'.
(Ensures ALL sales are within range).

---
