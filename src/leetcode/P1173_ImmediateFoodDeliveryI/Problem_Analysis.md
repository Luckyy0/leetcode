# 1173. Immediate Food Delivery I / Giao đồ ăn Ngay lập tức I

## Problem Description / Mô tả bài toán
Table `Delivery`: `delivery_id`, `customer_id`, `order_date`, `customer_pref_delivery_date`.
Immediate order: `order_date == customer_pref_delivery_date`.
Write an SQL query to find the percentage of immediate orders in the table, rounded to 2 decimal places.
Đơn hàng ngay lập tức: `order_date == customer_pref_delivery_date`.
Viết một truy vấn SQL để tìm tỷ lệ phần trăm các đơn hàng ngay lập tức trong bảng, làm tròn đến 2 chữ số thập phân.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Percentage
1. Count total rows.
2. Count immediate rows.
3. Divide and multiply by 100.

---
