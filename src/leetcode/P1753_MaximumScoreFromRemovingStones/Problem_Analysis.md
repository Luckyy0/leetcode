# Problem Analysis: Maximum Score From Removing Stones

## Problem Description
Piles `a, b, c`.
Take two stones from two different piles. +1 score.
Max score.

## Analysis

1.  **Greedy**:
    -   Always pick from biggest two piles to balance them.
    -   Let sorted piles `x <= y <= z`.
    -   If `x + y <= z`: we can exhaust `x` and `y` completely by pairing with `z`. Score `x + y`.
    -   If `x + y > z`: we can eventually reduce piles to be nearly equal. Total stones `S = x+y+z`. Score `S / 2`.
    -   Because we remove 2 stones per turn, max turns is `floor(Sum/2)`. Is it always achievable? Yes unless one pile dominates (case 1).

2.  **Implementation**:
    -   Sort. Check condition.

## Implementation Details
-   Math logic.
