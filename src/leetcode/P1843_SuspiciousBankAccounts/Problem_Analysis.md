# Problem Analysis: Suspicious Bank Accounts

## Problem Description
Tables: `Accounts` (account_id, max_income), `Transactions` (transaction_id, account_id, type, amount, day).
Suspicious:
-   Sum of income (`type='Creditor'`) in a month exceeds `max_income`.
-   This happens for **two or more consecutive months**.
Return `account_id`s.

## Analysis

1.  **Monthly Aggregation**:
    -   Group `Transactions` by `account_id` and Month (`DATE_FORMAT(day, '%Y-%m')`).
    -   Filter `type = 'Creditor'`.
    -   Sum `amount`.
    -   Join with `Accounts` to check against `max_income`.
    -   Filter months where `total_income > max_income`.

2.  **Consecutive Months**:
    -   Use `LAG` logic or `PERIOD_DIFF`.
    -   `PERIOD_DIFF(curr_month, prev_month) = 1`.
    -   Or convert to `YYYYMM` integer.
    -   If `month - prev_month = 1` then consecutive. (Handle Dec to Jan: typically DATE type comparison is better).
    -   Use `DATE_ADD(prev_date, INTERVAL 1 MONTH) = curr_date`? No, aggregate date is month start.
    -   Usually CTE + `LEAD`/`LAG`.

## Implementation Details
-   CTE for monthly income.
-   Window function for consecutive check.
