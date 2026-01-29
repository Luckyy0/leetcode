# Problem Analysis: Count Nice Pairs in an Array

## Problem Description
Count pairs `(i, j)` with `i < j` such that `nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])`.

## Analysis

1.  **Equation Transformation**:
    -   `nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])`.
    -   Let `f(x) = x - rev(x)`.
    -   We need `f(nums[i]) == f(nums[j])`.

2.  **Algorithm**:
    -   Compute `f(x)` for all numbers.
    -   Use a Frequency Map to count occurrences of each value.
    -   If a value appears `k` times, it contributes `k * (k - 1) / 2` pairs.
    -   Result modulo `10^9 + 7`.

## Implementation Details
-   `rev` function.
-   `HashMap`.
