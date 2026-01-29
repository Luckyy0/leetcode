# Problem Analysis: Maximum Path Quality of a Graph

## Problem Description
Graph `edges` (u, v, time). `values[i]`.
Start node 0.
Path quality: sum of values of **distinct** nodes visited.
Constraints:
-   Max time `maxTime`.
-   Must return to node 0 at end (last node 0).
-   Nodes can be visited multiple times (only counting value once).
-   `maxTime <= 100`. (Very small).
-   `values.length <= 1000`.
-   `edges` has times >= 10. So max steps <= 10. `time_i >= 10`.
    -   Max depth is 10.
    -   DFS branching factor typical graph.
    -   Recursion with state?
    -   Total nodes visited in path is small (10). But graph is larger.

## Analysis

1.  **Backtracking / DFS**:
    -   Because depth is small (10 steps), we can brute force all valid paths from 0 that return to 0 within `maxTime`.
    -   Each step consumes time.
    -   Keep track of `currTime`, `currValue` (sum of distinct), `visitCounts`.
    -   `visiting` a node: increment visit count. If count becomes 1, add value.
    -   Backtracking: decrement count. If becomes 0, remove value.
    -   Pruning: `currTime > maxTime` -> return.
    -   If `currNode == 0`, update `maxQuality`.
    -   Keep exploring? Yes, might go out and come back again with more value.

## Implementation Details
-   Adjacency List `(node, time)`.
-   `visited` array (int count).
-   Check `node == 0` at every valid step.
