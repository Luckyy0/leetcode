# Problem Analysis: Construct String With Repeat Limit

## Problem Description
String `s`. `repeatLimit`.
Rearrange `s` to be lexicographically largest.
No character repeats more than `repeatLimit` times sequentially.

## Analysis

1.  **Greedy with Frequency Map**:
    -   Count frequencies.
    -   Iterate from largest char `z` down to `a`.
    -   Append current largest char `c` up to `limit` times.
    -   If `count[c]` remains > 0:
        -   We MUST break the streak.
        -   Find next largest char `c2` < `c`.
        -   If found, append ONE `c2`.
        -   Continue appending `c`.
        -   If no `c2` found (only `c` left), we must stop (discard remaining `c`s).

## Implementation Details
-   `counts[26]`.
-   While loop.
-   `limit` logic.
