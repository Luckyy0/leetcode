# Problem Analysis: Longer Contiguous Segments of Ones than Zeros

## Problem Description
Binary string `s`.
Return true if longest segment of 1s is strictly longer than longest segment of 0s.

## Analysis

1.  **Linear Scan**:
    -   Track `maxOne`, `currentOne`, `maxZero`, `currentZero`.
    -   Loop char. If '1', inc `currentOne`, reset `currentZero`. Update `maxOne`.
    -   Else, inc `currentZero`, reset `currentOne`. Update `maxZero`.

## Implementation Details
-   Loop.
