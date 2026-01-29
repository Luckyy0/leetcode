# 1479. Sales by Day of the Week / Doanh số theo Ngày trong Tuần

## Problem Description / Mô tả bài toán
Tables `Orders` (order_id, customer_id, order_date, item_id, quantity), `Items` (item_id, item_name, item_category).
Output: Category, then sum of quantity for Monday...Sunday.
Order by Category.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### Pivot / Conditional Aggregation
Group by `item_category`.
Sum quantity where `order_date` corresponds to Monday, Tuesday...
Use `DATENAME` or `DATEPART` to get day of week.
`SUM(CASE WHEN DATENAME(weekday, order_date)='Monday' THEN quantity ELSE 0 END)`.

---
