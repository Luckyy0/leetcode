# Problem Analysis: Queries on Number of Points Inside a Circle

## Problem Description
Points `points`. Queries `queries` (x, y, r).
Count points inside each circle.
Constraint `n <= 500`. `queries <= 500`. Total $2.5 \cdot 10^5$.

## Analysis

1.  **Brute Force**:
    -   Iterate queries. For each, iterate all points.
    -   Check distance squared `<= r*r`.
    -   Complexity: $500 \times 500 = 250,000$. Very fast.

2.  **Optimization** (Not needed):
    -   KD-tree or Quadtree for larger inputs. Here unnecessary.

## Implementation Details
-   Nested loops.
