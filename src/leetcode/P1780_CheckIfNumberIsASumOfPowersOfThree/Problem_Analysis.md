# Problem Analysis: Check if Number is a Sum of Powers of Three

## Problem Description
Check if `n` is sum of distinct powers of 3.
Equivalent to: `n` in base 3 has only digits 0 or 1. If any digit is 2, means we need 2 of the same power, not allowed (distinct).

## Analysis

1.  **Base 3 Check**:
    -   While `n > 0`:
        -   `rem = n % 3`.
        -   If `rem == 2`, return False.
        -   `n /= 3`.
    -   Return True.

## Implementation Details
-   Loop.
