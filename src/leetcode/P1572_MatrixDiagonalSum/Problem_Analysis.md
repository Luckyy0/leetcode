# Problem Analysis: Matrix Diagonal Sum

## Problem Description
Given a square matrix `mat`, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

## Analysis

1.  **Diagonals**:
    -   Primary Diagonal: Elements where `row == col`.
    -   Secondary Diagonal: Elements where `row + col == n - 1`.

2.  **Algorithm**:
    -   Initialize `sum = 0`.
    -   Loop `i` from 0 to `n-1`.
    -   Add `mat[i][i]` (Primary).
    -   Add `mat[i][n - 1 - i]` (Secondary).
    -   If `n` is odd, the center element `mat[n/2][n/2]` is added twice (once as primary, once as secondary).
    -   We can either subtract it once at the end, or check inside the loop `if (i != n - 1 - i)`.

3.  **Complexity**:
    -   Time: $O(N)$ (where N is row count, total elements $N^2$).
    -   Space: $O(1)$.

## Implementation Details
-   Simple loop.
