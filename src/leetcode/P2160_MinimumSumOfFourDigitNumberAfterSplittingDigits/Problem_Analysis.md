# Problem Analysis: Minimum Sum of Four Digit Number After Splitting Digits

## Problem Description
`num` (4 digits). Split digits into `new1`, `new2`.
Minimize sum.

## Analysis

1.  **Greedy**:
    -   To minimize sum, place smallest digits in most significant positions (tens place).
    -   Digits sorted: `d1, d2, d3, d4` (asc).
    -   Optimal: `d1 * 10 + d3` + `d2 * 10 + d4`.
    -   Equals `10(d1 + d2) + d3 + d4`.
    -   Example: 2932 -> 2, 2, 3, 9. 22 + 93 is bad. 23 + 29 = 52. 29 + 23.
    -   Logic:
        -   Most significant: `d1` and `d2`.
        -   Least significant: `d3` and `d4`.
        -   Pairs: `(d1, d3)` and `(d2, d4)`. Or `(d1, d4)` and `(d2, d3)`.
        -   Sum is `10*d1 + d_x + 10*d2 + d_y`.
        -   This equals `10(d1+d2) + d3+d4`.
        -   The pairing of last digits doesn't change sum.

## Implementation Details
-   Extract digits. Sort. Calculate.
