# Problem Analysis: Minimum Operations to Make a Subsequence

## Problem Description
Target array `target` (distinct elements).
Array `arr` (may have duplicates).
Min ops to make `target` a subsequence of `arr`.
Ops: Insert.

## Analysis

1.  **Reduction to LIS**:
    -   We want longest common subsequence.
    -   Since `target` has distinct elements, the order is fixed.
    -   We can relabel `target` elements as `0, 1, ..., k-1`.
    -   Convert `arr` into these labels (ignoring elements not in target).
    -   Now finding LCS is equivalent to finding LIS in the transformed `arr`.
    -   Result = `length(target) - LIS`.

2.  **Algorithm**:
    -   Map `target[i]` -> `i`.
    -   Transform `arr` to `indices`.
    -   Run $O(N \log N)$ LIS on `indices`.

3.  **Complexity**:
    -   Time: $O(N \log N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `ArrayList` for LIS (patience sort).
