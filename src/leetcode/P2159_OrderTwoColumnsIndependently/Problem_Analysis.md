# Problem Analysis: Order Two Columns Independently

## Problem Description
Table `Data` (first_col, second_col).
Output ordered columns independently.

## Analysis

1.  **Window Functions**:
    -   Assign row numbers to each column independently.
    -   Join on row number.

## Implementation Details
-   `ROW_NUMBER()`.
