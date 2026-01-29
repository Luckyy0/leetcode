# Problem Analysis: Maximum Value at a Given Index in a Bounded Array

## Problem Description
Construct array `nums` length `n`.
-   `nums[i] >= 1`.
-   `abs(nums[i] - nums[i+1]) <= 1`.
-   Sum `nums` <= `maxSum`.
-   Maximize `nums[index]`.

## Analysis

1.  **Binary Search on Answer**:
    -   Let value at `index` be `v`.
    -   To minimize sum given `nums[index] = v`, neighboring elements should decrease by 1 as we move away from `index` until they hit 1.
    -   Example: `... v-2, v-1, v, v-1, v-2 ...`
    -   Calculate minimal sum for a given `v`.
    -   Left side length `L = index`. Sequence: `v-1, v-2, ..., v-L` (stopping at 1).
    -   Right side length `R = n - 1 - index`. Sequence: `v-1, v-2, ..., v-R`.
    -   Sum of arithmetic progression. Handle cases where sequence reaches 1 and stays 1.
    -   Check if `minSum <= maxSum`.

2.  **Sum Calculation**:
    -   Function `calc(len, maxVal)`: sum of sequence of length `len` ending with `maxVal` (decreasing to left or right).
    -   If `maxVal > len`: Sum is `(maxVal + (maxVal - len + 1)) * len / 2`.
    -   If `maxVal <= len`: Elements go down to 1 (`maxVal * (maxVal + 1) / 2`) and then `len - maxVal` ones (`len - maxVal`).
    -   Total sum = `calc(leftLen, v-1) + calc(rightLen, v-1) + v`.

3.  **Complexity**:
    -   Binary search range `[1, maxSum]`.
    -   Total $O(\log(\text{maxSum}))$.

## Implementation Details
-   `calc` function.
-   Binary search logic.
