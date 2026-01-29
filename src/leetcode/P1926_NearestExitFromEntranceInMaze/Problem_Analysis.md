# Problem Analysis: Nearest Exit from Entrance in Maze

## Problem Description
Maze `m x n` ('.' empty, '+' wall). `entrance` (row, col).
Find nearest exit (empty cell on boundary, NOT entrance).
Return min steps. -1 if impossible.

## Analysis

1.  **BFS**:
    -   Shortest path in unweighted grid -> BFS.
    -   Start at `entrance`. Distance 0.
    -   Mark visited.
    -   Enqueue neighbors.
    -   If reach boundary cell (row==0 or m-1 or col==0 or n-1) AND cell != entrance: return distance.

## Implementation Details
-   Queue `int[]{r, c, dist}`.
-   Visited array or modify grid.
