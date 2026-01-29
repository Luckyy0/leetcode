# Problem Analysis: Count Sub Islands

## Problem Description
`grid1`, `grid2` (binary).
Count islands in `grid2` which are sub-islands of `grid1`.
Sub-island: every cell `(r, c)` of island in `grid2` must be `1` in `grid1`.

## Analysis

1.  **DFS/BFS**:
    -   Iterate `grid2`. Find unvisited `1`.
    -   Start DFS to traverse the island in `grid2`.
    -   During DFS, check correspond cell in `grid1`.
    -   Maintain a boolean `isSubIsland`. If any cell `grid2[i][j] == 1` but `grid1[i][j] == 0`, then `isSubIsland = false`.
    -   Continue traversing entire island to mark visited.
    -   If `isSubIsland` remains true, increment count.

## Implementation Details
-   DFS recursive.
-   Mark visited by setting `grid2[i][j] = 0`.
