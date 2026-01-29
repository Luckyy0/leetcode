# Problem Analysis: Replace All Digits with Characters

## Problem Description
String `s`. Odd indices are digits. Even are letters.
Replace digit `s[i]` with `shift(s[i-1], digit)`.
`shift(c, x)` returns `c + x` (char arithmetic).

## Analysis

1.  **Simulation**:
    -   Convert string to char array.
    -   Iterate `i` from 1 with step 2.
    -   `arr[i] = (char)(arr[i-1] + arr[i] - '0')`.
    -   Return string.

## Implementation Details
-   Loop.
