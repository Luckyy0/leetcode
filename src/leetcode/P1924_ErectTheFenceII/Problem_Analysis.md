# Problem Analysis: Erect the Fence II

## Problem Description
`trees` (points).
Find Minimum Enclosing Circle (MEC).
Welzl's Algorithm.

## Analysis

1.  **Welzl's Algorithm**:
    -   Recursive algorithm. `welzl(P, R)` finds MEC of points `P` with points `R` on boundary.
    -   Base case: $P$ empty or $|R|=3$. Compute MEC of $R$.
    -   Select random $p$ from $P$.
    -   $D = welzl(P - \{p\}, R)$.
    -   If $p$ inside $D$, return $D$.
    -   Else, $p$ must be on boundary. Return $welzl(P - \{p\}, R \cup \{p\})$.
    -   Expected $O(N)$.

2.  **Implementation**:
    -   Point class.
    -   Circle logic (center, radius).
    -   Circle from 2 points, 3 points.

## Implementation Details
-   Double arithmetic.
