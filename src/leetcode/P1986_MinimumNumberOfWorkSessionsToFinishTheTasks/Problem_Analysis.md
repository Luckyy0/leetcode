# Problem Analysis: Minimum Number of Work Sessions to Finish the Tasks

## Problem Description
Array `tasks`. `sessionTime`.
Partition tasks into min number of sessions such that sum of tasks in each session $\le$ `sessionTime`.
Basically Bin Packing Problem (minimize bins). Constraints $N \le 14$.

## Analysis

1.  **Dynamic Programming with Bitmask**:
    -   Since $N$ is small, mask DP.
    -   `dp[mask]` = min sessions for subset `mask`.
    -   Transition: Iterate all submasks? $O(3^N)$.
        -   `dp[mask] = 1 + dp[mask ^ submask]` if `sum(submask) <= sessionTime`.
        -   Iterating submasks of mask: Loop `s = mask; s > 0; s = (s-1) & mask`.
        -   $3^{14} \approx 4.7 \times 10^6$. Feasible.
    -   Optimization: Precompute sums of all masks.

2.  **Optimized DP State**:
    -   `dp[mask] = {sessions, current_session_time}`.
    -   Try appending each task `i` not in mask.
    -   If `curr + task[i] <= sessionTime`, update `(sessions, curr + task[i])`.
    -   Else, update `(sessions + 1, task[i])`.
    -   Minimize `sessions` then `current_session_time`.
    -   Complexity: $O(2^N \cdot N)$. $2^{14} \cdot 14 \approx 2 \times 10^5$. Much faster.

## Implementation Details
-   `Pair<Integer, Integer> dp[1<<N]`.
