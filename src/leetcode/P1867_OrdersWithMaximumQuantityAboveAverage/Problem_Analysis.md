# Problem Analysis: Orders With Maximum Quantity Above Average

## Problem Description
Table `OrdersDetails` (order_id, product_id, quantity).
Find `order_id`s where the **maximum quantity** of any product in that order is **strictly greater** than the **maximum average quantity** among all orders.
Average quantity of an order = (Total Quantity / Number of Products).
Wait, problem phrasing check: "maximum quantity is strictly greater than the average quantity of any order".
Usually "average quantity of ANY order" implies we find the MAX of the averages.

## Analysis

1.  **Steps**:
    -   Step 1: Calculate specific stats per order. `MaxQty`, `AvgQty`.
    -   Step 2: Find the global threshold `T = MAX(AvgQty of all orders)`.
    -   Step 3: Select orders where `MaxQty > T`.

## Implementation Details
-   CTE `OrderStats`.
-   Subquery for max average.
