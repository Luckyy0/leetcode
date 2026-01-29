# 1549. The Most Recent Orders for Each Product / Các Đơn hàng Gần đây nhất cho Mỗi Sản phẩm

## Problem Description / Mô tả bài toán
Tables `Products` (product_id, product_name, category) and `Orders` (order_id, order_date, customer_id, product_id).
Find the most recent order(s) for each product.
A product may have multiple orders on the same most recent date, include all of them.
Return product name, product id, order id, and order date.
Order by product name ASC, product id ASC, order id ASC.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Window Functions / Ranking
Use `RANK()` or `DENSE_RANK()` over `product_id` ordered by `order_date DESC`.
Select rows with rank 1.
Join with Products to get the name.

---
