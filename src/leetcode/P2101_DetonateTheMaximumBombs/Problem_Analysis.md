# Problem Analysis: Detonate the Maximum Bombs

## Problem Description
Bombs `[x, y, r]`.
If bomb i detonates, it triggers bomb j if distance `dist(i, j) <= r_i`.
Chain reaction.
Find max number of bombs detonated if we choose ONE bomb to detonate.

## Analysis

1.  **Graph - Reachability**:
    -   Directed edge `i -> j` if `i` can detonate `j`.
    -   Condition: `(x_i - x_j)^2 + (y_i - y_j)^2 <= r_i^2`.
    -   Note: Directed. `i` might detonate `j`, but `j` might not reach `i`.
    -   Find connected component size? No, it's directed. Reachability.
    -   For each node `start`, run BFS/DFS to count reachable nodes.
    -   Max count.
    -   Complexity: $O(N^3)$ or $O(N^2 + N \cdot E)$. Since $N \le 100$. $N^3$ is $10^6$. Very fast.

## Implementation Details
-   Build adjacency list.
-   Loop `i` from 0 to N-1. DFS.
