# Problem Analysis: Check if One String Swap Can Make Strings Equal

## Problem Description
Two strings `s1`, `s2`. Can make equal by one swap (of 2 chars in `s1`)?
Or 0 swaps.

## Analysis

1.  **Count Diffs**:
    -   If `s1 == s2`, return true.
    -   Find indices where they differ.
    -   If counts of diffs != 2, return false.
    -   If indices are `i`, `j`. Check `s1[i] == s2[j]` and `s1[j] == s2[i]`.

## Implementation Details
-   Loop.
