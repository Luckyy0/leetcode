# Problem Analysis: Pour Water Between Buckets to Make Water Levels Equal

## Problem Description
`buckets` with water.
Can pour from `i` to `j`. Loss `loss` percent.
Make all buckets equal amount `target`. Maximize `target`.

## Analysis

1.  **Binary Search on Answer**:
    -   Range `[0, max(buckets)]`? Actually `[0, sum]`.
    -   Check `target`:
        -   Calculate `excess` from buckets having `> target`.
        -   Calculate `needed` for buckets having `< target`.
        -   Pour `excess`: it becomes `excess * (1 - loss/100)`.
        -   Condition: `excess * (1 - loss/100) >= needed`.

## Implementation Details
-   `check(val)` function.
-   Binary Search low/high.
-   Precision `1e-5`.
