# Problem Analysis: Check if Binary String Has at Most One Segment of Ones

## Problem Description
Binary string `s` (no leading zeros).
Check if it contains at most one contiguous segment of ones.
(e.g. "110" is true, "101" is false).

## Analysis

1.  **Check for '01'**:
    -   If "01" exists, it means a segment of 1s ended (at '0') and another started (at '1').
    -   Since no leading zeros, it starts with 1.
    -   So "1...0...1" implies > 1 segment.
    -   Check if `s` contains "01". If yes, return false. Else true.

## Implementation Details
-   `contains("01")`.
