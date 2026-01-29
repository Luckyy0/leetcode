# Problem Analysis: Find the Most Competitive Subsequence

## Problem Description
Given an integer array `nums` and an integer `k`, return the most competitive subsequence of `nums` of size `k`.
`a` is more competitive than `b` if `a` is lexicographically smaller than `b`.

## Analysis

1.  **Monotonic Stack**:
    -   We want to pick `k` elements such that the result is smallest lexicographically.
    -   This means the first element should be as small as possible, then the second, etc.
    -   We iterate through `nums`. We maintain a stack of "selected candidates".
    -   When seeing `x`, if `x < stack.peek()` and we have enough remaining elements to fill the subsequence to length `k` even if we pop, then pop `stack.peek()`.
    -   Condition to pop: `stack.size() + (n - 1 - i) >= k`.
    -   Push `x` if `stack.size() < k`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(K)$.

## Implementation Details
-   Stack or array simulation.
-   Be careful with stack size check.
