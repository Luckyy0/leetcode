# Problem Analysis: Number of Ways to Build House of Cards

## Problem Description
Use exactly `n` cards.
Rows of triangles. Row `i` (from top 1..k) has `c[i]` triangles.
`c[i] >= 1`.
Constraint: `c[i+1] >= c[i] + 1` (Row below must have at least 1 more triangle).
Actually P2189 "House of Cards":
-   A house of cards is built by placing triangles.
-   Rule: A triangle at (row, grid_pos) is supported by 2 triangles at row+1.
-   Essentially, `triangles[row] < triangles[row+1]`.
-   Cost of a row with `k` triangles is `3k - 1` (2 sides per triangle, k-1 horizontal bases between them?).
-   Wait, standard logic is `3k - 1`. Let's verify.
    -   1 triangle: /\ (2 cards).
    -   2 triangles: /\ /\ with base? usually /_\ /_\?
    -   P2189 definition: "Each triangle consists of 2 cards. For each row, horizontal cards are placed between adjacent triangles."
    -   So for `k` triangles: `2k` (sides) + `k-1` (bases between). Sum `3k - 1`.
-   Problem: Ways to build using exactly `n` cards.
-   Rows must strictly increase in count. (Stable).

## Analysis

1.  **DP (Knapsack-like)**:
    -   `dp[used][last_row_k]`.
    -   State: Total cards used `u`, last (bottom-most so far) row had `k` triangles.
    -   Next row (below) must have `next_k >= k + 1`.
    -   Cost `next_k`: `3*next_k - 1`.
    -   This is summing a strictly increasing sequence `k1, k2, ...` where `k1 >= 1` and `cost(ki) = 3ki - 1`, sum = `n`.
    -   Actually better: Reverse view. We build from Top.
    -   Top row: `k` triangles. Cost `3k-1`.
    -   But top row must be supported. If we just sum layers, it's just a partition problem `n = sum(3k_i - 1)` s.t. `k_{i+1} >= k_i + 1`.
    -   Max `n = 500`.
    -   `dp[rem_cards][prev_k]`.
    -   Iterate `next_k` starting from `prev_k + 1`.
    -   `rem_cards -= (3*next_k - 1)`.
    -   Base case: `rem_cards == 0`.
    -   Optimization: `next_k` doesn't go very high. `3k` approx `n`. `k ~ 160`.

## Implementation Details
-   `dp[n+1][n/2ish]`?
-   Memoization.

