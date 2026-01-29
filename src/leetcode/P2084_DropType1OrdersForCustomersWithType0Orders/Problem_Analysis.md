# Problem Analysis: Drop Type 1 Orders for Customers With Type 0 Orders

## Problem Description
Table `Orders` (order_id, customer_id, order_type).
If a customer has at least one order of type 0, drop all their type 1 orders.
If a customer has only type 1 orders, keep them.
Return result table.

## Analysis

1.  **Window Function or Exists**:
    -   Select all orders where:
        -   Type is 0. (Always keep 0).
        -   Type is 1 AND customer does NOT have type 0.
    -   `WHERE order_type = 0 OR (order_type = 1 AND customer_id NOT IN (SELECT customer_id FROM Orders WHERE order_type = 0))`
    -   Or `NOT EXISTS`.

## Implementation Details
-   Subquery logic.
