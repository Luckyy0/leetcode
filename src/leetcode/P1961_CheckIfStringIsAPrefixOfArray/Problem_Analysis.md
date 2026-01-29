# Problem Analysis: Check If String Is a Prefix of Array

## Problem Description
String `s`, string array `words`.
Check if `s` can be formed by concatenating the first `k` strings in `words` for some `k`.

## Analysis

1.  **Iterative Concatenation**:
    -   Keep concatenating `words[i]` to a buffer.
    -   Check if buffer equals `s`.
    -   If buffer length exceeds `s.length()`, failed.
    -   Return true if equal.

## Implementation Details
-   StringBuilder.
-   Optimization: Compare during iteration without full build? Yes.
-   Maintain index in `s`.
