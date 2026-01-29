# Problem Analysis: Maximum Split of Positive Even Integers

## Problem Description
Split `finalSum` into distinct positive even integers. Return any.
Impossible if `finalSum` odd.

## Analysis

1.  **Greedy**:
    -   Smallest even numbers maximize count.
    -   Start 2, 4, 6...
    -   Subtract from `sum`.
    -   Stop when `sum < next_even`.
    -   Add remainder to the LAST element to maintain distinctness (and parity).
    -   e.g. 12.
        -   Take 2. Rem 10. `next` 4.
        -   Take 4. Rem 6. `next` 6.
        -   `6 >= 6`. Take 6. Rem 0. (2, 4, 6).
    -   e.g. 28.
        -   2, 4, 6, 8. Sum 20. Rem 8.
        -   Next is 10. `8 < 10`.
        -   Cannot take 10.
        -   Add 8 to last used (8): 8+8=16.
        -   Wait. We need DISTINCT.
        -   If we just add to last used, is it distinct?
        -   Previous: 2, 4, 6. Current Last = 8.
        -   We want to consume remaining 8.
        -   If we add it to last: `8 + 8 = 16`.
        -   List: 2, 4, 6, 16. Distinct? Yes, 16 > 6.
        -   Logic: Keep taking `i = 2, 4...` as long as `sum - i > i`? Or just `sum >= i`.
        -   Actually: `curr = 2`.
        -   While `sum - curr >= curr + 2` (ensure next step possible? No, simply ensure we don't corner ourselves).
        -   Actually simpler: Accept `curr` if `sum - curr` > `curr` (strict greater) OR `sum == curr`.
        -   Wait. If `sum - curr < curr + 2`??
        -   If `sum - curr` is not enough for NEXT distinct even, then we just dump ALL `sum` into the current number (or add to prev).
        -   Wait. Strategy:
            -   Build list `2, 4, 6...`.
            -   Accumulate sum.
            -   At some point `remaining` is small.
            -   Add `remaining` to the LAST element in list.
            -   Since `remaining > 0` and even, the last element becomes larger, still distinct from previous.

## Implementation Details
-   Check odd.
-   Loop.
