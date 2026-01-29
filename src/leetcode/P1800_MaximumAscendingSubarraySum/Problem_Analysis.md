# Problem Analysis: Maximum Ascending Subarray Sum

## Problem Description
Max sum of ascending subarray.
`nums[i-1] < nums[i]`.

## Analysis

1.  **Linear Scan**:
    -   Track `currentSum`.
    -   If `nums[i] > nums[i-1]`, add to `currentSum`.
    -   Else, reset `currentSum = nums[i]`.
    -   Track `maxSum`.

## Implementation Details
-   Loop.
