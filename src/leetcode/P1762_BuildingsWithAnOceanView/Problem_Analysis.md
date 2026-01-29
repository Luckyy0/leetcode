# Problem Analysis: Buildings With an Ocean View

## Problem Description
Heights `heights`. Building has ocean view if all buildings to right are smaller.
Return indices.

## Analysis

1.  **Right to Left**:
    -   Iterate from right. Track `maxHeight`.
    -   If `curr > maxHeight`, add to list. Update `maxHeight`.
    -   Result list needs to be sorted (indices). Since traversing right-to-left, just reverse or add to front.

## Implementation Details
-   Loop.
