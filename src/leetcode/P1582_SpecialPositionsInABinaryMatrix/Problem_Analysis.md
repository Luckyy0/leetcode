# Problem Analysis: Special Positions in a Binary Matrix

## Problem Description
Given an `m x n` binary matrix `mat`, return the number of special positions in `mat`.
A position `(i, j)` is called special if `mat[i][j] == 1` and all other elements in row `i` and column `j` are `0` (rows and columns are 0-indexed).

## Analysis

1.  **Conditions**:
    -   `mat[i][j] == 1`.
    -   `sum(row i) == 1`.
    -   `sum(col j) == 1`.

2.  **Algorithm**:
    -   First pass: Calculate `rowSum` array and `colSum` array.
    -   Second pass: Iterate through the matrix.
    -   If `mat[i][j] == 1` AND `rowSum[i] == 1` AND `colSum[j] == 1`:
        -   It is a special position. Increment count.
    
3.  **Complexity**:
    -   Time: $O(M \times N)$ to compute sums and check.
    -   Space: $O(M + N)$ to store sums.

## Implementation Details
-   2D loop.
