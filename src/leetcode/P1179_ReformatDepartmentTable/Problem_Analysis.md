# 1179. Reformat Department Table / Định dạng lại Bảng Phòng ban

## Problem Description / Mô tả bài toán
Table `Department`: `id`, `revenue`, `month`.
Reformat the table such that there is a department id column and a revenue column *for each month*.
Định dạng lại bảng sao cho có một cột id phòng ban và một cột doanh thu *cho mỗi tháng*.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Pivot / Pivot SQL
Sum(case when month = 'Jan' then revenue else null) as Jan_Revenue.
Group by id.

---
