# Problem Analysis: Maximum Number of Balls in a Box

## Problem Description
Balls `lowLimit` to `highLimit`.
Box number for ball `i` is sum of digits of `i`.
Count balls in each box. Return max balls in any box.

## Analysis

1.  **Iteration**:
    -   Max number `10^5`. Max sum of digits for 99999 is 45.
    -   Array `counts` size ~50.
    -   Loop `i` from `low` to `high`.
    -   Calc `sumDigits(i)`. Increment count.
    -   Track max.

2.  **Complexity**:
    -   Time: $O(N \log (\text{num}))$.
    -   Space: $O(1)$.

## Implementation Details
-   Helper `sumDigits`.
