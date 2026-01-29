# 1336. Number of Transactions per Visit / Số lượng Giao dịch mỗi lần Ghé thăm

## Problem Description / Mô tả bài toán
Tables `Visits` (user_id, visit_date) and `Transactions` (user_id, transaction_date, amount).
Find how many users visited the bank and had `k` transactions on that visit.
Result: `transactions_count` (0 to max(transactions)), `visits_count`.
Need to generate `transactions_count` sequence from 0 to max transactions?
Actually, "Result table should contain all possible transaction counts from 0 to max(transactions per visit)".
If no visits had `k` transactions, count is 0.
Sort by `transactions_count`.

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Recursive CTE (Number Generation)
1. Join `Visits` and `Transactions` ( LEFT JOIN on user and date).
2. Group by `user_id`, `visit_date` to count transactions per visit. (If none, 0).
3. Find MAX transactions count.
4. Generate sequence 0 to MAX using Recursive CTE.
5. Left Join sequence with counts.
6. Count occurrences.

---
