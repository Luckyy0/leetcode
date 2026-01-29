# Problem Analysis: Rearrange Array Elements by Sign

## Problem Description
Array `nums` even length. Equal positive and negative.
Rearrange: `[pos, neg, pos, neg...]`. Preserve relative order.

## Analysis

1.  **Two Pointers / New Array**:
    -   `res` array.
    -   `posIndex = 0`, `negIndex = 1`.
    -   Iterate `nums`.
    -   If `x > 0`: `res[posIndex] = x`, `posIndex += 2`.
    -   If `x < 0`: `res[negIndex] = x`, `negIndex += 2`.

## Implementation Details
-   Loop and fill.
