# Problem Analysis: Check if All A's Appears Before All B's

## Problem Description
String `s` ('a', 'b').
True if every 'a' appears before every 'b'.
Equivalent: No 'b' appears before an 'a'. Or `s` is sorted.

## Analysis

1.  **Check Order**:
    -   Or check if `lastIndex('a') < firstIndex('b')`.
    -   Or loop: if seen 'b' and then see 'a', return false.

## Implementation Details
-   Loop.
