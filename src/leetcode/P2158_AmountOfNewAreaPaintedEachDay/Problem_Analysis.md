# Problem Analysis: Amount of New Area Painted Each Day

## Problem Description
`paint[i] = [start, end]`.
Paint ranges sequentially.
Return array of new length painted each day.

## Analysis

1.  **Segment Tree**:
    -   Range `[0, 100000]`. Usually $5 \cdot 10^4$ from constraints. Max coordinate is $50000$.
    -   We need `Range Update` (set to 1) and `Range Sum` (count 1s).
    -   For each operation `[start, end)`:
        -   Query existing sum in range. `paintedBefore`.
        -   Update range to 1.
        -   New region length = `(end - start) - paintedBefore`.
    -   We simply need a SegTree that supports "Set range to 1" and "Query Sum".
    -   Wait. Standard query returns sum of 1s. If we set to 1, all become 1.
    -   Length of range `end - start`.
    -   Painted before: query sum.
    -   Result: `len - sum`.
    -   Update: `update(start, end - 1, 1)`. Range is inclusive for SegTree, usually. `paint` is `[start, end)`. So indices `start` to `end-1`.

2.  **Implementation**:
    -   Array based SegTree `tree[]` and `lazy[]`.
    -   Size $4 \times 50000 = 200000$.
    -   `update(node, l, r, ql, qr)`:
        -   If completely in range, set sum to `r-l+1`. Mark lazy.
        -   Lazy push: if node is set, set children to full sum.

## Implementation Details
-   Segment Tree class.
-   Coordinates up to 50000.
