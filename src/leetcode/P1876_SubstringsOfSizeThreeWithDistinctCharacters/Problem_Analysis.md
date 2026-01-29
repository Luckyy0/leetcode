# Problem Analysis: Substrings of Size Three with Distinct Characters

## Problem Description
String `s`.
Count "good" substrings of length 3 (no repeated chars).

## Analysis

1.  **Sliding Window**:
    -   Iterate `i` from 0 to `n-3`.
    -   Check `s[i], s[i+1], s[i+2]` distinct.
    -   `a!=b && a!=c && b!=c`.

## Implementation Details
-   Loop.
