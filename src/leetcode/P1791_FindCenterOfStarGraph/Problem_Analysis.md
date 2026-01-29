# Problem Analysis: Find Center of Star Graph

## Problem Description
Edges of a Star Graph. Center connected to all other nodes.
Find center.

## Analysis

1.  **Common Node**:
    -   In a star graph, the center node is part of *every* edge.
    -   Just check the first two edges. The common node between `edge[0]` and `edge[1]` is the center.

## Implementation Details
-   Compare `e1[0], e1[1]` with `e2[0], e2[1]`.
