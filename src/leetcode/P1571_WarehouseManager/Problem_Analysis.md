# Problem Analysis: Warehouse Manager

## Problem Description
Table: `Warehouse`
- `name` (varchar)
- `product_id` (int)
- `units` (int)

Table: `Products`
- `product_id` (int)
- `product_name` (varchar)
- `Width` (int)
- `Length` (int)
- `Height` (int)

Write an SQL query to report the number of cubic feet of volume the inventory occupies in each warehouse.

## Analysis

1.  **Join**:
    -   Join `Warehouse` and `Products` on `product_id` to access dimensions.

2.  **Calculation**:
    -   Volume for one unit of product = `Width * Length * Height`.
    -   Total volume for that product line = `units * Volume`.

3.  **Aggregation**:
    -   Group by `warehouse_name` (`name` column in Warehouse table).
    -   Sum the total volumes.

## Implementation Details
-   `SUM(units * Width * Length * Height)`.
