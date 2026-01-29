# Problem Analysis: Maximize Score After N Operations

## Problem Description
Array `nums`. Size `2*n`. Perform `n` operations.
i-th operation (1-indexed): pick 2 ints `x, y` not picked yet.
Score `i * gcd(x, y)`.
Max score.

## Analysis

1.  **DP with Bitmask**:
    -   $N \le 7$ (size 14). Small enough for bitmask.
    -   Mask size $2^{14} = 16384$.
    -   `dp[mask]` = max score using subset `mask`.
    -   Transition: Pick 2 bits `j, k` from remaining. Operation index based on number of set bits.
    -   Op index `op = (set_bits / 2) + 1`.
    -   `dp[mask | (1<<j) | (1<<k)] = max(prev, dp[mask] + op * gcd(nums[j], nums[k]))`.
    -   Better direction: Top-down with memoization?
    -   `solve(mask, op_index)`. `op_index` is derived from mask.

2.  **Implementation**:
    -   Precompute GCD pairs.
    -   State `mask`.
    -   Transitions: Loop pairs from unset bits.

3.  **Complexity**:
    -   States: $2^{14}$. Transitions: $O(N^2)$. Total $\approx 14^2 \cdot 16384 \approx 3 \cdot 10^6$. Fast.

## Implementation Details
-   `memo[1 << 14]`.
-   GCD helper.
