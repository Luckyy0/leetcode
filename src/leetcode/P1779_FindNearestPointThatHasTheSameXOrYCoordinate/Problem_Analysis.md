# Problem Analysis: Find Nearest Point That Has the Same X or Y Coordinate

## Problem Description
Given `(x, y)` and `points`.
Valid point: `px == x` or `py == y`.
Nearest Manhattan distance. Tie breaker: smallest index.

## Analysis

1.  **Iterate**:
    -   Check validity.
    -   Calc distance `abs(x - px) + abs(y - py)`.
    -   Update min.

## Implementation Details
-   Loop.
