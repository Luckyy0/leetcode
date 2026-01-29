# Problem Analysis: All Ancestors of a Node in a Directed Acyclic Graph

## Problem Description
DAG. Find ancestors for each node.
Return list of lists, sorted.

## Analysis

1.  **DFS/BFS per Node (Reverse)**:
    -   Reverse graph edges.
    -   For each node `i`, DFS/BFS to find all reachable nodes.
    -   Collect and sort.
    -   `N=1000`. $N^2$ ops fine.

2.  **Topological Sort + Set Merging**:
    -   Topo order.
    -   `Ancestors[u] = Union(Ancestors[v] for v in parents) + {parents}`.
    -   Set operations might be heavy.

3.  **Optimization**:
    -   DFS from every node in *Direct* graph.
    -   When DFS starts at `u`, every node `v` visited has `u` as ancestor.
    -   Add `u` to `result[v]`.
    -   Avoid duplicates via `visited` array per DFS.
    -   This is clean. Iterate `i` from 0 to `n-1`, do DFS, add `i` to all descendants.

## Implementation Details
-   Result `List<List<Integer>>`.
-   Adjacency list.
-   Loop `i`: DFS.
