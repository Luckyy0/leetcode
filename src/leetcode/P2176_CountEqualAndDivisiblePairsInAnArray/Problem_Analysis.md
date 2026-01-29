# Problem Analysis: Count Equal and Divisible Pairs in an Array

## Problem Description
`nums`, `k`. Count `(i, j)` such that `0 <= i < j < n`, `nums[i] == nums[j]`, and `(i * j) % k == 0`.

## Analysis

1.  **Brute Force**:
    -   `n <= 100` usually for easy problems. The constraints are small (n <= 1000).
    -   $N^2 = 10^6$. Acceptable.

2.  **GCD Approach (Optimized)**:
    -   Group indices by value.
    -   For a list of indices `idx_1, idx_2...`. Check pairs.
    -   Still $O(N^2)$ worst case.
    -   Given constraints, brute force is fine.

## Implementation Details
-   Nested Loop.
