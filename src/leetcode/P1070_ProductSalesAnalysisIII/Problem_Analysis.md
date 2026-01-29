# 1070. Product Sales Analysis III / Phân tích Bán hàng Sản phẩm III

## Problem Description / Mô tả bài toán
Write a SQL query that selects the **product id**, **year**, **quantity**, and **price** for the **first year** of every product sold.
Viết một truy vấn SQL chọn **product id**, **year**, **quantity**, và **price** cho **năm đầu tiên** của mỗi sản phẩm được bán.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Subquery / Window Function
We need to find the minimum year for each product.
`SELECT product_id, MIN(year) FROM Sales GROUP BY product_id`.
Then join `Sales` with this result based on `(product_id, year)`.

Or use `RANK()` or `MIN() OVER`.

Query:
`SELECT product_id, year as first_year, quantity, price FROM Sales WHERE (product_id, year) IN (SELECT product_id, MIN(year) FROM Sales GROUP BY product_id)`

---

## Analysis / Phân tích

### Approach: Filter by Minimum Year
Identify the earliest sale year for each product using a `GROUP BY` subquery (finding `MIN(year)`). Use this set of `(product_id, min_year)` pairs to filter the main Sales table, retrieving the full details for those specific initial transactions.
Xác định năm bán hàng sớm nhất cho mỗi sản phẩm bằng cách sử dụng truy vấn con `GROUP BY` (tìm `MIN(year)`). Sử dụng tập hợp các cặp `(product_id, min_year)` này để lọc bảng Sales chính, truy xuất đầy đủ thông tin chi tiết cho các giao dịch ban đầu cụ thể đó.

---
