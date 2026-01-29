# Problem Analysis: The Most Frequently Ordered Products for Each Customer

## Problem Description
Table: `Customers`
- `customer_id` (int, pk)
- `name` (varchar)

Table: `Orders`
- `order_id` (int, pk)
- `order_date` (date)
- `customer_id` (int)
- `product_id` (int)

Table: `Products`
- `product_id` (int, pk)
- `product_name` (varchar)
- `price` (int)

Write an SQL query to find the most frequently ordered product(s) for each customer.
The result table should have the `product_id` and `product_name` for each customer_id who ordered at least one product.
If there is a tie, include all products.

## Analysis

1.  **Logic**:
    -   Count occurrences of `(customer_id, product_id)`.
    -   Rank products per customer based on count (descending). Use `DENSE_RANK()` (or `RANK()`, since we want ties).
    -   Select those with rank = 1.
    -   Join with products/customers for details (Actually output format needs `customer_id`, `product_id`, `product_name`).

2.  **Query Structure**:
    ```sql
    WITH Counts AS (
        SELECT customer_id, product_id, COUNT(*) as freq
        FROM Orders
        GROUP BY customer_id, product_id
    ),
    Ranked AS (
        SELECT customer_id, product_id, freq,
               RANK() OVER (PARTITION BY customer_id ORDER BY freq DESC) as rnk
        FROM Counts
    )
    SELECT r.customer_id, r.product_id, p.product_name
    FROM Ranked r
    JOIN Products p ON r.product_id = p.product_id
    WHERE r.rnk = 1;
    ```

## Implementation Details
-   Common Table Expressions (CTE).
