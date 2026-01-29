# Problem Analysis: Remove All Ones With Row and Column Flips

## Problem Description
Grid `grid`. Op: Flip row or Flip col (0->1, 1->0).
Return true if can make all grid 0.

## Analysis

1.  **Pattern Matching**:
    -   To clear the grid, every row must eventually become all 0s.
    -   Fix the first row. We can either:
        1.  Do nothing to row 0. Then for every column `j` where `grid[0][j] == 1`, we MUST flip column `j`.
        2.  Flip row 0. Then for every column `j` where `grid[0][j]` (after flip) is 1, we MUST flip column `j`.
    -   Basically, the column flips are DETERMINED by the first row's requirement to be 0.
    -   Once column flips are fixed, check other rows.
    -   For row `i`: Applying the column flips must make it either `000...` or `111...`.
        -   If `000...`, done.
        -   If `111...`, we flip row `i` to make it `000...`. done.
        -   If `010...` (mixed), impossible.
    -   Equivalent condition: Every row must be equal to Row 0 OR equal to Inverse(Row 0).

## Implementation Details
-   Extract Row 0.
-   Loop rows 1..n. Check matches.
