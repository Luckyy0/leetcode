# Problem Analysis: Widest Vertical Area Between Two Points Containing No Points

## Problem Description
Given `n` points on a 2D plane where `points[i] = [xi, yi]`, return the widest vertical area between two points such that no points are inside the area.
The vertical area is defined by two vertical lines. The width of the vertical area is the distance between the lines.
Points on the edge (lines) are allowed.

## Analysis

1.  **Concept**:
    -   Vertical area width is determined solely by X coordinates. Y coordinates are irrelevant.
    -   Since no points can be *inside* the area, the widest area corresponds to the maximum gap between adjacent sorted X-coordinates.
    -   If there are points at $x_1, x_2, \dots, x_k$ (sorted distinct), max width is $\max(x_{i+1} - x_i)$.
    
2.  **Algorithm**:
    -   Extract X coordinates.
    -   Sort them.
    -   Iterate and finding max difference.

3.  **Complexity**:
    -   Time: $O(N \log N)$ (Sorting).
    -   Space: $O(N)$ (Or O(1) if sorting in-place/extraction).

## Implementation Details
-   `Arrays.sort(points, (a, b) -> a[0] - b[0])`.
