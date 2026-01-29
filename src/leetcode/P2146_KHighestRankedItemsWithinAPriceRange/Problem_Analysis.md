# Problem Analysis: K Highest Ranked Items Within a Price Range

## Problem Description
Grid `grid` (prices). Start `start`. `pricing` [low, high]. `k`.
Rank items:
1.  Distance (BFS) ASC.
2.  Price ASC.
3.  Row ASC.
4.  Col ASC.
Return top `k`.
Walls: 0.

## Analysis

1.  **BFS + Sorting**:
    -   BFS from `start` to find distances.
    -   Collect valid items ($price \in [low, high]$).
    -   Store `(dist, price, r, c)`.
    -   Sort or maintain PQ.
    -   Return top k.

## Implementation Details
-   `PriorityQueue` or `List` then sort.
-   Queue for BFS.
-   Visited array.
-   Stop BFS? No, explore all reachable.
-   Optimization: If list size exceeds k, maintain heap? Or just collect all then sort (if grid is up to `10^5`?). Grid is `m*n`. Sorting `10^5` is fine.
