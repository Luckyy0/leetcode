# Problem Analysis: Minimum Cost Homecoming of a Robot in a Grid

## Problem Description
Start `(startRow, startCol)`, Home `(homeRow, homeCol)`.
Cost to enter `row[r]` is `rowCosts[r]`.
Cost to enter `col[c]` is `colCosts[c]`.
Min cost to reach home.

## Analysis

1.  **Manhattan Logic**:
    -   Moving away from target generally hurts or achieves nothing better (costs are non-negative?).
    -   Costs are associated with *entering* a row/col.
    -   To go from `r1` to `r2`, we must enter every row between `r1` and `r2` (exclusive of start, inclusive of end).
    -   Same for columns.
    -   Since indices are grid-aligned, the set of rows/cols we *must* cross is fixed `min(r1, r2) .. max(r1, r2)`.
    -   Any detour adds extra row/col entries.
    -   If costs are non-negative, direct path is optimal.
    -   Direct path cost is sum of rowCosts for rows in `range(r1 -> r2)` and colCosts in `range(c1 -> c2)`.
    -   Direction depends on `start < home` or `start > home`.

## Implementation Details
-   Sum range.
