# Problem Analysis: Sign of the Product of an Array

## Problem Description
Product sign: 1 (positive), -1 (negative), 0 (zero).

## Analysis

1.  **Count Negatives**:
    -   Iterate array.
    -   If `num == 0`, partial product 0 -> return 0.
    -   If `num < 0`, count negatives.
    -   If count odd -> -1, else 1.

## Implementation Details
-   Loop.
