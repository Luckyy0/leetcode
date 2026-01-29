# Problem Analysis: Find Three Consecutive Integers That Sum to a Given Number

## Problem Description
Given `num`. Find 3 consecutive ints `x, x+1, x+2` s.t. sum = `num`.
Return `[x, x+1, x+2]` or empty.

## Analysis

1.  **Math**:
    -   Sum = `3x + 3`.
    -   `num - 3` must be divisible by 3.
    -   Or simply `num % 3 == 0`.
    -   Middle number is `num / 3`.
    -   Array is `[mid-1, mid, mid+1]`.

## Implementation Details
-   Check modulo.
