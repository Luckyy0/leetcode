# Problem Analysis: Path With Minimum Effort

## Problem Description
You are a hiker preparing for an upcoming hike. You are given `heights`, a 2D array of size `rows x columns`, where `heights[row][col]` represents the height of cell `(row, col)`. You are situated in the top-left cell, `(0, 0)`, and you hope to travel to the bottom-right cell, `(rows-1, columns-1)` (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum **effort**.

A route's **effort** is the **maximum absolute difference** in heights between two consecutive cells of the route. Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

## Analysis

1.  **Graph Problem**:
    -   Cells are nodes. Edges exist between adjacent cells.
    -   Weight of edge $(u, v)$ is $|heights[u] - heights[v]|$.
    -   Cost of a path is $\max(\text{weights edges})$.
    -   We want to minimize this cost. This is a "Bottleneck Path" problem.

2.  **Algorithms**:
    -   **Modified Dijkstra**:
        -   `dist[i][j]` stores the min effort to reach `(i, j)`.
        -   Start PQ with `(0, 0, 0)`.
        -   When relaxing, `newEffort = max(currentEffort, edgeWeight)`.
        -   If `newEffort < dist[next]`, update and push.
    -   **Binary Search + BFS/DFS**:
        -   Guess effort `k`.
        -   Check if path exists using only edges with weight $\le k$.
        -   Range of weights $0 \dots 10^6$.
        -   Complexity $O(MN \log(\text{MaxHeight}))$.
    -   **Kruskal's / Union Find**:
        -   Sort all edges by weight.
        -   Union cells. Stop when start and end are connected.
        -   Complexity $O(MN \log(MN))$.

    Dijkstra is generally fastest and easiest to implement for grid problems given standard library PQs.

3.  **Complexity (Dijkstra)**:
    -   Nodes $V = MN$. Edges $E \approx 4MN$.
    -   $O(E \log V)$. Given $N, M \le 100$, $10^4$ nodes. $4 \cdot 10^4 \log(10^4)$ ops. Extremely fast.

## Implementation Details
-   `PriorityQueue<int[]>`. `int[]` = `{effort, row, col}`.
-   `dist` array initialized to MAX_VALUE.
