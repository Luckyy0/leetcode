# Problem Analysis: Minimum Number of Lines to Cover Points

## Problem Description
Points `(x, y)`.
Line can cover multiple points.
Minimum lines.

## Analysis

1.  **Bitmask DP**:
    -   `n <= 10`? Usually small for this type. P2152 `n`?
        -   If `n` large, `O(n^2)` greedy might fail.
        -   Wait, "Minimum Number of Lines to Cover Points". Usually `n` is small (e.g. 10-15).
    -   Precompute lines for every pair of points.
        -   Line covers a set of points (mask).
    -   `dp[mask]`: min lines to cover mask points.
    -   State transition:
        -   Pick first uncovered point `i` (lowest bit unset in `current_mask`).
        -   Try covering `i` with every other point `j`.
            -   Form line `(i, j)`. Calculate `line_mask`.
            -   `dp[mask | line_mask] = min(dp[mask | line_mask], dp[mask] + 1)`.
        -   What if `i` is the only point on the line? (Covered by itself).
            -   Transition `dp[mask | (1<<i)]`.
    -   Recurse or Iterate.

## Implementation Details
-   `n` constraints check. If `n` up to 10? Mask DP is feasible.
-   Corner case: 1 point.
-   Geometry: 3 points collinear?
-   Use `gcd` for slope.
