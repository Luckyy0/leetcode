# Problem Analysis: Get Maximum in Generated Array

## Problem Description
You are given an integer `n`. An array `nums` of size `n + 1` is generated as follows:
-   `nums[0] = 0`
-   `nums[1] = 1`
-   `nums[2 * i] = nums[i]` when `2 <= 2 * i <= n`
-   `nums[2 * i + 1] = nums[i] + nums[i + 1]` when `2 <= 2 * i + 1 <= n`
Return the maximum integer in the array `nums`.

## Analysis

1.  **Simulation**:
    -   Simply array implementation.
    -   Iterate `i` from 1 up to `n/2`.
    -   Populate `2*i` and `2*i+1`.
    -   Track max value.
    -   Edge cases: n=0, n=1.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   Array size `n+1`.
-   Handle n=0 explicitly.
