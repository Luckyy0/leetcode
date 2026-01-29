# Problem Analysis: Cutting Ribbons

## Problem Description
Array `ribbons`. `k`.
Cut ribbons into `k` pieces of same length `x`.
Maximize `x`.

## Analysis

1.  **Binary Search on Answer**:
    -   Range `[1, max(ribbons)]`. Or `[1, sum/k]`. (Upper bound is max element).
    -   `check(len)`: `count = sum(ribbon / len)`.
    -   If `count >= k`, then `len` is possible. Try larger.

## Implementation Details
-   Binary search.
