# Problem Analysis: Map of Highest Peak

## Problem Description
Grid `isWater`. Water height 0. Land height > 0.
Adjacent cells diff at most 1.
Maximize heights.

## Analysis

1.  **Multi-Source BFS**:
    -   Start BFS from all water cells (height 0).
    -   Enqueue `(r, c)` with dist 0.
    -   Mark visited.
    -   Expand. Next cells dist + 1.
    -   This guarantees max possible height for each cell (shortest path to nearest water).

2.  **Implementation**:
    -   Queue.
    -   Result matrix.

## Implementation Details
-   BFS.
