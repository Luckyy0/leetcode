# Problem Analysis: Minimize Hamming Distance After Swap Operations

## Problem Description
`source`, `target`. `allowedSwaps` pairs.
Swap chars in `source` using allowed pairs indefinitely.
Min Hamming distance (diff chars at same index).

## Analysis

1.  **Union Find**:
    -   `allowedSwaps` defines connected components of indices.
    -   Indices in same component can be permuted to any order.
    -   For each component:
        -   Count frequencies of chars in `source` at these indices.
        -   Count frequencies of chars in `target` at these indices.
        -   Intersection count = sum of `min(countSource[c], countTarget[c])`.
        -   Matches possible = intersection count.
        -   Mismatches = Component Size - Matches.
    -   Sum mismatches over all components.

2.  **Complexity**:
    -   Time: $O(N \alpha(N))$.
    -   Space: $O(N)$.

## Implementation Details
-   UF class.
-   Map or array for counting (since numbers used?) `source[i]` is value. Values up to $10^5$. Use Map.
