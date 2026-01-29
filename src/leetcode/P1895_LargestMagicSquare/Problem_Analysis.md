# Problem Analysis: Largest Magic Square

## Problem Description
`grid` `m x n`.
Magic square: `k x k` subgrid where sums of rows, cols, diagonals are equal.
Max `k`.

## Analysis

1.  **Prefix Sums**:
    -   Compute prefix sums for rows (`rowSum`), cols (`colSum`).
    -   Check diagonals manually or with prefix sum?
    -   Prefix sum for diagonals is possible `diagSum[i][j]` = `grid[i][j] + diagSum[i-1][j-1]`. `antiDiagSum[i][j] = grid[i][j] + antiDiagSum[i-1][j+1]`.
    -   This allows $O(1)$ sum retrieval.
    
2.  **Iterate**:
    -   Iterate `k` descending from `min(m, n)` to 1.
    -   Iterate top-left `(i, j)`.
    -   Check if valid.
    -   Check rows, cols, diags sums equal.
    -   Return `k` immediately.

## Implementation Details
-   Prefix arrays: 2D row, 2D col, 2D diag, 2D anti.
-   Loop `k`, `i`, `j`.
