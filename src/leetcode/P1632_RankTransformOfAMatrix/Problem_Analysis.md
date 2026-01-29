# Problem Analysis: Rank Transform of a Matrix

## Problem Description
Given an `m x n` matrix, return a new matrix `answer` where `answer[row][col]` is the rank of `matrix[row][col]`.
The rank is an integer that represents how large an element is compared to other elements. It is calculated using the following rules:
-   The rank is an integer starting from 1.
-   If two elements `p` and `q` are in the same row or column, then:
    -   If `p < q`, then `rank(p) < rank(q)`.
    -   If `p == q`, then `rank(p) == rank(q)`.
    -   If `p > q`, then `rank(p) > rank(q)`.
-   The rank should be as small as possible.

## Analysis

1.  **Dependencies**:
    -   Let `R[i][j]` be the rank of cell `(i, j)`.
    -   `R[i][j]` depends on elements in row `i` and column `j` that are strictly smaller than `matrix[i][j]`.
    -   Specifically, `R[i][j] >= max(rank of neighbors in row/col < val) + 1`.
    -   Or effectively: Track `maxRankInRow[i]` and `maxRankInCol[j]`.
    -   Process values in increasing order.
    -   For a specific value `v`, consider all positions `(r, c)` where `mat[r][c] == v`.
    -   These positions might be connected. E.g. `(r1, c1)` and `(r1, c2)` have same value (same row). Then they must have same rank. `(r1, c2)` and `(r2, c2)` same value (same col) -> same rank.
    -   This forms "Connected Components" of identical values sharing rows/cols.
    -   For each component of value `v`:
        -   The rank must be greater than any "smaller value rank" seen so far in all involved rows and cols.
        -   `baseRank = max(maxRowRank[r], maxColRank[c])` for all `r, c` in component.
        -   `finalRank = baseRank + 1`.
    -   Update `maxRowRank` and `maxColRank` with `finalRank` for all involved rows/cols.

2.  **Algorithm**:
    -   Group cells by value. `TreeMap<Value, List<int[]>>`.
    -   Iterate values `v` from smallest to largest:
        -   Cells `(r, c)` with val `v`.
        -   Use Union-Find to group these cells into components. (Two cells connected if share row or share col).
            -   Actually, simpler: Union indices `r` and `c + m`. (Row nodes 0..m-1, Col nodes m..m+n-1).
            -   For each `(r, c)`, union `r` and `c + m`.
        -   Group cells by component root.
        -   For each group (component):
            -   Calculating `maxRank` seen so far in involved rows/cols.
            -   `rank = max(rowMax[r], colMax[c]) + 1` for all `r, c` in group.
            -   Assign rank to matrix.
            -   Update `rowMax[r] = rank`, `colMax[c] = rank`.

3.  **Complexity**:
    -   Time: $O(MN \log(MN))$ (sorting/TreeMap). Union Find is nearly linear.
    -   Space: $O(MN)$.

## Implementation Details
-   DSU helper within loop. We can reuse a specialized DSU logic or just adjacency list for small components.
-   Since we iterate per unique value, the number of nodes in graph is small per iteration. Rebuilding/Clearing DSU? Or just ad-hoc connected components.
-   Ad-hoc using `HashMap` and DFS/BFS is fine.
