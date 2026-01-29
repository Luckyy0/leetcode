# Problem Analysis: Count Ways to Distribute Candies

## Problem Description
Distribute `n` unique candies into `k` identical bags such that no bag is empty.
Return count modulo $10^9 + 7$.

## Analysis

1.  **Stirling Numbers Kind 2**:
    -   Definition is exactly partitioning a set of `n` elements into `k` non-empty subsets.
    -   $S(n, k)$.
    -   Recurrence: $S(n, k) = S(n-1, k-1) + k \cdot S(n-1, k)$.
    -   Base cases:
        -   $S(n, n) = 1$.
        -   $S(n, 1) = 1$.
        -   $S(n, 0) = 0$.

2.  **Implementation**:
    -   Standard DP.
    -   $O(NK)$.
    -   Use `long` for modulo arithmetic.

## Implementation Details
-   DP table `dp[k+1]`. Optimize space.
-   `dp[j] = prev[j-1] + j * prev[j]`.
