# 1082. Sales Analysis I / Phân tích Bán hàng I

## Problem Description / Mô tả bài toán
Table `Product`: `product_id`, `product_name`, `unit_price`.
Table `Sales`: `seller_id`, `product_id`, `buyer_id`, `sale_date`, `quantity`, `price`.

Write an SQL query that reports the best seller by total sales price, If there is a tie, report them all.
Viết một truy vấn SQL báo cáo người bán hàng xuất sắc nhất theo tổng giá bán, Nếu có sự hòa nhau, hãy báo cáo tất cả họ.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation and Window
Sum price by `seller_id`.
Find max sum.
Select sellers matching max sum.

Query:
`SELECT seller_id FROM Sales GROUP BY seller_id HAVING SUM(price) = (SELECT MAX(total) FROM (SELECT SUM(price) as total FROM Sales GROUP BY seller_id) t)`

Or `TOP 1 WITH TIES` ordered by sum price desc.

---
