# Problem Analysis: Find a Peak Element II

## Problem Description
2D matrix `mat` (`m x n`).
Find a peak element essentially. `mat[i][j] > neighbors` (top, bottom, left, right).
Return any peak `[r, c]`.

## Analysis

1.  **Binary Search + Greedy**:
    -   Similar to 1D peak finding, but across dimensions.
    -   Perform Binary Search on **rows** (or columns).
    -   Let `mid` be the current row index.
    -   Find the **global maximum element in row `mid`**. Let its index be `(mid, maxCol)`.
    -   Check neighbors of `(mid, maxCol)`.
    -   Specifically, check the vertical neighbors: `mat[mid-1][maxCol]` and `mat[mid+1][maxCol]`.
    -   Since `mat[mid][maxCol]` is max in its row, it is larger than `mat[mid][maxCol-1]` and `mat[mid][maxCol+1]`.
    -   If `mat[mid][maxCol] > mat[mid-1][maxCol]` and `mat[mid][maxCol] > mat[mid+1][maxCol]`, then it is a 2D peak.
    -   If `mat[mid][maxCol] < mat[mid+1][maxCol]`, then there must be a peak in the botton half `[mid+1, high]`.
        -   Why? Because we can perform an ascent path starting from `mid+1` going strictly upwards. Since boundaries are -infinity, it will terminate at a peak.
    -   If `mat[mid][maxCol] < mat[mid-1][maxCol]`, peak in top half `[low, mid-1]`.
    -   Complexity: $O(N \log M)$ or $O(M \log N)$.

2.  **Implementation**:
    -   BS on rows. Loop cols to find max.

## Implementation Details
-   `startRow`, `endRow`.
