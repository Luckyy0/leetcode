# Problem Analysis: Find the Missing IDs

## Problem Description
Table: `Customers`
- `customer_id` (int)
- `customer_name` (varchar)

Write an SQL query to find the missing customer IDs. The missing IDs are ones that are not in the `Customers` table but are in the range `1` to `MAX(customer_id)`.
Return table ordered by `ids` ascending.

## Analysis

1.  **Logic**:
    -   Generate a sequence of numbers from 1 to 100 (since max customer_id <= 100 according to problem constraints usually, otherwise use recursive CTE for larger range).
    -   Isolate the max ID from Customers.
    -   Filter the sequence `n <= max_id`.
    -   Subtract existing IDs.

2.  **Recursive CTE**:
    -   Standard way to generate sequence in SQL.
    -   `WITH RECURSIVE Seq AS (SELECT 1 as n UNION ALL SELECT n+1 FROM Seq WHERE n < (SELECT MAX(customer_id) FROM Customers))`

3.  **Query**:
    ```sql
    WITH RECURSIVE Seq AS (
        SELECT 1 AS ids
        UNION ALL
        SELECT ids + 1 FROM Seq 
        WHERE ids < (SELECT MAX(customer_id) FROM Customers)
    )
    SELECT ids 
    FROM Seq
    WHERE ids NOT IN (SELECT customer_id FROM Customers)
    ORDER BY ids;
    ```

## Implementation Details
-   Recursive CTE works in MySQL 8.0+.
