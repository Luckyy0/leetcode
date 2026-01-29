# Problem Analysis: Maximum Product Difference Between Two Pairs

## Problem Description
Array `nums`.
Maximize `(a * b) - (c * d)`.

## Analysis

1.  **Selection**:
    -   To maximize the difference, we want `a * b` large and `c * d` small.
    -   Large: Pick two largest elements.
    -   Small: Pick two smallest elements.
    -   Sort array. `len = n`.
    -   `nums[n-1] * nums[n-2]` vs `nums[0] * nums[1]`.

## Implementation Details
-   Sort or linear scan.
