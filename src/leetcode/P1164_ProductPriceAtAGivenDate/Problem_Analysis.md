# 1164. Product Price at a Given Date / Giá Sản phẩm vào Một Ngày Cụ thể

## Problem Description / Mô tả bài toán
Table `Products`: `product_id`, `new_price`, `change_date`.
Write an SQL query to find the prices of all products on `2019-08-16`. Assume the price of all products before any change is 10.
Viết một truy vấn SQL để tìm giá của tất cả các sản phẩm vào ngày `2019-08-16`. Giả sử giá của tất cả các sản phẩm trước khi có bất kỳ thay đổi nào là 10.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Window Functions / Filtering Last Valid Record
1. Find all distinct products.
2. For each product, find the latest `change_date <= '2019-08-16'`.
3. If no such date, price is 10.
4. Else price is `new_price` on that date.

Query Structure:
- Subquery to find max date <= target for each product.
- Join with Prices.
- Union with products having no change <= target (price 10).

---
