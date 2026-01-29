# Problem Analysis: Minimum Distance to the Target Element

## Problem Description
Array `nums`. `target`. `start`.
Find `i` where `nums[i] == target`. Minimize `abs(i - start)`.

## Analysis

1.  **Linear Scan**:
    -   Iterate all elements.
    -   If `nums[i] == target`, update `minDist`.
    -   Optimization: Expand from `start` outwards? Or just check all since linear is fast.

## Implementation Details
-   Loop.
