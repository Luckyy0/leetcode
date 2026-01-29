# 1484. Group Sold Products By The Date / Nhóm Các Sản phẩm Đã Bán Theo Ngày

## Problem Description / Mô tả bài toán
Table `Activities` (sell_date, product).
Group by date. Count unique products. List products sorted lexicographically separated by comma.
Order by date.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL String Aggregation
`GROUP_CONCAT` (MySQL) or `STRING_AGG` (SQL Server/Postgres).
`COUNT(DISTINCT product)`.
Distinct products inside aggregation?
MySQL: `GROUP_CONCAT(DISTINCT product ORDER BY product SEPARATOR ',')`.
T-SQL: `STRING_AGG` doesn't support DISTINCT directly easily inside. Need subquery with distinct first.

---
