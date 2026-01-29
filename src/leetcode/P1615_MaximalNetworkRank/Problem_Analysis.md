# Problem Analysis: Maximal Network Rank

## Problem Description
There is an infrastructure of `n` cities with some road connecting these cities. Each `roads[i] = [ai, bi]` indicates that there is a bidirectional road between cities `ai` and `bi`.
The **network rank** of two different cities is defined as the total number of directly connected roads to either city. If a road is directly connected to both cities, it is only counted once.
The **maximal network rank** of the infrastructure is the maximum network rank of all pairs of different cities.
Return the maximal network rank.

## Analysis

1.  **Definitions**:
    -   `Rank(i, j) = Degree(i) + Degree(j) - IsConnected(i, j)`.
    -   `IsConnected(i, j)` is 1 if there is an edge between i and j, else 0.

2.  **Algorithm**:
    -   Compute degrees for all nodes.
    -   Store edges in a boolean adjacency matrix `connected[n][n]` for $O(1)$ lookup.
    -   Iterate all pairs `(i, j)` where `0 <= i < j < n`.
    -   Calculate rank.
    -   Update max.

3.  **Complexity**:
    -   Time: $O(N^2)$ to iterate pairs. $O(E)$ to build graph. Total $O(N^2 + E)$.
    -   Space: $O(N^2)$ for adjacency matrix (Since N up to 100, this is small, $10000$ bools).

## Implementation Details
-   `boolean[][] connected`.
-   `int[] degree`.
