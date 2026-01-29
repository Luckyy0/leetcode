# Problem Analysis: Find the Minimum and Maximum Number of Nodes Between Critical Points

## Problem Description
Linked List `head`.
Critical point: local min or local max.
Wait, node must have prev and next.
Local min: `prev.val > curr.val < next.val`.
Local max: `prev.val < curr.val > next.val`.
Return `[minDistance, maxDistance]`.
If < 2 critical points, `[-1, -1]`.

## Analysis

1.  **Traversal**:
    -   Keep `prev`, `curr`, `next`.
    -   List indices of critical points.
    -   If list size < 2, return `[-1, -1]`.
    -   Max dist = `last - first`.
    -   Min dist = min of `CP[i] - CP[i-1]`.

## Implementation Details
-   Single pass. Record first, last, prev_cp.
