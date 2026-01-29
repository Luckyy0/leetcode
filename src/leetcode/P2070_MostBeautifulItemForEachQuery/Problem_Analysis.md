# Problem Analysis: Most Beautiful Item for Each Query

## Problem Description
Items `[price, beauty]`. Queries `[price]`.
For each query, find max beauty of items with `item_price <= query_price`.

## Analysis

1.  **Sorting + Prefix Max**:
    -   Sort items by price.
    -   Precompute `max_beauty` so far (prefix max).
    -   For each query, Binary Search (upper bound) to find items with price <= Q.
    -   Return `max_beauty[index]`.

## Implementation Details
-   `Arrays.sort`.
-   `TreeMap` or Arrays.
