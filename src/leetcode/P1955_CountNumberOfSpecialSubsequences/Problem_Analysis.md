# Problem Analysis: Count Number of Special Subsequences

## Problem Description
Array `nums` (0, 1, 2).
Special subsequence: form `0...0 1...1 2...2`.
(At least one 0, then at least one 1, then at least one 2).
Count mod $10^9 + 7$.

## Analysis

1.  **DP**:
    -   `dp[0]`: Number of special subsequences ending in 0 (form `0...0`).
    -   `dp[1]`: Number of special subsequences ending in 1 (form `0...0 1...1`).
    -   `dp[2]`: Number of special subsequences ending in 2 (form `0...0 1...1 2...2`).
    -   Transitions for `x` in `nums`:
        -   If `x == 0`: Can append to existing `dp[0]` subsequences (doubling them) OR start a new one. `new_dp0 = 2 * dp[0] + 1`.
        -   If `x == 1`: Can append to existing `dp[1]` (doubling) OR append to `dp[0]` (transition). `new_dp1 = 2 * dp[1] + dp[0]`.
        -   If `x == 2`: Can append to existing `dp[2]` (doubling) OR append to `dp[1]` (transition). `new_dp2 = 2 * dp[2] + dp[1]`.
    -   Return `dp[2]`.

## Implementation Details
-   Loop array.
-   Modulo arithmetic.
