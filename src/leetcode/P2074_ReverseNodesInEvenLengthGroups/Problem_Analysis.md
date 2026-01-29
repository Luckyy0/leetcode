# Problem Analysis: Reverse Nodes in Even Length Groups

## Problem Description
List `head`. Group sizes 1, 2, 3, 4, ...
If group has even length, reverse it.
If last group has fewer nodes than `k` (expected), check its ACTUAL length. If actual even, reverse.

## Analysis

1.  **Group Iteration**:
    -   Expected size `k` starts at 1.
    -   Traverse list to identify actual group.
    -   Count nodes `count`. If `count % 2 == 0`, reverse.
    -   Link previous group tail to new head. New tail to next group head.
    -   Update `k++`.

## Implementation Details
-   `prevTail`, `currHead`.
-   Loop while list not empty.
-   Count next `k` nodes.
-   If `curr` is null, stop.
-   Reverse helper.
