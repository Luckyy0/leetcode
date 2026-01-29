# Problem Analysis: Adding Spaces to a String

## Problem Description
String `s`. Indices `spaces`.
Insert spaces at given indices (relative to original string).
Indices are sorted.

## Analysis

1.  **StringBuilder construction**:
    -   Indices represent positions in *original* string BEFORE which space is inserted.
    -   (Or index in new string? Usually index in original).
    -   "Insert spaces... at indices... space inserted BEFORE char at index".
    -   Iterate `s`. Keep pointer `p` to `spaces`.
    -   If `current_index == spaces[p]`, append ' ', increment `p`.
    -   Append `s[current_index]`.

## Implementation Details
-   `StringBuilder`.
