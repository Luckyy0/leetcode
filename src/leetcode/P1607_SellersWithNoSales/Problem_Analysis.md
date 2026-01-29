# Problem Analysis: Sellers With No Sales

## Problem Description
Table: `Customer` (customer_id, customer_name)
Table: `Orders` (order_id, sale_date, order_cost, customer_id, seller_id)
Table: `Seller` (seller_id, seller_name)

Write an SQL query to report the names of all sellers who did not make any sales in 2020.
Return the result table ordered by `seller_name` in ascending order.

## Analysis

1.  **Logic**:
    -   Identify sellers who made sales in 2020. `SELECT seller_id FROM Orders WHERE sale_date BETWEEN '2020-01-01' AND '2020-12-31'`.
    -   Select sellers NOT IN that list.
    -   Or `LEFT JOIN` and check NULL.

2.  **Query Structure**:
    ```sql
    SELECT seller_name
    FROM Seller
    WHERE seller_id NOT IN (
        SELECT seller_id 
        FROM Orders 
        WHERE LEFT(sale_date, 4) = '2020'
    )
    ORDER BY seller_name;
    ```

## Implementation Details
-   `LEFT` or `YEAR()` function for date.
