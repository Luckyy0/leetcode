# Problem Analysis: Largest Submatrix With Rearrangements

## Problem Description
Binary matrix. Rearrange columns. Largest submatrix of 1s.

## Analysis

1.  **Consecutive Ones**:
    -   Calculate `height[i][j]`: number of consecutive 1s ending at `(i, j)` moving upwards.
    -   `if med[i][j] == 1: height[i][j] = height[i-1][j] + 1`.
    -   Else 0.

2.  **Sorting**:
    -   For each row `i`:
        -   We have heights `h = height[i]`.
        -   Sort `h` descending.
        -   For each `k` in sorted `h`:
            -   We can form rectangle of height `h[k]` and width `k+1`.
            -   `area = h[k] * (k+1)`.
    
3.  **Complexity**:
    -   Time: $O(M \cdot N \log N)$.
    -   Space: $O(M \cdot N)$.

## Implementation Details
-   Update heights row by row. Calculate area.
