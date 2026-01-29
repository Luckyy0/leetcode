# Problem Analysis: Reverse Prefix of Word

## Problem Description
String `word`, char `ch`.
Find first occurrence of `ch`. Reverse segment from 0 to that index.

## Analysis

1.  **IndexOf + StringBuilder**:
    -   `idx = word.indexOf(ch)`.
    -   If -1, return word.
    -   Part1: `word.substring(0, idx+1)` reversed.
    -   Part2: `word.substring(idx+1)`.
    -   Combine.

## Implementation Details
-   `StringBuilder`.
