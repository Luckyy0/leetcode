# Problem Analysis: Customer Who Visited but Did Not Make Any Transactions

## Problem Description
Table: `Visits`
- `visit_id` (int, pk)
- `customer_id` (int)

Table: `Transactions`
- `transaction_id` (int, pk)
- `visit_id` (int)
- `amount` (int)

Write a SQL query to find the IDs of the users who visited without making any transactions and the number of times they made these types of visits.

## Analysis

1.  **Logic**:
    -   We need visits that don't have a corresponding record in `Transactions`.
    -   Use `LEFT JOIN Visits v ON Transactions t`.
    -   Filter where `t.transaction_id IS NULL`.
    -   Group by `v.customer_id`.
    -   Count `v.visit_id` (or `*`).

2.  **Query Structure**:
    ```sql
    SELECT v.customer_id, COUNT(*) as count_no_trans
    FROM Visits v
    LEFT JOIN Transactions t ON v.visit_id = t.visit_id
    WHERE t.transaction_id IS NULL
    GROUP BY v.customer_id;
    ```

## Implementation Details
-   Standard SQL.
