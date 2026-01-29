# Problem Analysis: Slowest Key

## Problem Description
You given an array `releaseTimes` and string `keysPressed`. `releaseTimes[i]` is when the `i-th` key was released. The duration is `releaseTimes[i] - releaseTimes[i-1]` (start from 0).
Return the key with the longest duration. Tie-break: largest lexicographical char.

## Analysis

1.  **Loop**:
    -   Iterate `i` from 0 to `n-1`.
    -   Start time `prev = (i==0) ? 0 : releaseTimes[i-1]`.
    -   Duration `d = releaseTimes[i] - prev`.
    -   Check if `d > maxDuration` OR (`d == maxDuration` and `char > maxChar`).

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Simple loop.
