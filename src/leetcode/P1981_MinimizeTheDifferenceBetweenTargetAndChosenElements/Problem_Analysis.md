# Problem Analysis: Minimize the Difference Between Target and Chosen Elements

## Problem Description
Matrix `m x n`. Pick one integer per row.
Sum of chosen elements = `S`.
Minimize `abs(S - target)`.
Constraints: `m, n` up to 70. Values up to 70. Target up to 800.
Max sum ~ $70 \times 70 = 4900$.

## Analysis

1.  **Reachable Sums with Bitset/Boolean Array**:
    -   `dp[sum]` = boolean (possible to reach sum).
    -   Iterate rows:
        -   `next_dp` initialized false.
        -   For each `reachable` in `dp`:
            -   For each `val` in `row`:
                -   `next_dp[reachable + val] = true`.
    -   Optimization: `BitSet` or sparse iteration.
    -   Since sum range is small (target 800, but logic might require checking sums slightly larger than target to find closest).
    -   Max relevant sum: Target + MaxVal (anything beyond is suboptimal compared to Target+MaxVal if Target < S).
    -   Actually, we might pick large numbers if forced.
    -   Max possible sum is 4900.
    -   For each row, use a `Set` or `boolean[]`.
    -   To optimize: Sort and dedup values in each row.
    -   Pruning: If Min possible sum > target, just take min sum.
    -   Max relevant sum tracking? Usually sum <= 5000 is small enough for full boolean array.

## Implementation Details
-   `boolean[4901] dp`.
-   Iterate rows.
