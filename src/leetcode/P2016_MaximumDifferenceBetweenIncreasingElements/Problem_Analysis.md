# Problem Analysis: Maximum Difference Between Increasing Elements

## Problem Description
Array `nums`. `i < j` and `nums[i] < nums[j]`.
Max `nums[j] - nums[i]`.
If none, -1.

## Analysis

1.  **Track Min Element**:
    -   Loop `j` from 0 to n.
    -   Track `minVal` so far.
    -   Diff = `nums[j] - minVal`.
    -   Update max diff.
    -   Update minVal.

## Implementation Details
-   Loop.
