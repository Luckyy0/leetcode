# Problem Analysis: Count Integers With Even Digit Sum

## Problem Description
Count integers `x` in `[1, num]` s.t. sum of digits of `x` is even.

## Analysis

1.  **Pattern**:
    -   Every 10 numbers (e.g. 10..19), digit sums alternate parity. 5 even, 5 odd.
    -   So roughly `num / 2`.
    -   Check the boundary `num`.
    -   If digit sum of `num` is even, result is `num / 2`.
    -   Actually logic:
        -   If `digitSum(num)` even: count is `num / 2`?
        -   Let's check `num=4`. 1(odd), 2(even), 3(odd), 4(even). Count 2. `4/2 = 2`.
        -   `num=3`. 1(odd), 2(even), 3(odd). Count 1. `3/2 = 1`.
        -   `num=5`. 5(odd). Count 2. `5/2 = 2`.
        -   Check logic.
        -   Wait. Standard distribution:
            -   For `k` tens: `k * 5` evens.
            -   For remainder: check individually?
    -   Or simply: Iterate 1 to `num` and count. `num <= 1000`. Fast.

## Implementation Details
-   Loop.
