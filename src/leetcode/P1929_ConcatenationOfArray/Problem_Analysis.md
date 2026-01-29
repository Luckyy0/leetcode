# Problem Analysis: Concatenation of Array

## Problem Description
`nums` length `n`. Return `ans` length `2n` where `ans[i] == nums[i]` and `ans[i+n] == nums[i]`.

## Analysis

1.  **Simple Copy**:
    -   Create array size `2n`.
    -   Loop `i` from 0 to `n-1`.
    -   Assign `ans[i] = nums[i]`.
    -   Assign `ans[i+n] = nums[i]`.

## Implementation Details
-   Loop.
