# Problem Analysis: Bank Account Summary

## Problem Description
Table: `Users`
- `user_id` (int, pk)
- `user_name` (varchar)
- `credit` (int) - current balance

Table: `Transactions`
- `trans_id` (int, pk)
- `paid_by` (int) - user_id who paid
- `paid_to` (int) - user_id who received
- `amount` (int)
- `trans_opened_at` (date)

Write an SQL query to report:
-   `user_id`
-   `user_name`
-   `credit` (current balance after all transactions)
-   `credit_limit_breached` ('Yes' if credit < 0, else 'No').

## Analysis

1.  **Logic**:
    -   We need to calculate the standard net change for each user from the `Transactions` table.
    -   `Income`: sum of `amount` where `paid_to` = user.
    -   `Outcome`: sum of `amount` where `paid_by` = user.
    -   `Final Credit` = `Initial Credit` + `Income` - `Outcome`.

2.  **Approach**:
    -   Standardize transactions into a single flow (user, amount).
    -   Paid By -> user, -amount
    -   Paid To -> user, +amount
    -   `UNION ALL` these two perspectives.
    -   `GROUP BY` user to get net transaction change.
    -   `JOIN` with `Users` table (use `LEFT JOIN` to include users with no transactions).
    -   Calculate final fields.

3.  **SQL Query Structure**:
    ```sql
    WITH NetTransactions AS (
        SELECT paid_by AS user_id, -amount AS amount FROM Transactions
        UNION ALL
        SELECT paid_to AS user_id, amount AS amount FROM Transactions
    ),
    TotalChange AS (
        SELECT user_id, SUM(amount) as change
        FROM NetTransactions
        GROUP BY user_id
    )
    SELECT 
        u.user_id, 
        u.user_name, 
        (u.credit + COALESCE(tc.change, 0)) AS credit,
        CASE WHEN (u.credit + COALESCE(tc.change, 0)) < 0 THEN 'Yes' ELSE 'No' END AS credit_limit_breached
    FROM Users u
    LEFT JOIN TotalChange tc ON u.user_id = tc.user_id
    ```

## Implementation Details
-   The structure above handles all cases including NULLs (users with no transactions).
