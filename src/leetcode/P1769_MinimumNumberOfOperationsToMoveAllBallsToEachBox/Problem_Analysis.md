# Problem Analysis: Minimum Number of Operations to Move All Balls to Each Box

## Problem Description
String `boxes` ('0' or '1').
For each index `i`, min operations (moves) to bring all balls to `i`.
Ops = distance.

## Analysis

1.  **Brute Force**:
    -   $O(N^2)$.
    
2.  **Optimized (Prefix/Suffix)**:
    -   Left to right: `ops` accumulates `count` of balls seen so far.
    -   `ans[i] += ops`.
    -   Right to left: same.
    -   Time: $O(N)$. Space $O(N)$.

## Implementation Details
-   Loop forward, loop backward.
