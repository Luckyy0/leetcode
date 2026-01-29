# 1193. Monthly Transactions I / Các Giao dịch Hàng tháng I

## Problem Description / Mô tả bài toán
Table `Transactions`: `id`, `country`, `state` ("approved", "declined"), `amount`, `trans_date`.
Write an SQL query to find for each month and country, the number of transactions and their total amount, the number of approved transactions and their total amount.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Grouping and Conditional Aggregation
Format date to Month ('YYYY-MM').
Group by `month`, `country`.
Use `SUM(CASE WHEN state='approved' ...)` for approved metrics.

---
