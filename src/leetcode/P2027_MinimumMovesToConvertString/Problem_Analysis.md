# Problem Analysis: Minimum Moves to Convert String

## Problem Description
String `s` ('X', 'O').
Move: Select 3 consecutive chars and convert to 'O'.
Min moves to make all 'O'.

## Analysis

1.  **Greedy**:
    -   Iterate char `i`.
    -   If `s[i] == 'X'`:
        -   We MUST change it.
        -   Best move is to cover `i, i+1, i+2`.
        -   Why? Covering `i-1` is useless (already 'O').
        -   So convert `i, i+1, i+2` to 'O'. (Advance `i` by 3).
        -   Increment moves.
    -   If `s[i] == 'O'`, `i++`.

## Implementation Details
-   Loop.
