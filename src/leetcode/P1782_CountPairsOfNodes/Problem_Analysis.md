# Problem Analysis: Count Pairs Of Nodes

## Problem Description
Undirected graph `n` nodes, `edges`. `queries[i]` is integer.
Count pairs `(a, b)` such that `incident(a) + incident(b) - incident(edge(a,b)) > queries[i]`.
(Overlap edge counts once).

## Analysis

1.  **Degree Correction**:
    -   Let `deg[u]` be degree of node `u`.
    -   Incidents for pair `(u, v)` is `deg[u] + deg[v] - (1 if edge u-v exists else 0)`.
    -   For each query `q`, we want pairs `(u, v)` ($u<v$) where `deg[u] + deg[v] > q`? No, minus overlap.
    -   Optimization:
        -   First count pairs `(u, v)` where `deg[u] + deg[v] > q`.
        -   This can be done using sorted degrees and two pointers.
        -   However, some of these pairs might have `deg[u] + deg[v] > q` but `deg[u] + deg[v] - 1 <= q`. (Because edge exists).
        -   We only overcounted the pairs connected by an edge where `deg[u] + deg[v] > q` but `deg[u] + deg[v] - 1 <= q`.
        -   So, initially calculate count ignoring edges (using sorted degree array).
        -   Then iterate over all edges `(u, v)`. Check if this specific edge violates condition after adjustment.
        -   If `deg[u] + deg[v] > q` (counted) AND `deg[u] + deg[v] - 1 <= q` (should not be counted), subtract 1.
        -   Basically: `count` = (pairs with sum > q) - (connected pairs with sum > q AND sum - 1 <= q).
    
2.  **Algorithm**:
    -   Compute degrees.
    -   Store sorted degrees in array `sortedDeg`.
    -   For each query `q`:
        -   Use two pointers on `sortedDeg` to find count of pairs with `sortedDeg[i] + sortedDeg[j] > q`.
        -   Then iterate original `edges`. Let `u, v` be endpoints.
        -   `sum = deg[u] + deg[v]`.
        -   If `sum > q` AND `sum - 1 <= q`, decrement result.
    
3.  **Complexity**:
    -   Time: $O(Q \cdot (N + E) + N \log N)$.
    -   Constraints: $N, E, Q \le 10^5$ ? Actually usually limits around $2 \cdot 10^4$ or $10^5$.
    -   Wait, sorting degrees takes $N \log N$. Two pointers $N$. Loop edges $E$. Total per query $N+E$.
    -   If $Q$ is large, $Q(N+E)$ might be slow.
    -   Optimization: Process queries?
    -   Or since constraint `2*10^4` for N and Q, $2 \cdot 10^4 \times 2 \cdot 10^4 = 4 \cdot 10^8$. A bit heavy if $Q$ large.
    -   Actually checking constraints: $N \le 2 \cdot 10^4$, Edges $10^5$. Queries $20$.
    -   Ah, queries is small! Then $Q(N+E)$ is fine.

## Implementation Details
-   Map for edges (to handle duplicates if multigraph? No, simple graph usually).
-   "Multiple edges can connect the same pair of nodes"? Problem says "edges[i] = [ui, vi]". Could be multigraph. Then overlap is `count(edges between u, v)`.
-   Logic: `deg[u] + deg[v] - shared[u][v] > q`.
-   Two pointers gives `cnt` where `deg[u] + deg[v] > q`.
-   Iterate map of adjacent pairs `(u, v)` with `shared` count.
-   If `deg[u] + deg[v] > q` but `deg[u] + deg[v] - shared <= q`, decrement.

## Clarification on Shared Edges
-   If multigraph: shared is number of edges between u and v.
-   Correction loop: iterate `(u, v, shared)` in map.
