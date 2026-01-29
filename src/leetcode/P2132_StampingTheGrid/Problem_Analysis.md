# Problem Analysis: Stamping the Grid

## Problem Description
Grid `m x n` (0 empty, 1 occupied).
Stamp `stampHeight x stampWidth`.
Can stamp empty cells. Overlapping stamps allowed.
Check if possible to stamp ALL empty cells.
Stamp cannot cover occupied cells.

## Analysis

1.  **2D Prefix Sum + Difference Array (Greedy)**:
    -   We want to cover every `0`.
    -   We validly place a stamp at `(r, c)` (top-left) if the rectangle `[r, r+h-1] x [c, c+w-1]` contains no `1`.
    -   Check occupied: Use 2D Prefix Sum on grid to query region sum in O(1).
    -   Greedy Strategy:
        -   Try to place a stamp at EVERY valid position.
        -   If a stamp is valid, mark the covered region as "stamped".
        -   After trying all stamps, check if all original `0`s are covered.
    -   To efficiently "mark covered":
        -   Use Difference Array (2D). When placing stamp at `(r, c)`, add +1 to region.
        -   Perform Prefix Sum on Difference Array to get coverage counts.
        -   Finally, check: For every cell `(i, j)`, if `grid[i][j] == 0`, we must have `coverage[i][j] > 0`.
    -   Complexity:
        -   Prefix Sum Grid: $O(MN)$.
        -   Iterate all top-lefts: $O(MN)$. Check valid: O(1). Update Diff: O(1).
        -   Reconstruct Coverage: $O(MN)$.
        -   Check: $O(MN)$.
        -   Total $O(MN)$.

## Implementation Details
-   `pref[m+1][n+1]`.
-   `diff[m+1][n+1]`.
-   Logic.
