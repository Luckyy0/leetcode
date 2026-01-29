# Problem Analysis: Graph Connectivity With Threshold

## Problem Description
We have `n` cities labeled `1` to `n`. Two cities `a` and `b` are connected if there exists an integer `z > threshold` such that `a % z == 0` and `b % z == 0` (i.e., `z` is a common divisor).
Given `queries` where `queries[i] = [ai, bi]`, check if `ai` and `bi` are connected.

## Analysis

1.  **Common Divisor Property**:
    -   If `a` and `b` share a divisor `z > threshold`, they are connected directly.
    -   Connectivity is transitive. If `a` connects to `b` (via `z1`) and `b` connects to `c` (via `z2`), then `a` connects to `c`.
    -   We have essentially sets of numbers: Multiples of $z$ for each $z > threshold$. Each set forms a connected component (clique). Since numbers can belong to multiple sets, these components merge.

2.  **Algorithm**:
    -   Union-Find (DSU) structure for numbers `1` to `n`.
    -   Iterate $z$ from `threshold + 1` to `n`.
    -   For each $z$, iterate its multiples: $2z, 3z \dots$.
    -   Union $z$ with $2z$. Union $z$ with $3z$...
    -   This effectively connects all multiples of $z$ together.
    -   Optimization: Start checking multiples from $z$. If `threshold` is large, loops are fast. If `threshold` is 0, loops are $N \log N$.
    -   Query: `find(a) == find(b)`.

3.  **Complexity**:
    -   Time: $O(N \log N \cdot \alpha(N) + Q \cdot \alpha(N))$.
    -   Space: $O(N)$.

## Implementation Details
-   DSU class.
-   Loop `i` from `threshold + 1` to `n`. Inner loop `j` from `2*i` to `n` step `i`.
