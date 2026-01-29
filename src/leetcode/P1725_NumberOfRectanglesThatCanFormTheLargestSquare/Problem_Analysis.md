# Problem Analysis: Number Of Rectangles That Can Form The Largest Square

## Problem Description
`rectangles[i] = [l, w]`.
Cut to square side `k = min(l, w)`.
Max `k` possible? Count how many rects can form `max k`.

## Analysis

1.  **Iterate**:
    -   Calc `k` for each.
    -   Track `maxK`.
    -   If `k > maxK`, reset count to 1, update `maxK`.
    -   If `k == maxK`, increment count.

## Implementation Details
-   Loop.
