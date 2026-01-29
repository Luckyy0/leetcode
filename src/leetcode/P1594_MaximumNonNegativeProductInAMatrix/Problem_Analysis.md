# Problem Analysis: Maximum Non-Negative Product in a Matrix

## Problem Description
You are given an `m x n` matrix `grid`. Initially, you are located at the top-left corner `(0, 0)`, and you want to reach the bottom-right corner `(m - 1, n - 1)`. In the steps, you can only move either right or down.
If the path product is negative, return -1.
Return the maximum non-negative product modulo $10^9 + 7$.

## Analysis

1.  **State**:
    -   `maxProd[i][j]`: max product reaching `(i, j)`.
    -   `minProd[i][j]`: min product reaching `(i, j)` (needed because neg * neg = pos).

2.  **Transitions**:
    -   `val = grid[i][j]`.
    -   If `val > 0`:
        -   `maxP = val * max(max(top), max(left))`.
        -   `minP = val * min(min(top), min(left))`.
    -   If `val < 0`:
        -   `maxP = val * min(min(top), min(left))`.
        -   `minP = val * max(max(top), max(left))`.
    -   If `val == 0`:
        -   `maxP = 0, minP = 0`.

3.  **Initialization**:
    -   `maxProd[0][0] = minProd[0][0] = grid[0][0]`.
    -   Handle first row and first column carefully.

4.  **Result**:
    -   If `maxProd[m-1][n-1] < 0`, return -1.
    -   Else return `maxProd % MOD`.
    -   Note: We should perform calculations in `long` without modulo during steps to properly compare magnitudes. Values up to $4^{15}$ comfortably fit in long. Wait, wait. M, N up to 15? Max dimension 15 for rows/cols? "m and n are between 1 and 15".
    -   Max path length is $15+15-2 = 28$.
    -   $4^{28} \approx 7 \times 10^{16}$. `long` max is $9 \times 10^{18}$.
    -   So standard `long` is sufficient. No BigInteger needed.

## Implementation Details
-   DP arrays `long[][]`.
