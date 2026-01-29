# Problem Analysis: Product's Price for Each Store

## Problem Description
Table `Products` (product_id, store, price).
Pivot to: `product_id, store1, store2, store3`.

## Analysis

1.  **Pivot / Group By**:
    -   Group by `product_id`.
    -   `MAX(CASE WHEN store='store1' THEN price END) AS store1`.
    -   ...

## Implementation Details
-   SQL.
