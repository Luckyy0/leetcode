# Problem Analysis: Maximum Number of Removable Characters

## Problem Description
String `s`, `p`. `removable` indices.
Find max `k` s.t. removing first `k` indices from `s` still keeps `p` as a subsequence.

## Analysis

1.  **Binary Search on k**:
    -   Range `[0, removable.length]`.
    -   `check(k)`:
        -   Mark first `k` indices in `s` as removed.
        -   Check if `p` is subsequence of modified `s`.
        -   Use greedy matching.
    -   Optimization: Use a boolean array or char array copy.

## Implementation Details
-   Loop.
