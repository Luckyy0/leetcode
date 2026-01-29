# Problem Analysis: Mean of Array After Removing Some Elements

## Problem Description
Given an integer array `arr`, return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the elements.
Assume the answer works out to be within $10^{-5}$ of the actual answer.
`arr.length` is a multiple of 20.

## Analysis

1.  **Logic**:
    -   Sort the array.
    -   Calculate `n = arr.length`.
    -   `removeCount = n / 20` (5%).
    -   Sum elements from index `removeCount` to `n - 1 - removeCount`.
    -   Count of elements = `n - 2 * removeCount`.
    -   Mean = Sum / Count.

2.  **Complexity**:
    -   Time: $O(N \log N)$ (Sort).
    -   Space: $O(1)$ (or $O(\log N)$ sort).

## Implementation Details
-   Double for mean.
