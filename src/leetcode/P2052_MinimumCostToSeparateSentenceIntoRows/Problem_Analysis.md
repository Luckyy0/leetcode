# Problem Analysis: Minimum Cost to Separate Sentence Into Rows

## Problem Description
Sentence `sentence` (words). Max width `k`.
Wrap words. Cost of row is `(k - length)^2` (except last row cost 0).
Minimize total cost.

## Analysis

1.  **Dynamic Programming**:
    -   `dp[i]`: Min cost to wrap words starting from `i` to end.
    -   For a line starting at word `i`, we can end at word `j` if total length $\le k$.
    -   Cost = `(k - current_len)^2` + `dp[j+1]`.
    -   If `j` reaches end (last line), Cost = `0`.
    -   Constraint `N` (words) up to 5000? $O(N^2)$ DP is feasible.
    -   Lengths precomputed (prefix sums of lengths + spaces).

## Implementation Details
-   `int[] dp`.
-   Loop `i` backwards. Inner loop `j` forward.
