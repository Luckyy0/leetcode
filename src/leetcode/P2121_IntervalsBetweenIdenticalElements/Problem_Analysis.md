# Problem Analysis: Intervals Between Identical Elements

## Problem Description
Array `arr`. For each `i`, sum of `abs(i - j)` where `arr[j] == arr[i]`.
Return array of sums.

## Analysis

1.  **Prefix Sum of Indices**:
    -   Group indices by value. `Map<Value, List<Indices>>`.
    -   For a list of indices `idx_1, idx_2, ...`, calculate sum of distances for each.
    -   Distance for `idx_k`:
        -   $\sum_{m=1}^{len} |idx_k - idx_m|$
        -   $= \sum_{m < k} (idx_k - idx_m) + \sum_{m > k} (idx_m - idx_k)$
        -   $= (k \cdot idx_k - \sum_{m < k} idx_m) + (\sum_{m > k} idx_m - (len - 1 - k) \cdot idx_k)$
    -   Can be computed efficiently using Prefix Sums of indices in the list.
    -   `preSum[k]` = sum of first `k+1` indices.
    -   `sufferSum`... or total sum.

## Implementation Details
-   `Map<Integer, List<Long>>`.
-   Iterate map. Compute results.
