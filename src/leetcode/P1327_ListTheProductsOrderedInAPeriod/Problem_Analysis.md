# 1327. List the Products Ordered in a Period / Liệt kê các Sản phẩm Đã Đặt hàng trong một Giai đoạn

## Problem Description / Mô tả bài toán
Tables `Products` (product_id, product_name, category) and `Orders` (product_id, order_date, unit).
Find products with >= 100 units ordered in February 2020.
Result: `product_name`, `unit`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Date Filtering and Aggregation
1. Filter `order_date` BETWEEN '2020-02-01' AND '2020-02-29'.
2. Group by `product_id`.
3. Sum `unit`.
4. Having `sum(unit) >= 100`.
5. Join with `Products` to get name.

---
