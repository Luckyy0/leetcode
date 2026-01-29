# Problem Analysis: Minimum Operations to Make the Array Increasing

## Problem Description
Array `nums`. In one op, `nums[i]++`.
Strictly increasing. Min ops.

## Analysis

1.  **Greedy**:
    -   Iterate `i` from 1 to `n-1`.
    -   If `nums[i] <= nums[i-1]`, we must increase `nums[i]` to `nums[i-1] + 1`.
    -   Diff = `nums[i-1] + 1 - nums[i]`.
    -   Add diff to total count.
    -   Set `nums[i]` to `nums[i-1] + 1`.

## Implementation Details
-   Loop.
