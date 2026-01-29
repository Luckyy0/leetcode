# Problem Analysis: Maximum Earnings From Taxi

## Problem Description
`n` locations (1 to n). `rides` (start, end, tip).
Profit = `end - start + tip`.
Can pick disjoint rides. Max profit.

## Analysis

1.  **Dynamic Programming (1D)**:
    -   `dp[i]` = Max profit using rides ending at or before `i`.
    -   Sort rides by `end`.
    -   Iterate `i` from 1 to `n`.
    -   `dp[i] = dp[i-1]` (skip location `i`).
    -   For each ride ending at `i` (start `s`, end `e`, tip `t`):
        -   `dp[i] = max(dp[i], dp[s] + (e - s + t))`.
    -   Note: `rides` array size `3*10^4`. Inner loop checking rides ending at `i`.
    -   Store rides in `List<Ride>[]` indexed by end time.

## Implementation Details
-   `long[] dp` size `n+1`.
-   Adjacency list.
