# Problem Analysis: Process Restricted Friend Requests

## Problem Description
`n` people. `restrictions[]` (pair cannot be friends). `requests[]` (u, v want to be friends).
Friendship is transitive (connected component).
For each request: check if accepting it violates ANY restriction.
If safe, accept (return true). Else, reject (return false).

## Analysis

1.  **Union-Find with Validation**:
    -   Maintain connected components (friends).
    -   `restrictions`: List of banned pairs.
    -   For request `(u, v)`:
        -   Find roots `rootU` and `rootV`.
        -   If `rootU == rootV`: already friends. Safe.
        -   If different:
            -   Check if merging `rootU` and `rootV` violates any restriction.
            -   Iterate all restrictions `(x, y)`.
            -   Find `rootX` and `rootY`.
            -   If `(rootX == rootU && rootY == rootV)` or `(rootX == rootV && rootY == rootU)`: Violation!
            -   Basically, check if any restriction connects the two components we are about to merge.
    -   Optimization?
        -   `n` is 1000. `restrictions` 1000. `requests` 1000.
        -   Check logic: Iterate restrictions. Cost `M`.
        -   Total cost `K * M * alpha(N)`. $10^6$ ops. Feasible.

## Implementation Details
-   UF Class.
-   Loop requests.
