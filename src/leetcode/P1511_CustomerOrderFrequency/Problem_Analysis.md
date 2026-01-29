# 1511. Customer Order Frequency / Tần suất Đặt hàng của Khách hàng

## Problem Description / Mô tả bài toán
Tables `Customers` (customer_id, ...), `Product` (product_id, price), `Orders` (order_id, customer_id, product_id, order_date, quantity).
Report customers who spent at least $100 in JUNE 2020 AND JULY 2020.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Aggregation with Conditional Filter
Group by customer.
Sum `price * quantity` where month is June.
Sum `price * quantity` where month is July.
Filter both sums >= 100.

---
