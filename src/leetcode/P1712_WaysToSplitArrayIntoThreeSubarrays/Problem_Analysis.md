# Problem Analysis: Ways to Split Array Into Three Subarrays

## Problem Description
Split `nums` into three non-empty contiguous subarrays `left`, `mid`, `right`.
Condition: `sum(left) <= sum(mid) <= sum(right)`.
Return number of ways modulo $10^9 + 7$.

## Analysis

1.  **Prefix Sum & Binary Search**:
    -   Calculate prefix sums `P`.
    -   Loop `i` from `0` to `n-3`. (End index of left).
    -   Left sum = `P[i]`.
    -   We need `mid` sum >= `P[i]` and `right` sum >= `mid` sum.
    -   Sum(mid) = `P[j] - P[i]`. Sum(right) = `P[n-1] - P[j]`.
    -   Condition 1: `P[j] - P[i] >= P[i]` $\implies P[j] >= 2 P[i]$.
    -   Condition 2: `P[n-1] - P[j] >= P[j] - P[i]` $\implies 2 P[j] <= P[n-1] + P[i]`.
    -   So for fixed `i`, we need `j` in range `(i, n-1)` such that:
        -   `P[j] >= 2 P[i]`
        -   `P[j] <= (P[n-1] + P[i]) / 2`
    -   Since `P` is sorted (nums are non-negative), we can use binary search or two pointers to find range `[L, R]` of valid `j`.
    -   Count `R - L + 1`.

2.  **Implementation**:
    -   Use helper `lowerBound` and `upperBound` logic.
    -   `lowerBound` finds first `j` where `P[j] >= 2 P[i]`.
    -   `upperBound` finds last `j` where `P[j] <= (P[n-1] + P[i]) / 2`.
    -   Indices constrained `j > i` and `j < n-1`.

3.  **Complexity**:
    -   Time: $O(N \log N)$ or $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   `lowerBound`: find first `pos >= val`.
-   `searchLast`: find last `pos <= val`.
