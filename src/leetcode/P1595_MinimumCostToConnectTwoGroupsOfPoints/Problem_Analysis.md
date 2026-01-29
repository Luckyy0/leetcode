# Problem Analysis: Minimum Cost to Connect Two Groups of Points

## Problem Description
Two groups of points. Group 1 has `size1` points, Group 2 has `size2` points. `cost[i][j]` connects `i` (Group 1) and `j` (Group 2).
Every point must be connected to at least one point in the other group.
Minimize cost.

## Analysis

1.  **State**:
    -   We iterate through points in Group 1. `dp[i][mask]` is min cost after processing points `0...i` in Group 1, with `mask` representing the points covered in Group 2.
    -   However, Group 1 points MUST be covered. Group 2 points tracked by mask.
    -   When considering point `i` in Group 1:
        -   It must connect to at least one `j`.
        -   It can connect to multiple `j`, but only if that's cheaper than connecting them separately?
        -   Actually, simpler transition: At state `i`, `mask`, we add edge `(i, j)`.
        -   Cost adds `cost[i][j]`. New mask `mask | (1 << j)`.
        -   This ensures `i` is connected.
        -   But what if `i` connects to multiple `j`s to cover them? And what if picking one `j` is enough for `i`, but we want to pick another `j` because it's cheap?
        -   Actually, for a fixed `i`, connecting to strictly one `j` is necessary for `i`. Connecting to additional `j'` is essentially equivalent to "covering `j'` cheaply using `i`".
    
2.  **Optimized DP**:
    -   State `dp[mask]` representing min cost to cover `mask` of Group 2 using a subset of Group 1 processed so far.
    -   Iterate `i` from 0 to `size1-1`.
    -   `next_dp` array.
    -   For `i`, we calculate cost to transition from `dp[mask]` to `next_dp[mask | (1<<j)]` via edge `(i, j)`.
    -   Also, we should consider that `i` can simply extend a mask?
    -   Wait. Every `i` MUST be handled. So transition `dp[i-1][mask] -> dp[i][mask | (1<<j)]` works.
    -   After done with all `i` (0 to size1 - 1), we have a set of costs `dp[final][mask]`.
    -   This state guarantees all `i` in Group 1 are connected.
    -   However, some `k` in Group 2 (bit `k` is 0 in mask) might NOT be connected.
    -   Since all points in Group 2 must be connected, for any unset bit `k`, we simply pick the cheapest edge incident to `k` (min cost column `k`).
    -   Final answer = `min over mask (dp[size1-1][mask] + cost_to_cover_remaining(mask))`.

3.  **Complexity**:
    -   $O(size1 \cdot 2^{size2} \cdot size2)$.
    -   $12 \cdot 4096 \cdot 12 \approx 6 \times 10^5$.

## Implementation Details
-   Precompute `minCols[col]`: min cost to connect `col` to any `row`.
-   DP array initialization with Infinity.
