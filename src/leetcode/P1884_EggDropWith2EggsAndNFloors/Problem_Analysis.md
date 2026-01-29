# Problem Analysis: Egg Drop With 2 Eggs and N Floors

## Problem Description
2 Eggs. N floors. Limit moves.

## Analysis

1.  **Math**:
    -   With $m$ moves, 2 eggs can cover `m + (m-1) + ... + 1` floors.
    -   Formula: `x * (x+1) / 2 >= n`.
    -   Solve for smallest `x`.
    -   $x^2 + x - 2n >= 0$.
    -   $x \approx \sqrt{2n}$.
    -   Or simply loop `x`. `sum += x`. loops until sum >= n.

## Implementation Details
-   Loop.
