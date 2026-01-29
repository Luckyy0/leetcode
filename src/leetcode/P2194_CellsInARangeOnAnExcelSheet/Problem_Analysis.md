# Problem Analysis: Cells in a Range on an Excel Sheet

## Problem Description
Format `C1:F4`.
Return all cells. `C1, C2...`

## Analysis

1.  **Parsing**:
    -   Split by `:`.
    -   `startCol` char, `startRow` int.
    -   `endCol` char, `endRow` int.
    -   Nested loop Cols then Row.

## Implementation Details
-   `String` parsing.
-   Loop `c` from `startCol` to `endCol`.
-   Loop `r` from `startRow` to `endRow`.
