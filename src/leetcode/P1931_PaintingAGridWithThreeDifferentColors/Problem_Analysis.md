# Problem Analysis: Painting a Grid With Three Different Colors

## Problem Description
Grid `m x n` ($1 \le m \le 5$, $1 \le n \le 1000$).
Paint with 3 colors (Red, Green, Blue) such that no two adjacent cells have same color.
Return number of ways mod $10^9 + 7$.

## Analysis

1.  **Dynamic Programming with Profile**:
    -   Since $m$ is very small (up to 5), we can maintain the state of the current column.
    -   A column is defined by the colors of its $m$ cells.
    -   Colors: 0, 1, 2.
    -   Constraints within a column: `col[i] != col[i+1]`.
    -   Constraints between columns: `prev_col[i] != curr_col[i]`.
    -   State `dp[j][mask]`: Number of ways to paint first `j` columns where $j$-th column configuration is `mask`.
    -   Mask: Encode the tuple $(c_0, c_1, \dots, c_{m-1})$ as base-3 integer or simply integer index of valid patterns.
    -   Number of valid single-column patterns: $3 \times 2^{m-1}$. Max $3 \times 2^4 = 48$. Very small.
    -   Precompute adjacency matrix `adj[mask1][mask2]` which is true if `mask2` can follow `mask1`.
    -   Transition: `dp[j][mask] = sum(dp[j-1][prev])` for all compatible `prev`.
    -   Complexity: $N \times (\text{num\_patterns})^2$. With 48 patterns, $48^2 \approx 2300$. $N=1000$. Total $\approx 2.3 \times 10^6$. Very fast.

2.  **Implementation**:
    -   Generate valid column masks.
    -   Build adjacency.
    -   DP loop.

## Implementation Details
-   Recursion to generate masks.
-   `ArrayList<Integer> validMasks`.
