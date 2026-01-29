# Problem Analysis: Count Fertile Pyramids in a Land

## Problem Description
Grid `grid` (0, 1).
Pyramidal plot: height `h >= 2`.
Apex `(r, c)`.
Base `(r + h - 1, c - (h - 1))` to `(r + h - 1, c + (h - 1))`.
Basically triangle.
Also Inverse Pyramidal.
Count all fertile (all 1s) pyramids and inverse pyramids.

## Analysis

1.  **Dynamic Programming**:
    -   `dp[i][j]` = height of pyramid with apex at `(i, j)`.
    -   Actually better: `dp[i][j]` = height of pyramid with *base centered* at `(i, j)`? Or apex?
    -   Standard maximal square logic.
    -   Let `dp[i][j]` be the max height of a pyramid whose *apex* is at `(i, j)`.
        -   To have height `h`, we need `(i+1, j-1)` and `(i+1, j+1)` to support height `h-1`?
        -   Usually pyramid defined by levels.
        -   Apex `(0, 0)` -> Next level `(1, -1), (1, 0), (1, 1)`?
        -   Wait definition:
            -   Apex `(r, c)`.
            -   Cells `(i, j)` where `r <= i < r+h` and `c - (i - r) <= j <= c + (i - r)`.
            -   This means level `k` (0-indexed) has width `2k + 1` centered at `c`.
    -   DP formulation:
        -   Let `dp[i][j]` be the height of the largest pyramid with **apex** at `(i, j)`.
        -   `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1])`?
            -   Almost. We need the center `(i+1, j)` to be filled too?
            -   Wait. Level `1` (apex) is `(r, c)`.
            -   Level `2` is `(r+1, c-1), (r+1, c), (r+1, c+1)`.
            -   So apex at `(r, c)` needs `(r+1, c-1), (r+1, c), (r+1, c+1)` to be the top of a height `h-1` pyramid??
            -   No.
            -   Ideally, solve Bottom-Up.
            -   Let `dp[i][j]` be the height of the largest pyramid with **apex** at `(i, j)`.
            -   Requires `grid[i][j] == 1`.
            -   Requires support from row `i+1`.
            -   If `grid` allows, `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1])`?
            -   Let's trace.
            -   If `dp[i+1][j-1] = 1` (apex size 1). `dp[i+1][j+1] = 1`.
            -   This means `(i+1, j-1)` is a 1. `(i+1, j+1)` is a 1.
            -   Does this guarantee `(i+1, j)` is a 1? No.
            -   So we need `min(dp[i+1][j-1], dp[i+1][j+1])`? And check `grid[i+1][j]`?
            -   Actually, `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1], dp[i+1][j])`?
            -   Consider pyramid of height 2 at `(r, c)`.
            -   Needs `(r, c)` and `(r+1, c-1), (r+1, c), (r+1, c+1)`.
            -   If we define `dp` as max height.
            -   `dp[i][j]` depends on `i+1`.
            -   `dp[i+1][j-1]` covers `(r+1, c-1)` down to `...`.
            -   `dp[i+1][j+1]` covers `(r+1, c+1)` down to `...`.
            -   Does their intersection cover the middle? `dp[i+1][j]`?
            -   Yes, `min(left, right)` usually implies checking neighbors.
            -   Actually, simpler: `dp[i][j] = min(dp[i+1][j-1], dp[i+1][j+1]) + 1` *only if grid[i+1][j] is valid*.
            -   But wait, a pyramid of height `h` at `(i, j)` contains a pyramid of height `h-1` at `(i+1, j)`?
                -   Apex `(i, j)`. Base `i+h-1`.
                -   Pyramid `(i+1, j)` has height `h-1`, base `i+h-1`.
                -   The set of cells for `P(i+1, j, h-1)` is subset of `P(i, j, h)`?
                -   Yes. `i+1 <= k < i+h`. `j - (k - (i+1)) <= y <= j + ...`
                -   Formula: `c - (k - r) <= y <= c + (k - r)`.
                -   For shifted `r' = r+1`. `c - (k - r') <= y`.
                -   Difference is `k-r` vs `k-(r+1) = k-r-1`.
                -   The width at `k` for `(r, c)` is `2(k-r)+1`.
                -   The width at `k` for `(r+1, c)` is `2(k-r-1)+1`.
                -   Difference is 2. The `(r, c)` pyramid is wider by 1 on each side.
                -   So `P(r, c, h)` contains `P(r+1, c, h-1)` AND the borders?
                -   Just rely on the standard `min` recurrence.
                -   `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1], dp[i+1][j])`?
                -   Wait. If `dp[i+1][j]` (center) has height `k`, it means it extends `k` down.
                -   The recurrence `min(dp[i+1][j-1], dp[i+1][j+1])` is for triangle corners?
                -   Actually, if `dp[i+1][j]` is height `k`. It has width `2k+1` at bottom.
                -   Usually logic:
                    -   `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1])`? NO. This doesn't check center.
                    -   However, if `grid[i+1][j]` is needed?
                    -   Correct recurrence for "Pyramid":
                    -   `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1])` *assuming dp[i+1][j] is large enough*?
                    -   Actually `dp[i][j] = 1 + min(dp[i+1][j-1], dp[i+1][j+1])` is WRONG because it allows a hole in the middle.
                    -   Actually valid recurrence is `dp[i][j] = min(dp[i+1][j-1], dp[i+1][j+1], dp[i+1][j]) + 1`. (This ensures solid).
                        -   Wait. If `dp[i+1][j]` is small, it limits `dp[i][j]`.
                        -   Example: Height 2 at `(0,0)`.
                        -   Needs `(1, -1), (1, 0), (1, 1)` to be height 1 limits.
                        -   `dp[1][-1]=1, dp[1][0]=1, dp[1][1]=1`.
                        -   `min(1, 1, 1) + 1 = 2`. Correct.
                        -   If `(1, 0)` is 0. `min(1, 1, 0) + 1 = 1`. Correct (only apex).
                    -   So Recurrence: `dp[i][j] = min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1]) + 1` if `grid[i][j]==1`.
    
    -   Inverse Pyramids: Same logic but direction differs (look up `i-1`).
    -   Total count: Sum `(dp[i][j] - 1)` (since height 1 doesn't count as "pyramidal plot" ? "height h >= 1"? Problem says h >= 1? "Any ... h>=1 is a pyramid"?
    -   Problem: "A pyramid ... h >= 1"?
    -   Example 1 tells us count.
    -   Re-read carefully: "A farmer ... pyramidal plot ... height h >= 1".
    -   Sample 1: 1 pyramid. Grid `[[1,1,1],[1,1,1]]`?
    -   Ah, usually asks "count pyramids of height >= 2"? Or just count total?
    -   Description: "Count Fertile Pyramids". "pyramidal plot ... height h >= 1".
    -   BUT usually simplest 1-cell is a pyramid.
    -   Wait. "Note that the example shows h=2...".
    -   Is a single cell a pyramid? "A valid ... plot ... h >= 1".
    -   Wait. Problem statement usually asks for "h >= 2" or sums the count.
    -   Example 1: Grid `[[0,1,1,0],[1,1,1,1]]`. Output 2.
        -   One (0, 1) to (0, 2) ? No.
        -   Shows h=2. Apex (0, 1). Base (1, 0)..(1, 2).
        -   Another Apex (0, 2). Base (1, 1)..(1, 3).
        -   So total 2.
    -   It seems standard single cells (h=1) are NOT counted in the output? Or output is just h>=2 ?
    -   "Return the total number of pyramidal and inverse pyramidal plots".
    -   If h=1 is counted, then every `1` is a pyramid. Output would be large.
    -   Usually for this problem (P2088), the answer EXCLUDES h=1.
    -   Let's assume we sum `dp[i][j] - 1` (if dp > 0).
    -   Yes, check constraints/examples. `h=2` is cited.
    -   And logic `dp` gives max height `H`. Then pyramids at `(i, j)` are sizes `1, 2, ..., H`.
    -   If we only count `h >= 2`, we sum `H - 1`.

2.  **Algorithm**:
    -   Count Pyramids (Apex Up, Base Down). Traverse Bottom-Up. `dp[i][j] = min(...) + 1`. Sum `max(0, dp-1)`.
    -   Count Inverse (Apex Down, Base Up). Traverse Top-Down. `dp2[i][j] = ...`. Sum `max(0, dp2-1)`.
    -   Return total.

## Implementation Details
-   `countPyramids(grid)`.
-   Helper `count(grid)`.
-   Reverse grid and count again for inverse? Or just different loop direction.
