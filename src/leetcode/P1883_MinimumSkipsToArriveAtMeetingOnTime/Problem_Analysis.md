# Problem Analysis: Minimum Skips to Arrive at Meeting On Time

## Problem Description
`dist` array, `speed`, `hoursBefore`.
Can skip resting (waiting for ceil hours). Maximize skips? No, count min skips.

## Analysis

1.  **DP with avoiding double precision**:
    -   Scale time by `speed`. Distances are integers. Time = distance.
    -   `dp[i][j]` = min total distance (scaled time) travelled for first `i` roads with `j` skips.
    -   Resting logic:
        -   Scaled time arrival `T`.
        -   Wait until ceil: `(T + speed - 1) / speed * speed`.
        -   This ensures `T` is multiple of `speed` (integer hour).
    -   Recurrence:
        -   `dp[i][j] = min(`
            -   `ceil_aligned(dp[i-1][j]) + dist[i]`, // Wait (taken from prev with j skips)
            -   `dp[i-1][j-1] + dist[i]` // Skip (taken from prev with j-1 skips)
        -   `)`.
    -   Base cases: `dp[0][0] = 0`.
    -   Final check: `dp[n][j] <= hoursBefore * speed`.

2.  **Complexity**:
    -   $O(N^2)$. $N=1000$. Feasible.

## Implementation Details
-   1D arrays rolling? Wait, j depends on j and j-1. So iterate j downwards or use 2D.
-   Be careful with large numbers (long).
