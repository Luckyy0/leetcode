# Problem Analysis: Minimum Sideway Jumps

## Problem Description
Length `n`. 3 lanes (1, 2, 3).
Obstacles at `obstacles[i]` (0 if none, 1/2/3 blocking that lane).
Start at point 0 lane 2.
Min side jumps to reach point `n`.
Side jumps possible at same point `i`.

## Analysis

1.  **DP**:
    -   `dp[lane]` = min jumps to reach current point `i`.
    -   Initialize `dp[1] = 1, dp[2] = 0, dp[3] = 1` at start.
    -   Iterate `i` from 1 to `n`.
    -   For each point `i`:
        -   First, check obstacles at `i`. If `obstacles[i] == L`, set `dp[L] = infinity`.
        -   Then allow side jumps from accessible lanes to others.
        -   `dp[L] = min(dp[L], dp[other] + 1)`.
    -   Wait, order matters?
    -   At point `i`, we arrive from `i-1`.
    -   `next_dp[L] = (obstacles[i] == L) ? INF : dp[L]`. (Move forward).
    -   Then allow side jumps at `i`: `next_dp[L] = min(next_dp[L], next_dp[other] + 1)` (if not blocked).
    -   Notice: side jumps happen at the same point. Can jump multiple times? "Minimum side jumps". jumping 1->2->3 is 2 jumps. jumping 1->3 directly is 1 jump?
    -   Problem says "jump to any lane". Usually means 1 jump. Cost 1.
    -   So check min of others + 1.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Array `dp[4]`. (1-based indices).
-   INF large value.
