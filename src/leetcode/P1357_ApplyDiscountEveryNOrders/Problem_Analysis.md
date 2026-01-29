# 1357. Apply Discount Every n Orders / Áp dụng Giảm giá Mỗi n Đơn hàng

## Problem Description / Mô tả bài toán
Implement `Cashier` class.
- `n`: threshold for discount.
- `discount`: percentage off.
- `products`: ids.
- `prices`: corresponding prices.
- `getBill(product, amount)`: calculate total. Apply discount if `customer_count % n == 0`. Reset count? No, every n-th customer.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Hashing and Counter
Store products and prices in a Map for O(1) lookup.
Maintain `customerCount`.
If `count % n == 0`, apply discount `total * (1 - discount / 100.0)`.

---
