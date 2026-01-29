# Problem Analysis: Partitioning Into Minimum Number Of Deci-Binary Numbers

## Problem Description
A deci-binary number consists only of digits 0 and 1.
Given string `n` (representing a positive integer), return min number of deci-binary numbers needed to sum to `n`.

## Analysis

1.  **Digit Logic**:
    -   Consider the largest digit in `n`, say `maxD`.
    -   To form that digit `maxD`, we need at least `maxD` ones at that position (since each deci-binary contributes 0 or 1).
    -   We can form `n` using exactly `maxD` deci-binaries.
    -   Example: `32`. Need 3. `11 + 11 + 10 = 32`.
    -   We just fill the layers.
    -   Result is `max(digit)` in `n`.

## Implementation Details
-   Scan string, find max char.
