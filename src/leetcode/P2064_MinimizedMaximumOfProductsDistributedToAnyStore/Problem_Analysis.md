# Problem Analysis: Minimized Maximum of Products Distributed to Any Store

## Problem Description
`n` stores. `quantities` `m` types of products.
Distribute all products to stores.
Rules:
-   One store can only be given one type of product (but can take multiple units).
-   One type can be distributed to multiple stores.
-   Ah, wait. "One store can only be given ... one product type".
-   "A store can be given any amount of *some product type*".
-   Basically distribute `quantities[i]` into buckets. Total buckets available `n`.
-   Each bucket receives `x` amount of `type i`.
-   We want to minimize the Maximum amount given to any store `x`.
-   Constraint: `sum(buckets needed for all types) <= n`.

## Analysis

1.  **Binary Search on Answer**:
    -   Suppose max load is `X`.
    -   For a product type with quantity `Q`, how many stores needed? `ceil(Q / X)`.
    -   Check if `sum(ceil(Q/X)) <= n`.
    -   Binary search range `[1, 100000]`.
    -   Complexity $O(M \log(\max Q))$.

## Implementation Details
-   `check(x)` function.
-   Binary Search.
