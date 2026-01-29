# Problem Analysis: Find Subsequence of Length K With the Largest Sum

## Problem Description
Array `nums`. `k`.
Subsequence length `k` with largest sum.
Return as array (preserve original relative order).

## Analysis

1.  **Sorting with Indices**:
    -   Store pairs `(val, index)`.
    -   Sort by value descending.
    -   Take top `k`.
    -   Sort these `k` by index to restore original order.
    -   Return values.

## Implementation Details
-   `int[][] pairs`.
-   Arrays.sort.
