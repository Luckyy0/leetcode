# Problem Analysis: Valid Arrangement of Pairs

## Problem Description
`pairs` `[start, end]`.
Arrange them so `end_i == start_{i+1}`.
Visit every pair exactly once. (Eulerian Path).
Return arranged pairs.

## Analysis

1.  **Eulerian Path**:
    -   Direct Graph. Edges from pairs.
    -   Find Eulerian Path covering all edges.
    -   Conditions:
        -   Connected (ignoring direction).
        -   InDegree == OutDegree for all nodes, except possibly:
            -   Start: Out = In + 1.
            -   End: In = Out + 1.
    -   Algorithm: Hierholzer's or simple DFS (Post-order traversal).
    -   Build graph. Track degrees.
    -   Identify start node.
    -   DFS. Reverse result path.

## Implementation Details
-   `Map<Integer, Deque<Integer>> adj`. Multi-edges possible? "pairs". Yes.
-   `Map<Integer, Integer> in`, `out`.
