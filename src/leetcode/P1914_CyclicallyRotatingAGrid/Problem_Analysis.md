# Problem Analysis: Cyclically Rotating a Grid

## Problem Description
`m x n` grid. Layers.
Rotate each layer `k` times counter-clockwise.

## Analysis

1.  **Layer extraction**:
    -   Iterate `l` (layer index) from `0` to `min(m, n)/2 - 1`.
    -   Extract boundary elements for layer `l` into a list. Order: Top, Right, Bottom, Left.
    -   List size `S = 2 * (rows + cols - 2)`.
    -   Rotate logic: `k %= S`. New start index.
    -   Put elements back into grid.

## Implementation Details
-   Loop `l`.
-   Coordinate logic.
