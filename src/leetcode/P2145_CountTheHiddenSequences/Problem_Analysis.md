# Problem Analysis: Count the Hidden Sequences

## Problem Description
Array `differences` of length `n`.
Hidden sequence `hidden` length `n+1`.
`differences[i] = hidden[i+1] - hidden[i]`.
Condition: `lower <= hidden[i] <= upper` for all `i`.
Count possible hidden sequences.

## Analysis

1.  **Prefix Sum of Diffs**:
    -   Let `hidden[0] = x`.
    -   `hidden[1] = x + diff[0]`.
    -   `hidden[i] = x + prefix_diff[i-1]`.
    -   Values are `x, x+d0, x+d0+d1, ...`.
    -   Let `min_val` be min of `0, d0, d0+d1...`.
    -   Let `max_val` be max of `0, d0, d0+d1...`.
    -   Abs value sequence range is `[x + min_val, x + max_val]`.
    -   Constraint: `lower <= x + min_val` and `x + max_val <= upper`.
    -   So `x >= lower - min_val` and `x <= upper - max_val`.
    -   Count `x`: `max_x - min_x + 1`.
    -   If `max_x < min_x`, 0.

## Implementation Details
-   `long` valid.
-   Track min/max of cumulative diff.
