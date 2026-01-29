# Problem Analysis: Bank Account Summary II

## Problem Description
Table: `Users`
- `account` (int, pk)
- `name` (varchar)

Table: `Transactions`
- `trans_id` (int, pk)
- `account` (int)
- `amount` (int)
- `transacted_on` (date)

Write an SQL query to report the name and balance of users with a balance higher than 10000.  The balance of an account is equal to the sum of the amounts of all transactions recorded in the Transactions table.

## Analysis

1.  **Logic**:
    -   Join `Users` and `Transactions` on `account`.
    -   Group by `account` (and `name`).
    -   Sum `amount` to get balance.
    -   Filter `HAVING SUM(amount) > 10000`.

2.  **Query**:
    ```sql
    SELECT u.name, SUM(t.amount) AS balance
    FROM Users u
    JOIN Transactions t ON u.account = t.account
    GROUP BY u.account, u.name
    HAVING SUM(t.amount) > 10000;
    ```

## Implementation Details
-   Standard aggregation.
