# 1251. Average Selling Price / Giá Bán Trung bình

## Problem Description / Mô tả bài toán
Tables: `Prices` (product_id, start_date, end_date, price) and `UnitsSold` (product_id, purchase_date, units).
Product prices vary by date range.
Find average selling price for each product.
Formula: Total Revenue / Total Units.
Revenue for a unit sold on `date` is `unit * price` where `start <= date <= end`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Join with Date Range
1. Join `UnitsSold` u and `Prices` p on `u.product_id = p.product_id` AND `u.purchase_date BETWEEN p.start_date AND p.end_date`.
2. Group by `product_id`.
3. Sum `price * units` / Sum `units`.
4. Handle cases with no sales (Left Join or IFNULL). Usually result for no sales is 0.

---
