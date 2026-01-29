# 1384. Total Sales Amount by Year / Tổng Doanh thu Bán hàng theo Năm

## Problem Description / Mô tả bài toán
Tables `Product` (product_id, product_name), `Sales` (product_id, period_start, period_end, average_daily_sales).
Report total sales amount of each item for each year, with corresponding year, product_id, product_name, total_amount.
Dates ranges can span multiple years.
Years 2018, 2019, 2020. Consider logic for any years.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Recursive CTE or Join with Years
1. Need a way to split date ranges into year-buckets.
2. Join `Sales` with a `Years` table (could be generated recursively).
3. `Years` table: 2018, 2019, 2020 (based on data range).
4. For each (Sale, Year) pair:
   - Determine overlap:
     `start = max(period_start, Year-01-01)`
     `end = min(period_end, Year-12-31)`
   - If `start <= end`:
     days = `DATEDIFF(end, start) + 1`
     amount = `days * average_daily_sales`

---
