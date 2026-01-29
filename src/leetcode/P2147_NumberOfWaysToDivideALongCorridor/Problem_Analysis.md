# Problem Analysis: Number of Ways to Divide a Long Corridor

## Problem Description
String `corridor` ('S' seat, 'P' plant).
Divide into sections by adding dividers.
Each section must have exactly 2 'S'.
Count ways modulo 10^9+7.

## Analysis

1.  **Counting**:
    -   Total seats must be even and > 0. If odd or 0, return 0.
    -   Group seats into pairs `(S1, S2), (S3, S4), ...`
    -   Between `(S2)` and `(S3)`:
        -   There are `k` plants between them.
        -   Number of positions for divider is `(index(S3) - index(S2))`.
        -   e.g. `S` `P` `P` `S`. 3 spaces? Yes. `Diff` indices.
    -   Multiply `(diff indices)` for all adjacent pairs of groups.
    -   `ans = (idx_3 - idx_2) * (idx_5 - idx_4) * ...`

## Implementation Details
-   Store indices of 'S'.
-   Check size even, > 0.
-   Loop `i` from 2 to `size - 2` step 2.
-   Multiply `(S[i] - S[i-1])`.
