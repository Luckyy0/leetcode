# Problem Analysis: Dot Product of Two Sparse Vectors

## Problem Description
Given two sparse vectors, compute their dot product.
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product efficiently.

Implement the `SparseVector` class:
-   `SparseVector(nums)` initializes the object with the vector `nums`.
-   `dotProduct(vec)` computes the dot product between the instance of `SparseVector` and `vec`.

## Analysis

1.  **Storage**:
    -   Since it is sparse, we should only store non-zero indices and values.
    -   `Map<Integer, Integer>` or `List<Pair<Index, Value>>`.
    -   If using `List`, it is beneficial to store them in increasing order of index (which happens naturally if initialized from array).

2.  **Dot Product Logic**:
    -   Given two maps `map1` and `map2`.
    -   Iterate over the smaller map.
    -   Sum `val * map2.get(index)` (if exists).
    -   Or two pointers if lists are used.
    -   Map approach is generally $O(min(K1, K2))$ or $O(K1 \log K2)$ depending on implementation. Hash Map $O(min(K1, K2))$.

3.  **Complexity**:
    -   Initialization: $O(N)$.
    -   Dot Product: $O(min(K1, K2))$ where K is number of non-zero elements.

## Implementation Details
-   Use `Map<Integer, Integer> indexToValue`.
