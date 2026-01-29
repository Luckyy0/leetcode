# Problem Analysis: Maximum Number of Consecutive Values You Can Make

## Problem Description
Coins `coins`.
Find max `x` such that all values `0` to `x-1` can be formed by subset sums. Return `x` (number of values).

## Analysis

1.  **Greedy**:
    -   Logic similar to "Smallest Non-Constructible Value".
    -   Sort coins.
    -   Let `current_range` be the max value such that we can form `[0, current_range]`.
    -   Initially `current_range = 0`.
    -   For next coin `c`:
        -   If `c <= current_range + 1`: we can extend range to `current_range + c`.
            -   (Since we can form `0...R`, adding `c` gives `c...R+c`. Since `c <= R+1`, the intervals `[0, R]` and `[c, R+c]` overlap or touch, merging to `[0, R+c]`).
        -   If `c > current_range + 1`: we cannot form `current_range + 1`. Gap. Stop.
    -   Result is `current_range + 1`.

2.  **Algorithm**:
    -   Sort. Iterate.
    -   Assume coins are positive.

## Implementation Details
-   Sort.
