# 1398. Customers Who Bought Products A and B but Not C / Khách hàng Đã Mua Sản phẩm A và B nhưng Không phải C

## Problem Description / Mô tả bài toán
Table `Customers` (customer_id, customer_name), `Orders` (order_id, customer_id, product_name).
Find customers who bought "A" and "B" but NOT "C".
Sort by customer_id.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Conditional Aggregation / Filtering
Group by `customer_id`.
Filter `HAVING`:
- `SUM(product_name = 'A') > 0`
- `SUM(product_name = 'B') > 0`
- `SUM(product_name = 'C') = 0`
Join with `Customers` to get name.

---
