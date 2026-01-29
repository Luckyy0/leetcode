# Problem Analysis: Minimum Changes To Make Alternating Binary String

## Problem Description
String `s` (0s and 1s). Min changes to make it alternating (`0101...` or `1010...`).

## Analysis

1.  **Patterns**:
    -   Pattern 1: starts with '0'. `s[i]` should match `0` if `i` even, `1` if `i` odd.
    -   Pattern 2: starts with '1'.
    -   Calc conflicts for both. Return min.
    -   Actually, conflicts for Pattern 2 = `length - conflicts_Pattern1`. Because flipping everything swaps between patterns.

2.  **Implementation**:
    -   Count diffs for `0101...`. Return `min(diff, n - diff)`.

## Implementation Details
-   Loop.
