# Problem Analysis: Maximum Height by Stacking Cuboids

## Problem Description
Cuboids `[width, length, height]`. Can choose dimensions (rotate).
Stack `i` on `j` if `wi <= wj` and `li <= lj` and `hi <= hj`.
Maximize total height.

## Analysis

1.  **Normalization**:
    -   For any cuboid, sort its dimensions: `d1 <= d2 <= d3`.
    -   Let `d3` be the height. This configuration ($h=d3$) is optimal to check fit because if $A \le B$, sorted $A \le$ sorted $B$ is a necessary condition.
    -   Also $d3$ as height maximizes contribution to sum?
        -   Does using `d3` as height strictly help?
        -   If we use `d2` as height, we have base $(d1, d3)$. This base is strictly larger than $(d1, d2)$.
        -   Usually strict LIS logic: we want to be "smaller" to sit on top.
        -   Actually, standard approach for this problem: Sort dimensions of each cuboid. Then sort the list of cuboids based on dimensions. Then LIS.
        -   Why sorted dimensions? Because to check if A fits B, we can rotate both. The optimal rotation for "fitting" is always aligning sorted dimensions.
        -   Wait, if A fits B, is it guaranteed that `sort(A) <= sort(B)`? Yes.
        -   And if `sort(A) <= sort(B)`, can we orient A and B such that A fits B? Yes, use the sorted orientation.
        -   So we fix every cuboid to `d1 <= d2 <= d3`. `d3` is height.
        -   Sort cuboids by `(d1, d2, d3)` to verify topological order.
        -   `dp[i]` = max height ending with `i` at the bottom (or top).
        -   Assuming `i` at bottom: `dp[i] = height[i] + max(dp[j])` where `j` fits on `i`.
        -   Sort ascending. Process `i`. `j < i`. `j` fits on `i`? No, if sorted ascending, `j` is smaller. So `j` should be on top of `i`.
        -   `dp[i] = height[i] + max(dp[j])` where `j < i` AND `cuboid[j].w <= cuboid[i].w` etc.
        -   Since we sorted list, `j < i` is good heuristic but we must check dimensions explicitly.

2.  **Complexity**:
    -   Time: $O(N^2)$.
    -   Space: $O(N)$.

## Implementation Details
-   Sort each int[] in `cuboids`.
-   Sort `cuboids`.
-   DP loop.
