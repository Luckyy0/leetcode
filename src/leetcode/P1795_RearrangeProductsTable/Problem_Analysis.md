# Problem Analysis: Rearrange Products Table

## Problem Description
Table `Products` (product_id, store1, store2, store3).
Unpivot to `product_id, store, price`. Remove null prices.

## Analysis

1.  **Union**:
    -   Select store1 unoin store2 union store3.
    -   Filter nulls.

## Implementation Details
-   SQL.
