# Problem Analysis: Minimum Number of Vertices to Reach All Nodes

## Problem Description
Given a **directed acyclic graph**, with `n` vertices numbered from `0` to `n-1`, and an array `edges` where `edges[i] = [fromi, toi]` represents a directed edge from node `fromi` to node `toi`.

Find the **smallest set of vertices** from which all nodes in the graph are reachable. It's guaranteed that a unique solution exists.

## Analysis

1.  **Key Insight**:
    -   In a DAG, if a node has an incoming edge (in-degree > 0), it is reachable from some other node (its parent).
    -   If a node has `in-degree == 0`, it cannot be reached from any other node. Therefore, it **must** be included in the solution set.
    -   Since the graph is acyclic, starting from the nodes with `in-degree == 0` covers all nodes. Any node with `in-degree > 0` is reachable from some ancestor, and tracing back the ancestry chain in a DAG eventually leads to a source node (node with `in-degree == 0`).
    
2.  **Algorithm**:
    -   Create an array `inDegree` of size `n`.
    -   Iterate through `edges`. For each edge `[u, v]`, increment `inDegree[v]`.
    -   Collect all nodes `i` where `inDegree[i] == 0`.

3.  **Complexity**:
    -   Time: $O(V + E)$ to iterate edges and nodes.
    -   Space: $O(V)$ to store in-degrees.

## Implementation Details
-   Use an integer array or boolean array `hasParent` to track incoming edges.
