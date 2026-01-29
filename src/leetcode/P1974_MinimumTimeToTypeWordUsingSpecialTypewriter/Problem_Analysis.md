# Problem Analysis: Minimum Time to Type Word Using Special Typewriter

## Problem Description
Circular typewriter 'a'-'z'. Pointer at 'a'.
Move clockwise or counter-clockwise.
Each move 1 sec. Type 1 sec.
Min time to type string.

## Analysis

1.  **Greedy Distance**:
    -   Curr char `start`. Target `c`.
    -   Dist = `abs(start - c)`.
    -   Wrap distance = `26 - dist`.
    -   Min move = `min(dist, 26 - dist)`.
    -   Add 1 (type).
    -   Update `start = c`.

## Implementation Details
-   Loop.
