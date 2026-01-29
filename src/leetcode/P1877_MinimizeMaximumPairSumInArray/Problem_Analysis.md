# Problem Analysis: Minimize Maximum Pair Sum in Array

## Problem Description
Array `nums`. Even length.
Sort pairs `(a,b)` such that max `a+b` is minimized.

## Analysis

1.  **Greedy**:
    -   Sort array.
    -   Smallest with Largest to average out sums.
    -   `max(nums[i] + nums[n-1-i])`.

## Implementation Details
-   Sort. Max loop.
