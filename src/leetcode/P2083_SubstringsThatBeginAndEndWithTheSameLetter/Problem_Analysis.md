# Problem Analysis: Substrings That Begin and End With the Same Letter

## Problem Description
String `s`. Count substrings `s[i...j]` where `s[i] == s[j]`.

## Analysis

1.  **Counting by Character**:
    -   If a char 'a' appears `k` times.
    -   Any pair of indices `(occ_x, occ_y)` with `x <= y` forms a valid substring.
    -   Or just single indices (length 1).
    -   Number of pairs is `k * (k + 1) / 2`.
    -   Sum this for all 26 chars.

## Implementation Details
-   `freq` array.
-   Sum formula.
