# 1083. Sales Analysis II / Phân tích Bán hàng II

## Problem Description / Mô tả bài toán
Tables `Product`, `Sales`.
Write an SQL query that reports the buyers who have bought S8 but not iPhone. Note that S8 and iPhone are products present in Product table.
Viết một truy vấn SQL báo cáo những người mua đã mua S8 nhưng không mua iPhone. Lưu ý rằng S8 và iPhone là các sản phẩm có trong bảng Product.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Filtering / SUM CASE
Group by `buyer_id`.
Using `SUM(CASE WHEN product_name = 'S8' THEN 1 ELSE 0 END) > 0`
AND `SUM(CASE WHEN product_name = 'iPhone' THEN 1 ELSE 0 END) = 0`.
Need to join with Product table to check names.

---
