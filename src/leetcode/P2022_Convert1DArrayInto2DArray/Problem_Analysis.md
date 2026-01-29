# Problem Analysis: Convert 1D Array Into 2D Array

## Problem Description
1D `original`. `m` rows, `n` cols.
Convert to 2D `m x n`.
If `original.length != m * n`, return empty.

## Analysis

1.  **Direct Mapping**:
    -   Check size.
    -   `res[i][j] = original[i * n + j]`.
    -   Or simple index tracking.

## Implementation Details
-   Loop.
