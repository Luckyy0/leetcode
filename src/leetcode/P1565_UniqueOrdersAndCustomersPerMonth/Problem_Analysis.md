# Problem Analysis: Unique Orders and Customers Per Month

## Problem Description
Table: `Orders`
- `order_id` (int)
- `order_date` (date)
- `customer_id` (int)
- `invoice` (int)

Write an SQL query to find the number of **unique orders** and the number of **unique customers** with invoices **greater than $20** for each **month**.
Return the result table sorted by `month`.

## Analysis

1.  **Filtering**:
    -   `invoice > 20`.

2.  **Grouping**:
    -   Extract month from `order_date`. In MySQL/Generic SQL: `LEFT(order_date, 7)` or `DATE_FORMAT(order_date, '%Y-%m')`.

3.  **Aggregation**:
    -   `COUNT(DISTINCT order_id)` as `order_count`.
    -   `COUNT(DISTINCT customer_id)` as `customer_count`.

## Implementation Details
-   Standard SQL aggregation.
