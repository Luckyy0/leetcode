# Problem Analysis: Minimum Operations to Make a Uni-Value Grid

## Problem Description
Matrix `grid` `m x n`. Int `x`.
Op: `grid[i][j] += x` or `-= x`.
Make all elements equal. Min operations.
If impossible, -1.

## Analysis

1.  **Median Logic**:
    -   To minimize `sum |val - target|`, target is Median.
    -   Constraint: Can only change by `x`.
    -   This implies all elements must have same remainder modulo `x`.
    -   Check `grid[i][j] % x`. If not all same, return -1.
    -   If valid, flatten grid to array. Sort.
    -   Find median `target`.
    -   Calc operations: `sum(|val - target| / x)`.

## Implementation Details
-   Flatten.
-   Sort.
-   Median.
