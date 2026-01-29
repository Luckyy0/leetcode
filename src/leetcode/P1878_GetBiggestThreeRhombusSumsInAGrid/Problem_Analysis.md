# Problem Analysis: Get Biggest Three Rhombus Sums in a Grid

## Problem Description
`grid` `m x n`.
Rhombus sum: sum of cells on border.
Return biggest 3 distinct sums descending.

## Analysis

1.  **Brute Force Simulation**:
    -   Constraints `50x50`. Small.
    -   Iterate `center` (r, c).
    -   Iterate `radius` (k).
    -   Calculate perimeter sum.
    -   Store in `TreeSet`.
    -   If set size > 3, remove smallest.
    -   Edges for `k=0`: single cell.
    -   Edges for `k > 0`: 4 diagonal segments.
    -   Top: `(r-k, c)`
    -   Right: `(r, c+k)`
    -   Bottom: `(r+k, c)`
    -   Left: `(r, c-k)`
    -   Check bounds: `r-k >= 0`, `r+k < m`, `c-k >= 0`, `c+k < n`.

## Implementation Details
-   `TreeSet<Integer>`. Descending output.
-   Be careful with overlapping start/end points of perimeter.
-   Corner points: top, right, bottom, left.
-   Edges connect adjacent corners.
