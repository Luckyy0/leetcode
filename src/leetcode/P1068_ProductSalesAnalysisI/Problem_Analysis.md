# 1068. Product Sales Analysis I / Phân tích Bán hàng Sản phẩm I

## Problem Description / Mô tả bài toán
Table `Sales`: `sale_id`, `product_id`, `year`, `quantity`, `price`.
Table `Product`: `product_id`, `product_name`.

Write a SQL query that reports the `product_name`, `year`, and `price` for each `sale_id` in the `Sales` table.
Viết truy vấn SQL báo cáo `product_name`, `year` và `price` cho mỗi `sale_id` trong bảng `Sales`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL JOIN
Simple Inner Join between Sales and Product on `product_id`.

---
