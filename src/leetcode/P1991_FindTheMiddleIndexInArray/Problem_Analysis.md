# Problem Analysis: Find the Middle Index in Array

## Problem Description
Same as "Find Pivot Index".
Left sum == Right sum. Exclude middle elements.
Return Leftmost index.

## Analysis

1.  **Total Sum**:
    -   `totalSum`.
    -   Iterate `i`: `leftSum`. `rightSum = totalSum - leftSum - nums[i]`.
    -   If `leftSum == rightSum`, return `i`.
    -   Update `leftSum`.

## Implementation Details
-   Loop.
