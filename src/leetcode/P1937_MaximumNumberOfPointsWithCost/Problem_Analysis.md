# Problem Analysis: Maximum Number of Points with Cost

## Problem Description
Grid `points` ($m \times n$).
Pick one cell per row.
Score = sum(points) - sum(abs(col_i - col_{i+1})).
Maximize score.

## Analysis

1.  **DP with Optimization**:
    -   `dp[r][c]` = max points ending at row `r` col `c`.
    -   `dp[r][c] = points[r][c] + max(dp[r-1][k] - abs(c - k))`.
    -   Naive transition: $O(N)$ per cell. Total $O(M \cdot N^2)$. Too slow if $N=10^5$. Constraint sum(cells) $\le 10^5$. N can be large.
    -   Optimization: `max(dp[r-1][k] - abs(c - k))` can be split.
        -   Case $k \le c$: `dp[r-1][k] - c + k = (dp[r-1][k] + k) - c`.
        -   Case $k > c$: `dp[r-1][k] - k + c = (dp[r-1][k] - k) + c`.
    -   For row `r`:
        -   Compute `left[c] = max(dp[r-1][k] + k)` for $k \le c$. Can be done with prefix max scan.
        -   Compute `right[c] = max(dp[r-1][k] - k)` for $k \ge c$. Suffix max scan.
        -   `dp[r][c] = points[r][c] + max(left[c] - c, right[c] + c)`.
    -   Complexity: $O(M \cdot N)$. Linear in grid size.

## Implementation Details
-   Two arrays `prev`, `curr`.
-   Left/right passes.
