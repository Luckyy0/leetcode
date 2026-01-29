# Problem Analysis: Add Minimum Number of Rungs

## Problem Description
Array `rungs`. `dist`.
Start at 0. Can climb height `dist`.
If next rung diff > `dist`, need to add rungs.
Minimize added rungs.

## Analysis

1.  **Greedy**:
    -   Current height `h = 0`.
    -   For each rung `r`:
    -   If `r - h > dist`:
        -   Gap `g = r - h`.
        -   Need to cover gap. One jump covers `dist`.
        -   Added rungs: `(g - 1) / dist`.
        -   Example: gap 3, dist 1. Needed: 1, 2. Add 2. Formula: `(3-1)/1 = 2`.
        -   Example: gap 3, dist 3. Needed: 0. Formula: `(3-1)/3 = 0`.
    -   Update `h = r`.
    -   Return sum of added.

## Implementation Details
-   Loop.
