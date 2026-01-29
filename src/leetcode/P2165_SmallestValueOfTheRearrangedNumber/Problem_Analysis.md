# Problem Analysis: Smallest Value of the Rearranged Number

## Problem Description
Rearrange digits of `num` to get min value.
Sign preserved.
If `num > 0`: non-decreasing digits, but no leading zero.
If `num < 0`: max absolute value (non-increasing digits).
If `num == 0`: 0.

## Analysis

1.  **Sorting**:
    -   Digits.
    -   Positive: Sort asc. Swap first consecutive zeros with first non-zero.
    -   Negative: Sort desc.

## Implementation Details
-   `String.valueOf(abs(num))`.
-   Array sort.
-   Swap logic for zeros.
