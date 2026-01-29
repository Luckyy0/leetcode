# Problem Analysis: Remove All Ones With Row and Column Flips II

## Problem Description
P2174. Given grid `m x n`.
Operation: Choose `(r, c)` where `grid[r][c] == 1`.
Flip all cells in row `r` and column `c` to 0.
Wait. The operation is "Change them to 0". Not flip (toggle). Just REMOVE.
"Remove all ones".
Min operations.

## Analysis

1.  **Backtracking / State Space Search**:
    -   Constraints `m, n` usually small (e.g. <= 15 total cells? or m, n <= 4?).
    -   Check P2174 constraints: `m, n <= 15` meaning total ones <= 15?
    -   Usually max `m*n <= 15` or max ones is small.
    -   If `m, n` are small (e.g. up to 6), we can use BFS on grid state.
    -   Grid state is bitmask? $2^{15}$. Feasible.
    -   Operations: Pick any `1` at `(r, c)`. Transition: `state & ~row_mask(r) & ~col_mask(c)`.
    -   BFS for shortest path to state 0.

2.  **Algorithm**:
    -   State: integer (if $m \times n \le 20$).
    -   Queue. `vis` map/set.
    -   BFS.

## Implementation Details
-   Map grid to int. `1 << (i*n + j)`.
-   Masks for rows/cols precomputed.
