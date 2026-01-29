# Problem Analysis: Number of Ways to Build Sturdy Brick Wall

## Problem Description
Height `h`, Width `w`. Bricks `bricks`.
Sturdy: No vertical line aligns between adjacent rows (except simple boundaries).
Lines align if sum of bricks is same.
So `prefix_sums` of row `i` and row `i+1` must NOT share any common value (except `w`).

## Analysis

1.  **DP + Bitmask (or Transition Matrix)**:
    -   Generate all valid row configurations for width `w`.
    -   Represent row as a set of split points (values in `(0, w)`).
    -   Actually, for `w <= 10`, `h <= 100`.
    -   Wait. `w` is usually small in this problem or `h`? P2184 `w` up to 10?
    -   Let's check typical constraints. Usually `w` is small enough to generate all tilings.
    -   Or `w` up to 100? No, `w <= 10`. `h <= 100`.
    -   Wait. If `w` is small, we can generate all valid brick layouts for a single row.
    -   A layout is defined by the set of "cuts" (indices where bricks end).
    -   Two rows are compatible if their cut sets are disjoint.
    -   Let `layouts` be list of valid cutmasks.
        -   Cutmask: bitmask of length `w-1`. Bit `j` is set if there is a cut at `j` (brick boundary).
    -   Algorithm:
        -   Find all valid `masks` for a row of width `w`.
            -   DFS/Recursion construction from `bricks`.
        -   Build adjacency graph: `compatible[i][j]` true if `(masks[i] & masks[j]) == 0`.
        -   DP: `dp[row][mask_idx]`.
        -   `dp[h]` total ways.
        -   Optimization: Matrix Exponentiation if `h` large? `h <= 100` -> Simple DP loop.

## Implementation Details
-   Generate valid ways to sum to `w`.
    -   Store as `int mask` (bits 1 to w-1).
-   DP Table: `dp[config]`.
-   Iterate `h-1` times.
