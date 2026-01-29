# Problem Analysis: Determine Whether Matrix Can Be Obtained By Rotation

## Problem Description
Two `n x n` binary matrices `mat` and `target`.
Determine if `mat` can be rotated 90 degrees clockwise any number of times to match `target`.

## Analysis

1.  **Simulation**:
    -   We check 4 rotations: 0, 90, 180, 270 degrees.
    -   Helper function to compare two matrices.
    -   Helper function (or inline logic) to rotate matrix.
    -   Better: Simply iterate 4 times. In each iteration, check if match. If not, rotate `mat` 90 degrees in-place or into new matrix.
    -   In-place rotation:
        -   Transpose.
        -   Reverse each row.

2.  **Complexity**:
    -   $O(N^2)$.
    -   4 rotations max.

## Implementation Details
-   `rotate` method.
-   `equals` check.
