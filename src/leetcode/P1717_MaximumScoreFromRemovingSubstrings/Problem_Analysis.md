# Problem Analysis: Maximum Score From Removing Substrings

## Problem Description
String `s`. "ab" gives `x`. "ba" gives `y`.
Allowed to remove multiple times. Max score.

## Analysis

1.  **Greedy Stack**:
    -   Prioritize larger value.
    -   If `x > y`: remove "ab" first. Then remove "ba".
    -   If `y > x`: remove "ba" first. Then remove "ab".
    -   Use a stack (or StringBuilder) to perform deletions.
    -   Pass 1: iterate chars. If matches top of stack (high value pair), pop and add score. Else push.
    -   Pass 2: iterate remaining chars from Pass 1. If matches low value pair, pop and add score.

2.  **Complexity**:
    -   Time: $O(N)$.
    -   Space: $O(N)$.

## Implementation Details
-   Function `remove(string, pattern, score)`. Returns remaining string and consumed score.
-   Be careful with reverse order if checking `ba` vs `ab`.
