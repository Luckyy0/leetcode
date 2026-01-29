# Problem Analysis: Find All Groups of Farmland

## Problem Description
Grid `land` (0, 1). 1: land. 0: forest.
Land forms rectangular groups.
Return coords `[r1, c1, r2, c2]` (top-left, bottom-right).
Groups are guaranteed to be rectangular and non-adjacent (4-direction).

## Analysis

1.  **scan**:
    -   Iterate `r`, `c`.
    -   If `land[r][c] == 1` and not visited (handled by identifying top-left):
        -   This is `r1, c1`.
        -   Since rectangular, find `r2` (expand down) and `c2` (expand right).
        -   Mark cells as visited or just use the property that we only process top-left.
        -   Top-left condition: `(r==0 or land[r-1][c]==0) AND (c==0 or land[r][c-1]==0)`.
        -   Find width: scan right until 0 or boundary.
        -   Find height: scan down until 0 or boundary.
        -   Add to result.

## Implementation Details
-   Loop.
-   Result List.
