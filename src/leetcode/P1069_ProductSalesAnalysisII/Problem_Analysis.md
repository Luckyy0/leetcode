# 1069. Product Sales Analysis II / Phân tích Bán hàng Sản phẩm II

## Problem Description / Mô tả bài toán
Tables `Sales` and `Product`. Same as 1068.
Write a SQL query that reports the total quantity sold for every product id.
Viết một truy vấn SQL báo cáo tổng số lượng đã bán cho mỗi id sản phẩm.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation / GROUP BY
Aggregating quantity by product_id.
`SELECT product_id, SUM(quantity) as total_quantity FROM Sales GROUP BY product_id`.

---
