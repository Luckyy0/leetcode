# Problem Analysis: Minimum Time to Finish the Race

## Problem Description
`tires[i] = [f, r]`. `changeTime`. `numLaps`.
Lap time: $f \cdot r^{lap-1}$.
Change tire cost `changeTime`.
Minimize time for `numLaps`.

## Analysis

1.  **DP + Precomputation**:
    -   Since $r \ge 2$, the lap time grows exponentially.
    -   $f \cdot r^{x}$ exceeds `changeTime + f` very quickly.
    -   Max laps on a single set of tires is small (e.g. ~18 laps because $2^{18}$ is huge).
    -   Step 1: Compute `min_cost[x]` = min time to run exactly `x` consecutive laps with ONE set of tires (without changing).
        -   Iterate all tires.
        -   Run laps until `lap_time > changeTime + f` (heuristic bound, or hard limit 20).
        -   Update `min_cost[x]`.
    -   Step 2: DP `dp[i]` = min time to finish `i` laps.
        -   `dp[i] = min(dp[i - j] + min_cost[j] + changeTime)` for `1 <= j <= 20`.
        -   First stint doesn't need `changeTime`.
        -   We can incorporate `changeTime` differently:
            -   `dp[i]` min time to finish `i` laps.
            -   `dp[i] = min(valid j): (i==j ? -changeTime : dp[i-j]) + min_cost[j] + changeTime`.
            -   Actually simpler: `dp[i]` usually includes change time for the *next* change, or assume 0 change time at start.
            -   Definition: `dp[i]` time to complete `i` laps.
            -   Transition: `dp[i] = min(dp[i-j] + changeTime + min_cost[j])`.
            -   Base case: `dp[0] = -changeTime`? So `dp[j] = -changeTime + changeTime + min_cost[j] = min_cost[j]`. Correct.
            -   Or Base Case: `dp[0] = 0`. But we handle first stint separately?
            -   Standard: `dp[i] = min(min_cost[i], min_{1<=j<i} (dp[i-j] + changeTime + min_cost[j]))`.

## Implementation Details
-   `min_cost` array size ~20. Init MAX.
-   Loop tires. Inner loop laps.
-   `dp` size `numLaps + 1`.
