# Problem Analysis: Maximum Nesting Depth of the Parentheses

## Problem Description
A string is a valid parentheses string (VPS) if it meets standard conditions.
The nesting depth is the maximum number of nested parentheses.
Given a VPS `s`, return the nesting depth.

## Analysis

1.  **Algorithm**:
    -   Iterate character by character.
    -   Maintain `currentDepth`.
    -   Maintain `maxDepth`.
    -   If `c == '('`: `currentDepth++`. Update `maxDepth`.
    -   If `c == ')'`: `currentDepth--`.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(1)$.

## Implementation Details
-   Simple loop.
