# Problem Analysis: Merge Triplets to Form Target Triplet

## Problem Description
Triplets `[ai, bi, ci]`. Target `[x, y, z]`.
Op: Pick two triplets `A, B`. Result `[max(a1, a2), max(b1, b2), max(c1, c2)]`.
Can we form target?

## Analysis

1.  **Greedy Filtering**:
    -   Ignore any triplet that has ANY component > target's component (it would ruin the max).
    -   From remaining valid triplets, compute element-wise MAX accumulating in `res`.
    -   Initialize `res = [0, 0, 0]`.
    -   Iterate triplets: if `t[0]<=x && t[1]<=y && t[2]<=z`:
        -   `res[0] = max(res[0], t[0])`
        -   `res[1] = max(res[1], t[1])`
        -   `res[2] = max(res[2], t[2])`
    -   Final check: `res == target`.

## Implementation Details
-   Loop.
