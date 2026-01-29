# Problem Analysis: Remove Stones to Minimize the Total

## Problem Description
Array `piles`. `k` moves.
Move: Choose a pile `p[i]`. Remove `floor(p[i] / 2)`. New value `ceil(p[i] / 2)`.
Minimize total stones after k moves.

## Analysis

1.  **Greedy (Priority Queue)**:
    -   Always pick the largest pile to reduce the most amount (`floor(x/2)` is larger for larger `x`).
    -   Use MaxHeap.
    -   K times: Pop max, reduce, push back.
    -   Sum remaining.

## Implementation Details
-   `PriorityQueue<Integer>`.
