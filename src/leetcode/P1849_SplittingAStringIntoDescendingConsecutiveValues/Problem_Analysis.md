# Problem Analysis: Splitting a String Into Descending Consecutive Values

## Problem Description
String `s`. Split into 2 or more substrings.
Values must be decreasing by 1: `val[i] = val[i-1] - 1`.

## Analysis

1.  **Backtracking**:
    -   Parse first number `startVal` taking substring `s[0...i]`.
    -   Recursively check if rest of string can form sequence `startVal-1, startVal-2...`.
    -   Important: Handle large numbers (use `long` or `BigInteger`? Constraint `s.length <= 20`, usually `long` suffices. `unsigned long long` fits 20 chars).
    -   Constraint says `s` consists of digits. Length 20. Max roughly $10^{19}$ fits in `unsigned long` usually, but Java `long` is signed. `Long.MAX_VALUE` is $9 \cdot 10^{18}$. String can span 20 digits, possibly overflowing.
    -   However, if we split into at least *two* parts, the largest first part is at most length 19 (if s len 20).
    -   If length is small (< 19), fits in Long.
    -   If length matches max long len, parse carefully.
    -   Or just use `BigInteger` if needed? Or custom check.
    -   Actually `s.length <= 20`.
    -   If we split into at least 2 parts, max length of a part is 19. fits in Long.
    -   Corner case: leading zeros can be trimmed but value matters. `005` is 5.

2.  **Algorithm**:
    -   Loop length `L` for first number.
    -   `val = parse(s[0...L])`.
    -   Call `isValid(suffix, val - 1)`.

## Implementation Details
-   `dfs`.
