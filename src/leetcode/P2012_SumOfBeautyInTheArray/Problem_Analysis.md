# Problem Analysis: Sum of Beauty in the Array

## Problem Description
Array `nums`.
For each `i` (1 to n-2):
-   Beauty 2 if `nums[all left] < nums[i] < nums[all right]`.
-   Beauty 1 if `nums[i-1] < nums[i] < nums[i+1]` (and not beauty 2).
-   Beauty 0 otherwise.
Sum beauties.

## Analysis

1.  **Prefix Max, Suffix Min**:
    -   Precompute `maxLeft[i]`. `minRight[i]`.
    -   Loop `i`. Check conditions.

## Implementation Details
-   2 passes for prefix/suffix.
-   1 pass for calc.
