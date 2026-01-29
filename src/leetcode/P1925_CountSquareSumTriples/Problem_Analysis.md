# Problem Analysis: Count Square Sum Triples

## Problem Description
Integer `n`. Count `a^2 + b^2 = c^2` for `1 <= a, b, c <= n`.

## Analysis

1.  **Brute Force**:
    -   Iterate `a` from 1 to `n`.
    -   Iterate `b` from 1 to `n`.
    -   Calculate `val = a^2 + b^2`.
    -   `c = sqrt(val)`.
    -   If `c` is integer and `c <= n`, count++.
    -   $O(N^2)$. $N \le 250$. Fast.

## Implementation Details
-   Loop.
