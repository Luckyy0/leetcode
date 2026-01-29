# 1532. The Most Recent Three Orders / Ba Đơn hàng Gần đây nhất

## Problem Description / Mô tả bài toán
Tables `Customers` (customer_id, name), `Orders` (order_id, order_date, customer_id, cost).
Find most recent 3 orders for each user.
Order by customer_name ASC, customer_id ASC, order_date DESC.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Window Functions (RANK / ROW_NUMBER)
`ROW_NUMBER() OVER (PARTITION BY customer_id ORDER BY order_date DESC)`.
Filter `rn <= 3`.
Join with Customers.

---
