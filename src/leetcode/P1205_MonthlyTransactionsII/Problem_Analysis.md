# 1205. Monthly Transactions II / Các Giao dịch Hàng tháng II

## Problem Description / Mô tả bài toán
Tables `Transactions` (id, country, state, amount, trans_date) and `Chargebacks` (trans_id, trans_date).
Chargeback event happens for a transaction on `trans_date` in Chargebacks table.
Find for each month and country:
- count and amount of approved transactions.
- count and amount of chargebacks.
Note: Chargeback month is the chargeback date, not original transaction date.
Output: month, country, approved_count, approved_amount, chargeback_count, chargeback_amount.
Include rows with any activity (approved or chargeback).

---

## Theoretical Foundation / Cơ sơ lý thuyết

### SQL Full Outer Join / Union All
1. Get Approved Transactions grouped by month/country.
2. Get Chargebacks. Join with Transactions to get amount and country. Group by chargeback month/country.
3. Union both result sets.
4. Group by month/country again to sum up.

---
