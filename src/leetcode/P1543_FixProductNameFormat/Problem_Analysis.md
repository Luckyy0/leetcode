# 1543. Fix Product Name Format / Sửa Định dạng Tên Sản phẩm

## Problem Description / Mô tả bài toán
Table `Sales` (sale_id, product_name, sale_date).
Format `product_name`: lowercase, remove leading/trailing spaces.
Report `product_name` (formatted), `sale_date` (YYYY-MM), `count` of sales.
Order by `product_name`, `sale_date`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL String Functions
`LOWER()`, `TRIM()`.
`DATE_FORMAT()` or `LEFT()` for date YYYY-MM.
Group by formatted name and month.

---
