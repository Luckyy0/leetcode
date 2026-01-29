# 1174. Immediate Food Delivery II / Giao đồ ăn Ngay lập tức II

## Problem Description / Mô tả bài toán
Percentage of immediate orders among the **first orders** of all customers.
First order is the one with minimum `order_date`.
Tỷ lệ phần trăm các đơn hàng ngay lập tức trong số các **đơn hàng đầu tiên** của tất cả khách hàng.
Đơn hàng đầu tiên là đơn hàng có `order_date` tối thiểu.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Filtering First Orders
1. Find `(customer_id, min(order_date))` for each customer.
2. Join back to find if that specific order is immediate.
3. Calculate percentage.

---
