# Problem Analysis: Where Will the Ball Fall

## Problem Description
Grid `m x n` with diagonals. `grid[i][j] = 1` (\) or `-1` (/).
Balls drop from top. Return exit column or -1.

## Analysis

1.  **Simulation**:
    -   Iterate each ball `b` from 0 to `n-1`.
    -   Track `currCol`. `currRow` from 0 to `m-1`.
    -   At `(r, c)`:
        -   If `grid[r][c] == 1`:
            -   Moving Right. Check `c+1`.
            -   If `c+1 >= n` or `grid[r][c+1] == -1` (V-shape), stuck.
            -   Else `c = c+1`. moves to row `r+1`.
        -   If `grid[r][c] == -1`:
            -   Moving Left. Check `c-1`.
            -   If `c-1 < 0` or `grid[r][c-1] == 1`, stuck.
            -   Else `c = c-1`. moves to row `r+1`.
    -   If finish `r=m`, record `c`.

2.  **Complexity**:
    -   Time: $O(M \cdot N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Loop.
